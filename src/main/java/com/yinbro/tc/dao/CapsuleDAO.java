package com.yinbro.tc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yinbro.tc.pojo.CapsuleBean;

public class CapsuleDAO {

	/**
	 * 
	 * @param capsule
	 * @return
	 * @throws SQLException
	 */
	public boolean createCapsule(CapsuleBean capsule) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO tb_capsule (cwxopenid,ckey,cputTime,cpreOpenTime,cactOpenTime,cpreShowText,ccid,cisSnap,cQrImgUrl,csubject)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, capsule.getWxopenid());
			ps.setString(2, capsule.getKey());
			ps.setString(3, capsule.getPutTime());
			ps.setString(4, capsule.getPreOpenTime());
			ps.setString(5, capsule.getActOpenTime());
			ps.setString(6, capsule.getPreShowText());
			ps.setInt(7, capsule.getContentid());
			ps.setInt(8, capsule.isSnap() ? 1 : 0);
			ps.setString(9, capsule.getQrImgUrl());
			ps.setString(10, capsule.getSubject());
			// 返回false表示execute成功，在此取反
			return !ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLHelper.closeStatement(ps);
			MySQLHelper.closeConnection(conn);
		}
		return false;
	}

	/**
	 * 
	 * @param strUserName
	 * @param strPassword
	 * @return
	 * @throws SQLException
	 */
	public CapsuleBean queryCapsuleByKey(String strKey) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		Statement stmt = MySQLHelper.createStatement(conn);
		String sql = "SELECT cid,cwxopenid,ckey,cputTime,cpreOpenTime,cactOpenTime,cpreShowText,ccid,cisSnap,cQrImgUrl,csubject FROM tb_capsule WHERE ckey = '"
				+ strKey + "'";

		CapsuleBean capsuleBean = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			// 光标切换到最后一个
			rs.last();
			if (rs.getRow() != 1)
				return null;
			capsuleBean = new CapsuleBean();
			capsuleBean.setId(rs.getInt(1));
			capsuleBean.setWxopenid(rs.getString(2));
			capsuleBean.setKey(rs.getString(3));
			capsuleBean.setPutTime(rs.getString(4));
			capsuleBean.setPreOpenTime(rs.getString(5));
			capsuleBean.setActOpenTime(rs.getString(6));
			capsuleBean.setPreShowText(rs.getString(7));
			capsuleBean.setContentid(rs.getInt(8));
			// 三目运算，为1 即true
			capsuleBean.setSnap(rs.getInt(9) == 1 ? true : false);
			capsuleBean.setQrImgUrl(rs.getString(10));
			capsuleBean.setSubject(rs.getString(11));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MySQLHelper.closeStatement(stmt);
			MySQLHelper.closeConnection(conn);
		}
		return capsuleBean;
	}

}
