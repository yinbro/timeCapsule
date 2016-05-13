package com.yinbro.tc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

@Controller
public class WxMpController {

	protected WxMpInMemoryConfigStorage config;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;
	protected WxMpMessageRouter messageRouter;

	// 微信账号配置信息初始化，暂明文写死
	private void init() throws ServletException {
		if (config == null) {
			config = new WxMpInMemoryConfigStorage();
		}
		config.setAppId("wx7c072d7efed2ed25"); // 设置微信公众号的appid
		config.setSecret("869cb72db6b2096a4a6c3f083a8744b8"); // 设置微信公众号的app
		config.setToken("yinbro"); // 设置微信公众号的token
		config.setAesKey("djrO0LbBCps5u8QOD13LYUby994BauBSf38v3Zqbmts"); // 设置微信公众号的EncodingAESKey
		if (wxMpService == null) {
			wxMpService = new WxMpServiceImpl();
		}
		wxMpService.setWxMpConfigStorage(config);

	}

	// GET请求用于认证服务
	@RequestMapping(value = "/wxService", method = RequestMethod.GET)
	public void wxCheckIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 初始化微信配置
		init();
		// 微信认证接入
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
		return;
	}

	// GET请求用于认证服务
	@RequestMapping(value = "/wxService", method = RequestMethod.POST)
	public void wxService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		// 只考虑明文传输的消息
		WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
		System.out.println("收到新的微信消息");
		System.out.println(inMessage.toString());
		
//		WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
//		response.getWriter().write(outMessage.toXml());
		return;

	}

}
