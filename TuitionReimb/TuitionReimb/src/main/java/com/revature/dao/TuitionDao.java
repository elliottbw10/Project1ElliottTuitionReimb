package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.empForm;
import com.revature.beans.employee;
import com.revature.servlet.BLog;
import com.revature.servlet.LoginServ;
import com.revature.servlet.SLog;
import com.revature.util.ConnFactory;
import com.revature.util.MathTime;

public class TuitionDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public static int randNum = (int) (Math.random() * 999) + 1;
	
	private static final MathTime mt = new MathTime();
	
	public static employee checkUser(String id) {
		
		employee st=null;
		//boolean rt = false;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM EMP2 WHERE USER_NAME=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			//ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			//System.out.println(id);
			while(rs.next()) {
				st = new employee(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5)
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public void insertForm(empForm ef) throws SQLException{
		Connection conn = cf.getConnection();
		//System.out.println(LoginServ.userName);
		String sql = "INSERT INTO TRMS2 VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ef.getuName());
		ps.setString(2, ef.getfName());
		ps.setString(3, ef.getlName());
		ps.setString(4, ef.getClassType());
		ps.setInt(5, ef.getClassCost());
		ps.setString(6, ef.getClassGrade());
		ps.setString(7, ef.getDescript());
		ps.setDate(8, ef.getClassStart());
		ps.setInt(9, randNum);
		ps.setInt(10, 0);
		ps.setInt(11, 1);
		ps.setInt(12, 2);
		ps.setString(13, ef.getReason());
		ps.executeUpdate();
	}
	
	public empForm getFormbyID(int id) throws SQLException{
		empForm ef = null;
		String name = LoginServ.userName;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TRMS2 WHERE FORM_ID= " + id + "AND U_NAME = '" + name + "'");
		while(rs.next()) {
			ef = new empForm(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDate(8),rs.getInt(9)
					, rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
		}
		
		return ef;
	}
	
	public empForm getFormbySID(int id) throws SQLException{
		empForm ef = null;
		String name = SLog.userName;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TRMS2 WHERE FORM_ID= " + id + "AND U_NAME = '" + name + "'");
		while(rs.next()) {
			ef = new empForm(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDate(8),rs.getInt(9)
					, rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
		}
		
		return ef;
	}
	
	public empForm getFormbyBID(int id) throws SQLException{
		empForm ef = null;
		String name = BLog.userName;
		System.out.println(name);
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TRMS2 WHERE FORM_ID= " + id);
		while(rs.next()) {
			ef = new empForm(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5), rs.getString(6), rs.getString(7), rs.getDate(8),rs.getInt(9)
					, rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
		}
		
		return ef;
	}
	
public static employee SupercheckUser(String id) {
		
		employee st=null;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM SUPER2 WHERE USER_NAME=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				st = new employee(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5)
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}

public static employee HeadcheckUser(String id) {
	
	employee st=null;
	try {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM DEP_HEAD2 WHERE USER_NAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			st = new employee(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5)
					);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return st;
}

public static employee BencheckUser(String id) {
	
	employee st=null;
	try {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BENCO2 WHERE USER_NAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			st = new employee(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5)
					);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return st;
}

public static employee OvercheckUser(String id) {
	
	employee st=null;
	try {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM OVERLORD2 WHERE USER_NAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			st = new employee(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5)
					);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return st;
}

public void Approve(int num) throws SQLException{
	Connection conn = cf.getConnection();
	String sql = "UPDATE TRMS2 SET APP_CODE1 =" +100+ " WHERE FORM_ID =" + num;
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.executeUpdate();
}

public void Deny(int num, String reas) throws SQLException{
	Connection conn = cf.getConnection();
	String a = "Denied";
	String sql = "UPDATE TRMS2 SET APP_CODE1 =" +404+ " WHERE FORM_ID =" + num;
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.executeUpdate();
	
	String sql2 = "UPDATE TRMS2 SET REASON ='" +reas+ "' WHERE FORM_ID =" + num;
	PreparedStatement ps2 = conn.prepareStatement(sql2);
	ps2.executeUpdate();
}

public void Approve2(int num) throws SQLException{
	Connection conn = cf.getConnection();
	String sql = "UPDATE TRMS2 SET APP_CODE2 =" +200+ " WHERE FORM_ID =" + num;
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.executeUpdate();
}


public void ApproveBen(int num, int cost, String type, String name) throws SQLException{
	int amtU = 0;
	Connection conn = cf.getConnection();
	Statement stm = conn.createStatement();
	String a = "Approved";
	String sql = "UPDATE TRMS2 SET APP_CODE3 =" +300+ " WHERE FORM_ID =" + num;
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.executeUpdate();
	
	String sql2 = "UPDATE TRMS2 SET REASON ='" +a+ "' WHERE FORM_ID =" + num;
	PreparedStatement ps2 = conn.prepareStatement(sql2);
	ps2.executeUpdate();
	
	if(type.equals("University Course")) {
		ResultSet rs = stm.executeQuery("SELECT * FROM MONEY WHERE USER_NAME = '" + name + "'");
		while(rs.next()) {
			amtU = rs.getInt(2);
		}
		
		int uAmt = mt.University80(amtU, cost);
		
		if(uAmt != 5000) {
			String sql3 = "UPDATE MONEY SET AMT_LEFT =" +uAmt+ "WHERE USER_NAME = '" + name + "'";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.executeUpdate();
		}
	}
	
	else if(type.equals("Seminar")) {
		ResultSet rs = stm.executeQuery("SELECT * FROM MONEY WHERE USER_NAME = '" + name + "'");
		while(rs.next()) {
			amtU = rs.getInt(2);
		}
		
		int uAmt = mt.Seminar60(amtU, cost);
		
		if(uAmt != 5000) {
			String sql4 = "UPDATE MONEY SET AMT_LEFT =" +uAmt+ "WHERE USER_NAME = '" + name + "'";
			PreparedStatement ps4 = conn.prepareStatement(sql4);
			ps4.executeUpdate();
		}
	}
	
	else if(type.equals("Certification Prep")) {
		ResultSet rs = stm.executeQuery("SELECT * FROM MONEY WHERE USER_NAME = '" + name + "'");
		while(rs.next()) {
			amtU = rs.getInt(2);
		}
		
		int uAmt = mt.Prep75(amtU, cost);
		
		if(uAmt != 5000) {
			String sql5 = "UPDATE MONEY SET AMT_LEFT =" +uAmt+ "WHERE USER_NAME = '" + name + "'";
			PreparedStatement ps5 = conn.prepareStatement(sql5);
			ps5.executeUpdate();
		}
	}
	
	else if(type.equals("Certification")) {
		ResultSet rs = stm.executeQuery("SELECT * FROM MONEY WHERE USER_NAME = '" + name + "'");
		while(rs.next()) {
			amtU = rs.getInt(2);
		}
		
		int uAmt = mt.Cert100(amtU, cost);
		
		if(uAmt != 5000) {
			String sql6 = "UPDATE MONEY SET AMT_LEFT =" +uAmt+ "WHERE USER_NAME = '" + name + "'";
			PreparedStatement ps6 = conn.prepareStatement(sql6);
			ps6.executeUpdate();
		}
	}
	
	else if(type.equals("Technical Training")) {
		ResultSet rs = stm.executeQuery("SELECT * FROM MONEY WHERE USER_NAME = '" + name + "'");
		while(rs.next()) {
			amtU = rs.getInt(2);
		}
		
		int uAmt = mt.Train90(amtU, cost);
		
		if(uAmt != 5000) {
			String sql7 = "UPDATE MONEY SET AMT_LEFT =" +uAmt+ "WHERE USER_NAME = '" + name + "'";
			PreparedStatement ps7 = conn.prepareStatement(sql7);
			ps7.executeUpdate();
		}
	}
	
	else if(type.equals("Other")) {
		ResultSet rs = stm.executeQuery("SELECT * FROM MONEY WHERE USER_NAME = '" + name + "'");
		while(rs.next()) {
			amtU = rs.getInt(2);
		}
		
		int uAmt = mt.Other30(amtU, cost);
		
		if(uAmt != 5000) {
			String sql8 = "UPDATE MONEY SET AMT_LEFT =" +uAmt+ "WHERE USER_NAME = '" + name + "'";
			PreparedStatement ps8 = conn.prepareStatement(sql8);
			ps8.executeUpdate();
		}
	}
}

}
