package com.DriveTracke.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.Drivetracker.dao.DAOUtil;
import com.DrvieTracker.pojo.Login;

@WebServlet("/TpoLogin")
public class TpoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader bReader = request.getReader();

		String s = bReader.readLine();
		System.out.println(s);
		ObjectMapper mp = new ObjectMapper();
		Login login = mp.readValue(s, Login.class);
		System.out.println(login);
		String emailString = login.getEmail();
		String passwString = login.getPassword();
		System.out.println("email=" + emailString);
		System.out.println("pass=" + passwString);
		try {
			Connection con = DAOUtil.dBConnection();
			System.out.println("inside the try catch block");
			PreparedStatement p = con.prepareStatement("select * from tpo");
			ResultSet rs = p.executeQuery();

			int c = 0;
			while (rs.next()) {
				if (emailString.equals(rs.getString(3)) && passwString.equals(rs.getString(5)) && rs.getInt(7) == 1) {
					c = 1;
					break;
				}
				if (emailString.equals(rs.getString(3)) && passwString.equals(rs.getString(5)) && rs.getInt(7) == 0) {
					c = 2;
					break;
				}

			}
			PrintWriter pw = response.getWriter();
			if (c == 1) {
				System.out.println("admin");
				pw.write("admin");
			}
			if (c == 2) {
				System.out.println("tpo");
				pw.write("TPO");
			}
			if (c == 0) {
				System.out.println("sorry");
				pw.write("sorry try again");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}