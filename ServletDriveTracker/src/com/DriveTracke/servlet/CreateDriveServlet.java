package com.DriveTracke.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.Drivetracker.dao.DAOUtil;
import com.DrvieTracker.pojo.CreateDrive;

@WebServlet("/CreateDrive")
public class CreateDriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateDriveServlet() {
		System.out.println("inside CreateDrive constructor");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String str = reader.readLine();
		System.out.println(str);

		ObjectMapper mapper = new ObjectMapper();
		CreateDrive createdriver = mapper.readValue(str, CreateDrive.class);
		System.out.println(createdriver);

		try {
			Connection con = DAOUtil.dBConnection();
			PreparedStatement p = con.prepareStatement("insert into drive(COMPANY_NAME   ,    NO_OF_RSRCS   , "
					+ "  EXP_REQ   ,  CTC ,  JOIN_CRT    , POSITION  ,  EDU_CRT , FOLLOWUP   ,   BOND ) values(? , ? , ? , ? , ? , ? , ? , ? , ?)");
			p.setObject(1, createdriver.getCompanyname());
			p.setObject(2, createdriver.getResource());
			p.setObject(3, createdriver.getExp());
			p.setObject(4, createdriver.getCtc());
			p.setObject(5, createdriver.getJoining());
			p.setObject(6, createdriver.getPosition());
			p.setObject(7, createdriver.getEducation());
			p.setObject(8, createdriver.getFollowup());
			p.setObject(9, createdriver.getBond());
			int status = p.executeUpdate();
			Map<String, String> m = new HashMap<>();
			if (status == 1) {
				m.put("msg", "succesfully register");
			} else {
				m.put("msg", "error");
			}

			System.out.println("map object=" + m);
			String jsonstr = mapper.writeValueAsString(m);

			System.out.println("json string=" + jsonstr);
			PrintWriter pw = response.getWriter();
			pw.write(jsonstr);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
