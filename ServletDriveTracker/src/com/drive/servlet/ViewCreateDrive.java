package com.drive.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drive.dao.DAOUtil;
import com.drive.utility.UtilityJson;
import com.drvie.pojo.Drive;

@WebServlet("/ViewCreateDrive")
public class ViewCreateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCreateDrive() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Drive> list = DAOUtil.viewDrive();
			String responseData = (String) UtilityJson.getJSONFromObject(list);
			response.getWriter().write(responseData);
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
