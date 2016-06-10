package com.yinbro.tc.handler;

import java.util.Map;

import com.yinbro.tc.dao.UserDAO;
import com.yinbro.tc.pojo.UserBean;
import com.yinbro.tc.util.AppConfig;
import com.yinbro.tc.util.StrUtil;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
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
		// 回复消息
		WxMpXmlOutTextMessage mpXmlOutMessage;
		// 获取消息发送人，与数据库用户进行比较
		String wxopenid = wxMessage.getFromUserName();
		UserDAO dao = new UserDAO();
		UserBean user = null;
		user = dao.findUserByWxID(wxopenid);
		if (user != null) {
			// TODO 如果该用户已经存在，发送欢迎信息
			StringBuffer sb = new StringBuffer();
			sb.append(user.getName()+ "你好！\n");
			sb.append("    欢迎回到时间胶囊系统~\n\n");
			sb.append("    1.<a href = '" + AppConfig.appUrl + "/newCapsule?wxopenid=" + wxopenid + "'>创建胶囊</a>\n\n");
			sb.append("    2.<a href = '" + AppConfig.appUrl + "/home?wxopenid=" + wxopenid + "'>个人中心</a>\n\n");
			sb.append("    3.<a href = '" + AppConfig.appUrl + "/shop" + "'>实体商城</a>\n\n");
			content = StrUtil.str2ISO8859(sb.toString());
		} else {
			// TODO 如果该用户不存在，发送用户注册完善连接
			StringBuffer sb = new StringBuffer();
			sb.append("第一次光临时间胶囊吧?\n\n");
			sb.append("介绍一下自己吧~\n");
			sb.append("点此<a href = '" + AppConfig.appUrl + "/register?wxopenid=" + wxopenid + "'>完善注册信息</a>");
			content = StrUtil.str2ISO8859(sb.toString());
		}

		mpXmlOutMessage = WxMpXmlOutMessage.TEXT().fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).content(content).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();

		return mpXmlOutMessage;
	}

}
