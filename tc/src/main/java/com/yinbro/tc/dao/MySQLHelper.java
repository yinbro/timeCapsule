package com.yinbro.tc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLHelper {
	public static final String url = "jdbc:mysql://127.0.0.1/tc";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root";

	public Connection conn = null;

	// 获得Connection对象
	public Connection getConnection() {
		if (conn != null)
			return conn;
		try {
			Class.forName(name);// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);// 获取连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 创建Statement
	public static Statement createStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	// 关闭Connection对象
	public static void closeConnection(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭Statement对象
	public static void closeStatement(Statement stmt) {
		if (stmt == null) {
			return;
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
