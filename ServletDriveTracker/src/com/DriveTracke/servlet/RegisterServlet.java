package com.DriveTracke.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Drivetracker.dao.DAOUtil;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		System.out.println("inside of Register servlet ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String str = reader.readLine();
		System.out.println(str);

		try {
			Connection con = DAOUtil.dBConnection();
			PreparedStatement p = con.prepareStatement(
					"insert into tpo (TPO_NAME,TPO_EMAIL,TPO_USERNAME,TPO_PASSWORD,CREATION_DATE,ROLE) values()");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
