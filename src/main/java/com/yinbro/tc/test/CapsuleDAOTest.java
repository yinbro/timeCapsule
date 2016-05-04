package com.yinbro.tc.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import com.yinbro.tc.dao.CapsuleDAO;
import com.yinbro.tc.pojo.CapsuleBean;
import com.yinbro.tc.util.MD5Util;

public class CapsuleDAOTest {

	@Test
	public void createCapsule() {
		System.out.println("胶囊创建测试");
		
		CapsuleBean capsuleBean = new CapsuleBean();
		//生成以时间为种子的MD5 KEY
		long l  = new Date().getTime();
		String strTime = Long.toString(l);
		String key = MD5Util.getMD5Code(strTime);
		capsuleBean.setUserid(10);
		capsuleBean.setKey(key);
		capsuleBean.setPutTime(new Timestamp(new Date().getTime()));
		capsuleBean.setPreOpenTime(new Timestamp(new Date().getTime()));
		capsuleBean.setActOpenTime(new Timestamp(new Date().getTime()));
		capsuleBean.setPreShowText("未到时间，无法打开");
		capsuleBean.setContent("时间胶囊内容");
		capsuleBean.setSnap(true);

		CapsuleDAO capsuleDAO = new CapsuleDAO();
		try {
			System.out.println("创建是否成功：" + capsuleDAO.createCapsule(capsuleBean));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	@Test
	public void queryCapsuleByKey() throws SQLException {
		System.out.println("胶囊查询测试");
		CapsuleBean capsuleBean = new CapsuleBean();
		CapsuleDAO capsuleDAO = new CapsuleDAO();
		capsuleBean = capsuleDAO.queryCapsuleByKey("d34ebd8ea83d6d843a7a0b6493b69c32");
		System.out.println(capsuleBean);
		
	}
}
