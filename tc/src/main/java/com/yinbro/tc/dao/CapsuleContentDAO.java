package com.yinbro.tc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yinbro.tc.pojo.CapsuleContentBean;

public class CapsuleContentDAO {

	public int createCapsuleContent(CapsuleContentBean ccb) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		String srcContent = ccb.getCccontent();
//		System.out.println(srcContent);
		int key = 0;;
		
		Statement stmt = null;
		String sql = "INSERT INTO tb_cap_content (cccontent) VALUES ( '"+ srcContent + "')";
		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			key = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLHelper.closeConnection(conn);
		}
		return key;
	}

	public CapsuleContentBean queryCapsuleContentByID(int id) {
		MySQLHelper helper = new MySQLHelper();
		Connection conn = helper.getConnection();
		Statement stmt = MySQLHelper.createStatement(conn);
		String sql = "SELECT ccid,cccontent FROM tb_cap_content WHERE ccid = '" + id + "'";

		CapsuleContentBean capsuleContentBean = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			// 光标切换到最后一个
			rs.last();
			if (rs.getRow() != 1)
				return null;
			capsuleContentBean = new CapsuleContentBean();
			capsuleContentBean.setCcid(rs.getInt(1));
			capsuleContentBean.setCccontent(rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLHelper.closeStatement(stmt);
			MySQLHelper.closeConnection(conn);
		}
		return capsuleContentBean;
	}

}
