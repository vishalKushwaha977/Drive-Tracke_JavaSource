package com.drive.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.drive.dao.DAOUtil;
import com.drvie.pojo.Login;

@WebServlet("/TpoLogin")
public class TpoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader bReader = request.getReader();
		String s = bReader.readLine();
		ObjectMapper mp = new ObjectMapper();
		Login login = mp.readValue(s, Login.class);
		String emailString = login.getEmail();
		String passwString = login.getPassword();
		int t;
		try {
			t = DAOUtil.logintpo(emailString, passwString);
			PrintWriter pw = response.getWriter();
			if (t == 1) {
				pw.write("admin");
			}
			if (t == 2) {
				pw.write("TPO");
			}
			if (t == 0) {
				pw.write("sorry try again");
			}
		} catch (Exception e) {
		}
	}
}