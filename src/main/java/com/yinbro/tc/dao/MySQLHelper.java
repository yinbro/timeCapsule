package com.yinbro.tc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLHelper {
	public static final String url = "jdbc:mysql://127.0.0.1/tc";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "yinbro";

	public static Connection conn = null;

	// 获得Connection对象
	public static Connection getConnection() {
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

	
	
	// 关闭Connection对象
	public void closeConnection() {
		try {
			MySQLHelper.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
