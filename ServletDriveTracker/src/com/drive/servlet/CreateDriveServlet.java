package com.drive.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drive.dao.DAOUtil;
import com.drive.utility.UtilityJson;
import com.drvie.pojo.Drive;

@WebServlet("/CreateDrive")
public class CreateDriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateDriveServlet() {
		System.out.println("inside CreateDrive constructor");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String requestdata = reader.readLine();
		Drive createdriver = (Drive) UtilityJson.getObjectFromJSON(requestdata, Drive.class);

		Map<String, String> map = null;
		try {
			map = DAOUtil.SaveDrive(createdriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String responsedata = (String) UtilityJson.getJSONFromObject(map);
		PrintWriter pw = response.getWriter();
		pw.write(responsedata);

		// response.getWriter().write();
	}
}
