package com.yinbro.tc.handler;

import java.util.Map;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class VoiceHandler implements WxMpMessageHandler {

	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		// 文本消息内容
		String content = "";
		// 回复消息
		WxMpXmlOutTextMessage mpXmlOutMessage;
		// 获取消息发送人，与数据库用户进行比较
		String wxopenid = wxMessage.getFromUserName();

		
		
		
		mpXmlOutMessage = WxMpXmlOutMessage.TEXT().fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).content(content).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();

		return mpXmlOutMessage;
	}

}
