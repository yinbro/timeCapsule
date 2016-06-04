<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>个人中心</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<style>
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
</head>
<body>
	<header class="am-topbar ">
		<h1 class="am-topbar-brand">
			时间胶囊 / <small>Time Capsule</small>
		</h1>
	</header>
	<!-- Content Start -->
	<div class="am-u-md-4 blog-sidebar">
		<div class="am-panel-group">
			<section class="am-panel am-panel-primary">
				<div class="am-panel-hd">用户信息</div>
				<div class="am-panel-bd">
					<table class="am-table am-table-striped am-table-hover blog-meta">
						<tbody>
							<tr>
								<td>用户名称</td>
								<td>${user.name }</td>
							</tr>
							<tr class="am-primary">
								<td>个性签名</td>
								<td>${user.showMsg }</td>
							</tr>
							<tr>
								<td>联系电话</td>
								<td>${user.tele }</td>
							</tr>
							<tr class="am-primary">
								<td>微信 I D</td>
								<td>${user.wxname }</td>
							</tr>
							<tr>
								<td>联系邮箱</td>
								<td>${user.email }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>

	<hr>

	<div class="am-u-md-4 blog-sidebar am-panel-warning">
		<div class="am-panel-hd ">用户胶囊</div>
		<div class="am-panel-group">
			<section data-am-widget="accordion"
				class="am-accordion am-accordion-gapped am-accordion-primary" data-am-accordion='{  }'>
				<c:forEach var="c" items="${cbl}" varStatus="status">
					<dl class="am-accordion-item ">
						<dt class="am-accordion-title">主题：${c.subject }</dt>
						<dd class="am-accordion-bd am-collapse ">
							<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
							<div class="am-accordion-content">
								埋藏时间：${c.putTime }<br /> 计划开启：${c.preOpenTime } <br />
								胶囊封条：${c.preShowText }<br /> 开启状态：
								<c:if test="${c.actOpenTime==null }">
										未开启
									</c:if>
								<c:if test="${c.actOpenTime!=null }">
										已开启<br />
								开启时间：${c.actOpenTime}
									</c:if>
								<br /> <a href="/tc/open?key=${c.key }">查看胶囊内容</a>
							</div>
						</dd>
					</dl>
				</c:forEach>
			</section>
		</div>
	</div>
	<!-- Content End -->
	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>
