package com.DriveTracke.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.Drivetracker.dao.DAOUtil;
import com.DrvieTracker.pojo.CreateDrive;

@WebServlet("/ViewCreateDrive")
public class ViewCreateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCreateDrive() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = DAOUtil.dBConnection();
			PreparedStatement p = con.prepareStatement("select * from drive");
			ResultSet rs = p.executeQuery();
			ArrayList<CreateDrive> aList = new ArrayList<>();
			while (rs.next()) {
				CreateDrive obj = new CreateDrive();
				obj.setId(rs.getInt(1));
				obj.setCompanyname(rs.getString(2));
				obj.setResource(rs.getInt(3));
				obj.setExp(rs.getInt(4));
				obj.setCtc(rs.getFloat(5));
				obj.setJoining(rs.getInt(6));
				obj.setEducation(rs.getInt(10));
				obj.setPosition(rs.getInt(8));
				obj.setFollowup(rs.getDate(9));
				obj.setBond(rs.getInt(7));
				aList.add(obj);
			}
			System.out.println(aList);
			ObjectMapper mp = new ObjectMapper();
			String s1 = mp.writeValueAsString(aList);
			PrintWriter pw = response.getWriter();
			pw.write(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
