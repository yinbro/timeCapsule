package com.yinbro.tc.handler;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

import com.yinbro.tc.dao.UserDAO;
import com.yinbro.tc.pojo.UserBean;
import com.yinbro.tc.util.AppConfig;
import com.yinbro.tc.util.MD5Util;
import com.yinbro.tc.util.QiniuUtil;
import com.yinbro.tc.util.StrUtil;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class ImageHandler implements WxMpMessageHandler {

	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {

		System.out.println(wxMessage.getMsgType());

		QiniuUtil qiniuUtil = new QiniuUtil();
		URL url = null;
		String strImgurl = null;
		String strImgName = null;
		try {
			url = new URL(wxMessage.getPicUrl());
			qiniuUtil.uploadByUrl(url, MD5Util.getSecretKeyByDate(new Date()));
			strImgurl = qiniuUtil.getDownloadUrl(strImgName);
			System.out.println("Picture URL：" + strImgurl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 文本消息内容
		// 回复消息
		String wxopenid = wxMessage.getFromUserName();
		WxMpXmlOutTextMessage mpXmlOutMessage;
		StringBuffer sb = new StringBuffer();
		sb.append("收到您发送的一张图片！\n");
		sb.append("        需要把图片放进一个新的胶囊吗？\n");
		sb.append("<a href = '" + AppConfig.appUrl + "/newCapsule?wxopenid=" + wxopenid + "&imgurl=" + strImgurl
				+ "'>创建胶囊</a>");
		String content = StrUtil.str2ISO8859(sb.toString());
//		System.out.println(content);
		mpXmlOutMessage = WxMpXmlOutMessage.TEXT().fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).content(content).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();

		return mpXmlOutMessage;
	}

}
