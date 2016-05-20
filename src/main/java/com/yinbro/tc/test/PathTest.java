package com.yinbro.tc.test;

import com.yinbro.tc.dao.CapsuleContentDAO;
import com.yinbro.tc.pojo.CapsuleContentBean;

public class PathTest {
	public static void main(String[] args){
//		QrCodeUtil.getQrCodeImg("http://blog.csdn.net/gao36951/article/details/41148075");
//		QrCodeUtil.getStrFromQr(new File("C:\\Users\\yinya\\Desktop\\new.png") );
		CapsuleContentDAO contentDAO = new CapsuleContentDAO();
		CapsuleContentBean bean = new CapsuleContentBean();
		bean.setCcid(1);
		bean.setCccontent("111");
		contentDAO.createCapsuleContent(bean);
	}

}
