package com.yinbro.tc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yinbro.tc.pojo.UserBean;
import com.yinbro.tc.util.MD5Util;

public class UserDAO {

	/**
	 * 
	 * @param user
	 * @return 是否注册成功
	 * @throws SQLException
	 */
	public boolean signUp(UserBean user) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		boolean isExist = false;
		// 先判断用户名是否已经存在
		if (isUserExist(user.getName()))
			return false;
		// 判断该微信用户是否已经注册
		if (isWxopenidExist(user.getWxopenid()))
			return false;
		String sql = "INSERT INTO tb_user (uname, ugender,upassword,ushowmsg,utel,uwxopenid,uemail,uwxname) "
				+ "VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getGender());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getShowMsg());
			ps.setString(5, user.getTele());
			ps.setString(6, user.getWxopenid());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getWxname());
			// 返回false表示execute成功，在此取反
			isExist = !ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLHelper.closeStatement(ps);
			MySQLHelper.closeConnection(conn);
		}

		return isExist;
	}

	/**
	 * 
	 * @param strUserName
	 * @param strPassword
	 * @return
	 * @throws SQLException
	 */
	public UserBean login(String strUserName, String strStrPSW) {
		String strPassword = MD5Util.getMD5Code(strStrPSW);
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		String sql = "SELECT * FROM tb_user WHERE uname = '" + strUserName + "' and upassword = '" + strPassword + "'";
		// System.out.println(sql);

		Statement stmt = MySQLHelper.createStatement(conn);
		ResultSet resultSet = null;
		UserBean user = null;
		try {
			resultSet = stmt.executeQuery(sql);
			// 光标切换到最后一个
			resultSet.last();
			if (resultSet.getRow() != 1)
				return null;
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setGender(resultSet.getInt(3));
			// 4 是用户密码，在此不获取
			user.setShowMsg(resultSet.getString(5));
			user.setTele(resultSet.getString(6));
			user.setWxopenid(resultSet.getString(7));
			user.setEmail(resultSet.getString(8));
			user.setWxname(resultSet.getString(9));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLHelper.closeStatement(stmt);
			MySQLHelper.closeConnection(conn);
		}

		return user;
	}

	// 更新用户信息
	public boolean updateUser(UserBean user) {
		// TODO
		return false;
	}

	/**
	 * private 判断用户是否已存在
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static boolean isUserExist(String uname) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT uname FROM tb_user WHERE uname = '" + uname + "'";
			ResultSet resultSet = stmt.executeQuery(sql);
			// 光标切换到最后一个
			resultSet.last();
			if (resultSet.getRow() == 1)
				return true;
		} catch (Exception e) {
		} finally {
			MySQLHelper.closeStatement(stmt);
			MySQLHelper.closeConnection(conn);
		}
		return false;
	}

	private boolean isWxopenidExist(String wxopenid) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM tb_user WHERE uwxopenid = '" + wxopenid + "'";
			ResultSet resultSet = stmt.executeQuery(sql);
			// 光标切换到最后一个
			resultSet.last();
			if (resultSet.getRow() == 1)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			MySQLHelper.closeStatement(stmt);
			MySQLHelper.closeConnection(conn);

		}
		return false;
	}

	/**
	 * 
	 * @param wxopenid
	 * @return
	 * @throws SQLException
	 */
	public UserBean findUserByWxID(String wxopenid) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();

		String sql = "SELECT * FROM tb_user WHERE uwxopenid = '" + wxopenid + "'";
		// System.out.println(sql);

		Statement stmt = null;
		UserBean user = null;
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			// 光标切换到最后一个
			resultSet.last();
			if (resultSet.getRow() != 1)
				return null;

			user = new UserBean();
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setGender(resultSet.getInt(3));
			// 4 是用户密码，在此不获取
			user.setShowMsg(resultSet.getString(5));
			user.setTele(resultSet.getString(6));
			user.setWxopenid(resultSet.getString(7));
			user.setEmail(resultSet.getString(8));
			user.setWxname(resultSet.getString(9));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLHelper.closeStatement(stmt);
			MySQLHelper.closeConnection(conn);
		}

		return user;
	}

}
