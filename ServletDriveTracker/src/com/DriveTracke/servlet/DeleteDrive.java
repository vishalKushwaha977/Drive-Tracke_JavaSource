package com.DriveTracke.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Drivetracker.dao.DAOUtil;

@WebServlet("/DeleteDrive")
public class DeleteDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteDrive() {
		System.out.println("inside deleteDrive");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getReader().readLine();

		System.out.println(" hiii:=" + str);
		int did = Integer.parseInt(str);
		try {
			Connection con = DAOUtil.dBConnection();
			PreparedStatement ps = con.prepareStatement("delete from drive where DID=?");
			ps.setInt(1, did);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}