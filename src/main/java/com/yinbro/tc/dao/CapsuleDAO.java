package com.yinbro.tc.dao;

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
	public boolean createCapsule(CapsuleBean capsule) throws SQLException {
		String sql = "INSERT INTO tb_capsule (cuserid,ckey,cputTime,cpreOpenTime,cactOpenTime,cpreShowText,ccontent,cisSnap)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = MySQLHelper.getConnection().prepareStatement(sql);

		ps.setInt(1, capsule.getUserid());
		ps.setString(2, capsule.getKey());
		ps.setTimestamp(3, capsule.getPutTime());
		ps.setTimestamp(4, capsule.getPreOpenTime());
		ps.setTimestamp(5, capsule.getActOpenTime());
		ps.setString(6, capsule.getPreShowText());
		ps.setString(7, capsule.getContent());
		ps.setInt(8, capsule.isSnap()?1:0);
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
	public CapsuleBean queryCapsuleByKey(String strKey) throws SQLException {

		String sql = "SELECT cid,cuserid,ckey,cputTime,cpreOpenTime,cactOpenTime,cpreShowText,ccontent,cisSnap FROM tb_capsule WHERE ckey = '"
				+ strKey + "'";
//		System.out.println(sql);

		Statement stmt = MySQLHelper.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		// 光标切换到最后一个
		rs.last();
		if (rs.getRow() != 1)
			return null;

		CapsuleBean capsuleBean = new CapsuleBean();
		capsuleBean.setId(rs.getInt(1));
		capsuleBean.setUserid(rs.getInt(2));
		capsuleBean.setKey(rs.getString(3));
		capsuleBean.setPutTime(rs.getTimestamp(4));
		capsuleBean.setPreOpenTime(rs.getTimestamp(5));
		capsuleBean.setActOpenTime(rs.getTimestamp(6));
		capsuleBean.setPreShowText(rs.getString(7));
		capsuleBean.setContent(rs.getString(8));
		//三目运算，为1 即true
		capsuleBean.setSnap(rs.getInt(9)==1?true:false);

		return capsuleBean;
	}

}
