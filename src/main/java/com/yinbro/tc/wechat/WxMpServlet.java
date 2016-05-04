package com.yinbro.tc.wechat;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class WxMpServlet extends HttpServlet {

	protected WxMpInMemoryConfigStorage  config;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;
	@Override
	public void init() throws ServletException {
		super.init();
		config.setAppId("wx7c072d7efed2ed25"); // 设置微信公众号的appid
		config.setSecret("869cb72db6b2096a4a6c3f083a8744b8"); // 设置微信公众号的app corpSecret
		config.setToken("yinbro"); // 设置微信公众号的token
		config.setAesKey("djrO0LbBCps5u8QOD13LYUby994BauBSf38v3Zqbmts"); // 设置微信公众号的EncodingAESKey

		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(config);

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");

		if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
			// 消息签名不正确，说明不是公众平台发过来的消息
			response.getWriter().println("非法请求");
			return;
		}

		String echostr = request.getParameter("echostr");
		if (StringUtils.isNotBlank(echostr)) {
			// 说明是一个仅仅用来验证的请求，回显echostr
			response.getWriter().println(echostr);
			return;
		}

		String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ? "raw"
				: request.getParameter("encrypt_type");

		if ("raw".equals(encryptType)) {
			// 明文传输的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
			WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
			response.getWriter().write(outMessage.toXml());
			return;
		}

		response.getWriter().println("不可识别的加密类型，仅支持明文传输");
		return;
	}

}