package com.yinbro.tc.test;

import java.sql.SQLException;
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
		capsuleBean.setWxopenid("TestWxOpenID");
		capsuleBean.setKey(key);
		capsuleBean.setPutTime("2014-9-4");
		capsuleBean.setPreOpenTime("2014-9-4");
		capsuleBean.setActOpenTime("2014-9-4");
		capsuleBean.setPreShowText("未到时间，无法打开");
		capsuleBean.setContentid(99);
		capsuleBean.setSnap(true);

		CapsuleDAO capsuleDAO = new CapsuleDAO();
		System.out.println("创建是否成功：" + capsuleDAO.createCapsule(capsuleBean));
	}

	
	
	@Test
	public void queryCapsuleByKey() throws SQLException {
		System.out.println("胶囊查询测试");
		CapsuleBean capsuleBean = new CapsuleBean();
		CapsuleDAO capsuleDAO = new CapsuleDAO();
		capsuleBean = capsuleDAO.queryCapsuleByKey("25301c83abe9be9c24eb1eebacc26a3a");
		System.out.println(capsuleBean);
		
	}
}
