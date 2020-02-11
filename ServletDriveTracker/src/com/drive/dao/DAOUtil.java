package com.drive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.drvie.pojo.Drive;
import com.drvie.pojo.Register;

public class DAOUtil {

	public static Connection dBConnection() throws ClassNotFoundException, SQLException {
		// Database Connection
		final String dbDriver = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3307/driver_tracker";
		// Database name to access
		final String USER = "root";
		final String PASS = "root";
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		return con;
	}

	public static Map<String, String> SaveDrive(Drive createdriver) {
		Map<String, String> m = new HashMap<>();
		try (Connection con = DAOUtil.dBConnection();
				PreparedStatement p = con.prepareStatement(Constantdb.createDrive);) {
			p.setObject(1, createdriver.getCompanyname());
			p.setObject(2, createdriver.getResource());
			p.setObject(3, createdriver.getExp());
			p.setObject(4, createdriver.getCtc());
			p.setObject(5, createdriver.getJoining());
			p.setObject(6, createdriver.getPosition());
			p.setObject(7, createdriver.getEducation());
			p.setObject(8, createdriver.getFollowup());
			p.setObject(9, createdriver.getBond());
			p.setObject(10, createdriver.getGST());
			int status = p.executeUpdate();

			if (status == 1) {
				m.put("msg", "succesfully register");
			} else {
				m.put("msg", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	public static ArrayList<Drive> viewDrive() {
		ArrayList<Drive> list = new ArrayList<>();
		try (Connection con = DAOUtil.dBConnection();
				PreparedStatement p = con.prepareStatement(Constantdb.viewDrive);
				ResultSet rs = p.executeQuery();) {
			while (rs.next()) {
				Drive obj = new Drive();
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
				obj.setGST(rs.getString(18));
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Map<String, String> updateDrive(Drive createDrive) {
		Map<String, String> map = new HashMap<>();
		System.out.println(createDrive);
		try (Connection con = DAOUtil.dBConnection();
				PreparedStatement p = con.prepareStatement(Constantdb.updateDrive);) {
			p.setObject(1, createDrive.getCompanyname());
			p.setObject(2, createDrive.getResource());
			p.setObject(3, createDrive.getExp());
			p.setObject(4, createDrive.getCtc());
			p.setObject(5, createDrive.getJoining());
			p.setObject(6, createDrive.getPosition());
			p.setObject(7, createDrive.getEducation());
			p.setObject(8, createDrive.getFollowup());
			p.setObject(9, createDrive.getBond());
			p.setObject(10, createDrive.getGST());
			p.setObject(11, createDrive.getId());
			int status = p.executeUpdate();

			if (status == 1) {
				map.put("msg", "succesfully updated");
			} else {
				map.put("msg", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, String> registeruser(Register register) {
		Map<String, String> map = new HashMap<>();
		try (Connection con = DAOUtil.dBConnection();
				PreparedStatement p = con.prepareStatement(Constantdb.register);) {
			p.setObject(1, register.getName());
			p.setObject(2, register.getEmail());
			p.setObject(3, register.getPassword());
			p.setObject(4, register.getDate());
			p.setObject(5, register.getRole());
			int status = p.executeUpdate();
			if (status == 1) {
				map.put("msg", "succesfully Register");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, String> delete(int did) {

		Map<String, String> map = new HashMap<>();

		try {
			Connection con = DAOUtil.dBConnection();
			PreparedStatement ps = con.prepareStatement(Constantdb.deleteDrive);
			ps.setInt(1, did);
			int status = ps.executeUpdate();
			if (status == 1) {
				map.put("msg", "succesfully Register");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static int logintpo(String emailString, String passwString) {
		int c = 0;
		try {
			Connection con = DAOUtil.dBConnection();
			System.out.println("inside the try catch block");
			PreparedStatement p = con.prepareStatement(Constantdb.login);
			ResultSet rs = p.executeQuery();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
