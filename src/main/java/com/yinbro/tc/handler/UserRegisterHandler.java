package com.yinbro.tc.handler;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Map;

import com.yinbro.tc.dao.UserDAO;
import com.yinbro.tc.pojo.UserBean;
import com.yinbro.tc.util.AppConfig;
import com.yinbro.tc.util.StrUtil;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class UserRegisterHandler implements WxMpMessageHandler {

	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		// 文本消息内容
		String content = "";
		//回复消息
		WxMpXmlOutTextMessage mpXmlOutMessage;
		// 获取消息发送人，与数据库用户进行比较
		String strFromUserName = wxMessage.getFromUserName();
		UserDAO dao = new UserDAO();
		UserBean user = null;
		try {
			user = dao.findUserByWxID(strFromUserName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			// TODO 如果该用户已经存在，发送欢迎信息
			StringBuffer sb = new StringBuffer();
			sb.append(user.getName()+"\n");
			sb.append("欢迎回家~\n");
			sb.append("想<a href = '"
					+ AppConfig.appUrl + "/newCapsule"
					+ "'>创建胶囊</a>吗？");
			content = StrUtil.str2ISO8859(sb.toString());
		} else{
			// TODO 如果该用户不存在，发送用户注册完善连接
			StringBuffer sb = new StringBuffer();
			sb.append("第一次光临时间胶囊吧?\n");
			sb.append("介绍一下自己吧~\n");
			sb.append("点此<a href = '"
					+ AppConfig.appUrl + "/register"
					+ "'>完善注册信息</a>");
			content = StrUtil.str2ISO8859(sb.toString());
		}
		
		
		
		
		if (true) {
			
		} else
			content = StrUtil.str2ISO8859("XXX，欢迎回来！");
		;

		mpXmlOutMessage = WxMpXmlOutMessage.TEXT().fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).content(content).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();

		return mpXmlOutMessage;
	}

}
