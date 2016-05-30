package com.yinbro.tc.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yinbro.tc.dao.CapsuleContentDAO;
import com.yinbro.tc.dao.CapsuleDAO;
import com.yinbro.tc.dao.UserDAO;
import com.yinbro.tc.pojo.CapsuleBean;
import com.yinbro.tc.pojo.CapsuleContentBean;
import com.yinbro.tc.pojo.UserBean;
import com.yinbro.tc.util.AppConfig;
import com.yinbro.tc.util.DateUtil;
import com.yinbro.tc.util.ImageUtils;
import com.yinbro.tc.util.MD5Util;
import com.yinbro.tc.util.QiniuUtil;
import com.yinbro.tc.util.QrCodeUtil;
import com.yinbro.tc.util.ShortUrlUtil;

@Controller
public class CapsuleController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		String wxopenid = request.getParameter("wxopenid").toString();

		System.out.println(wxopenid);

		CapsuleDAO capsuleDAO = new CapsuleDAO();
		UserDAO userDao = new UserDAO();
		UserBean user = userDao.findUserByWxID(wxopenid);
		List<CapsuleBean> cbl = capsuleDAO.queryCapsuleListByWxID(wxopenid);
		// System.out.println(ub.toString());
		// System.out.println(cbl.size());

		HttpSession session = request.getSession();
		session.setAttribute("cbl", cbl);
		session.setAttribute("user", user);

		return "home";
	}

	@RequestMapping(value = "/newCapsule", method = RequestMethod.GET)
	public String newCapsuleP1(HttpServletRequest request,Model model) {
		//获取图片url
		String imgurl =request.getParameter("imgurl").toString();
		model.addAttribute("imgurl", imgurl);
		return "newCapsule1";
	}

	@RequestMapping(value = "/newCapsule2", method = RequestMethod.GET)
	public String newCapsule2(HttpServletRequest request, Model model) {

		return "newCapsule2";
	}

	@RequestMapping(value = "/newCapsuleSuccess", method = RequestMethod.GET)
	public String newCapsuleSuccess() {
		return "newCapsuleSuccess";
	}

	// 接受创建胶囊1界面中的参数，缓存到Session中，并跳转到界面2
	@RequestMapping(value = "/newCapsule1Post", method = RequestMethod.POST)
	private String newCapsule1(HttpServletRequest request,Model model ) {
		// 把接收到的内容先放到Session中缓存起来，跳转到胶囊内容编辑界面中进一步完善
		CapsuleBean capsule = new CapsuleBean();

		if (request.getParameter("isSnap").equalsIgnoreCase("yes")) {
			capsule.setSnap(true);
		} else {
			capsule.setSnap(false);
		}
		
		//获取图片url
		String imgurl =request.getParameter("imgurl").toString();
		System.out.println("imgurl"+imgurl);
		
		
		try {
			String base64img=ImageUtils.encodeImgageToBase64(new URL(imgurl));
			
//			System.out.println(base64img);
			
			model.addAttribute("base64img", base64img);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		capsule.setSubject(request.getParameter("subject"));
		capsule.setPreShowText(request.getParameter("preShowText"));
		capsule.setPutTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		capsule.setSafeStrategy(Integer.parseInt(request.getParameter("safeStrategy")));
		capsule.setPreOpenTime(request.getParameter("preOpenTime"));
		HttpSession httpSession = request.getSession();
		capsule.setWxopenid((String) httpSession.getAttribute("wxopenid"));

		httpSession.setAttribute("capsule", capsule);
		//将imgurl存在session
		httpSession.setAttribute("imgurl", imgurl);

		// System.out.println(capsule.toString());
		return "newCapsule2";
	}

	// 接受创建胶囊2界面中的胶囊内容信息，完成整个胶囊Bean的创建
	@RequestMapping(value = "/newCapsule2Post", method = RequestMethod.POST)
	private String newCapsule2Post(HttpServletRequest request,Model model) {
		CapsuleBean capsule = (CapsuleBean) request.getSession().getAttribute("capsule");
		if (capsule.getWxopenid() == null) {
			System.out.println("参数异常，无wxopenid");
			return null;
		}
		
		// 生成KEY
		String key = MD5Util.getSecretKeyByDate(new Date());

		capsule.setKey(key);
		// 以key命名,短连接作为内容的二维码图片存到七牛中
		String qrContent = AppConfig.appUrl + "/open?key=" + key;

		String shortUrl = ShortUrlUtil.getShortUrl(qrContent);
		System.out.println("原内容：" + qrContent);
		System.out.println("短连接：" + shortUrl);
		File qrFile = QrCodeUtil.getQrCodeImg(shortUrl);
		QiniuUtil qiniuUtil = new QiniuUtil();
		qiniuUtil.upload(qrFile, key);
		String qrImgUrl = qiniuUtil.getDownloadUrl(key);
		capsule.setQrImgUrl(qrImgUrl);

		// 填充Content
		CapsuleContentBean ccb = new CapsuleContentBean();
		String strContent = request.getParameter("content");
		 System.out.println(strContent);
		ccb.setCccontent(strContent);
		CapsuleContentDAO capsuleContentDAO = new CapsuleContentDAO();
		int ccbid = capsuleContentDAO.createCapsuleContent(ccb);
		ccb.setCcid(ccbid);
		capsule.setContentid(ccb.getCcid());

		CapsuleDAO dao = new CapsuleDAO();
		if (dao.createCapsule(capsule)) {
			return "newCapsuleSuccess";
		}
		System.out.println("创建胶囊失败");
		return null;
	}

	@RequestMapping(value = "/open")
	public String capsuleDetail(HttpServletRequest request) {
		// 判断访问来源、参数情况
		String key = request.getParameter("key");
		if (key == null) {
			System.out.println("开启胶囊参数异常：KEY为空");
			return "wxOnly";
		}
		// TODO 判断该胶囊的安全策略

		// 加载胶囊内容
		CapsuleDAO capsuleDAO = new CapsuleDAO();
		CapsuleBean capsule = capsuleDAO.queryCapsuleByKey(key);

		// TODO 判断开启时间
		String opentime = capsule.getPreOpenTime();
		// System.out.println("opentime"+opentime);
		Date now = new Date();
		String nowtime = DateUtil.dateToStr(now);
		// System.out.println("nowtime"+nowtime);

		long i = DateUtil.getDays(opentime, nowtime);
		// System.out.println("相隔天数"+i);

		CapsuleContentDAO capsuleContentDAO = new CapsuleContentDAO();
		CapsuleContentBean capsuleContentBean = capsuleContentDAO.queryCapsuleContentByID(capsule.getContentid());
		UserDAO userDAO = new UserDAO();
		UserBean user = userDAO.findUserByWxID(capsule.getWxopenid());
		// 设值到Session中
		HttpSession session = request.getSession();
		session.setAttribute("capsule", capsule);
		session.setAttribute("user", user);

		// System.out.println(capsuleContentBean.toString());

		session.setAttribute("content", capsuleContentBean.getCccontent());
		if (i < 0) {
			capsule.setActOpenTime(nowtime);
			capsuleDAO.updateActOpenTime(capsule);
			return "open";
		} else {
			return "faile";
		}
	}

}
