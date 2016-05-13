package com.yinbro.tc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yinbro.tc.pojo.UserBean;

public class UserDAO {

	/**
	 * 
	 * @param user
	 * @return 是否注册成功
	 * @throws SQLException
	 */
	public boolean signUp(UserBean user) throws SQLException {

		// 先判断用户名是否已经存在
		if (isUserExist(user.getName()))
			return false;

		String sql = "INSERT INTO tb_user (uname, ugender,upassword,ushowmsg,utel,uwxopenid,uemail,uwxname) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = MySQLHelper.getConnection().prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setInt(2, user.getGender());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getShowMsg());
		ps.setString(5, user.getTele());
		ps.setString(6, user.getWxopenid());
		ps.setString(7, user.getEmail());
		ps.setString(8, user.getWxname());
		// 返回false表示execute成功，在此取反
		return !ps.execute();
	}

	
	/**
	 * 
	 * @param strUserName
	 * @param strPassword
	 * @return
	 * @throws SQLException
	 */
	public UserBean login(String strUserName,String strPassword) throws SQLException{

		
		String sql = "SELECT * FROM tb_user WHERE uname = '" + strUserName + "' and upassword = '" + strPassword + "'";
//		System.out.println(sql);
		
		Statement stmt = MySQLHelper.getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		//光标切换到最后一个
		resultSet.last();
		if (resultSet.getRow() != 1)
			return null;
		
		UserBean user = new UserBean();
		user.setId(resultSet.getInt(1));
		user.setName(resultSet.getString(2));
		user.setGender(resultSet.getInt(3));
		//4 是用户密码，在此不获取
		user.setShowMsg(resultSet.getString(5));
		user.setTele(resultSet.getString(6));
		user.setWxopenid(resultSet.getString(7));
		user.setEmail(resultSet.getString(8));
		user.setWxname(resultSet.getString(9));
		return user;
	}
	
	
	//更新用户信息
	public boolean updateUser(UserBean user){
		//TODO
		return false;
	}
	
	
	/**
	 * private 判断用户是否已存在
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static boolean isUserExist(String uname) throws SQLException {
		Statement stmt = MySQLHelper.getConnection().createStatement();
		String sql = "SELECT uname FROM tb_user WHERE uname = '" + uname + "'";
		ResultSet resultSet = stmt.executeQuery(sql);
		//光标切换到最后一个
		resultSet.last();
		if (resultSet.getRow() == 1)
			return true;
		return false;

	}
	
	


	public UserBean findUserByWxID(String wxopenid) throws SQLException {
		String sql = "SELECT * FROM tb_user WHERE uwxopenid = '" + wxopenid + "'";
//		System.out.println(sql);

		Statement stmt = MySQLHelper.getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		//光标切换到最后一个
		resultSet.last();
		if (resultSet.getRow() != 1)
			return null;
		
		UserBean user = new UserBean();
		user.setId(resultSet.getInt(1));
		user.setName(resultSet.getString(2));
		user.setGender(resultSet.getInt(3));
		//4 是用户密码，在此不获取
		user.setShowMsg(resultSet.getString(5));
		user.setTele(resultSet.getString(6));
		user.setWxopenid(resultSet.getString(7));
		user.setEmail(resultSet.getString(8));
		user.setWxname(resultSet.getString(9));
		return user;
	}

}
