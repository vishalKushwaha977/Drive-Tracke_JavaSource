package com.drive.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drive.dao.DAOUtil;
import com.drive.utility.UtilityJson;
import com.drvie.pojo.Register;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader reader = request.getReader();
		String requestdata = reader.readLine();
		Register register = (Register) UtilityJson.getObjectFromJSON(requestdata, Register.class);
		Map<String, String> map = null;
		try {
			map = DAOUtil.registeruser(register);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String responsedata = (String) UtilityJson.getJSONFromObject(map);
		PrintWriter pw = response.getWriter();
		pw.write(responsedata);
	}
}
