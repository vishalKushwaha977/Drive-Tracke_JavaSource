package com.drive.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drive.dao.DAOUtil;

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
		Map<String, String> map = null;
		try {
			map = DAOUtil.delete(did);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}