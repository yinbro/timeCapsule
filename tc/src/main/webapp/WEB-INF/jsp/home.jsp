<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>个人中心</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 user-scalable=no">
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
	<div class="header">
		<div class="am-g">
			<h1>时间胶囊</h1>
			<p>
				Time Capsule<br />把最好的，留给未来的自己
			</p>
		</div>
		<hr />
	</div>
	<!-- Content Start -->
	<div class="am-u-md-4 blog-sidebar">
			<div class="am-panel-group">
				<section class="am-panel am-panel-default">
					<div class="am-panel-hd">用户信息</div>
					<div class="am-panel-bd">
						<table class="am-table am-table-striped am-table-hover blog-meta">
							<tbody>
								<tr>
									<td>用户名称</td>
									<td>${user.name }</td>
								</tr>
								<tr class="am-primary">
									<td>用户信息</td>
									<td>${user.showMsg }</td>
								</tr>
								<tr>
									<td>用户tele</td>
									<td>${user.tele }</td>
								</tr>
								<tr class="am-primary">
									<td>微信名称</td>
									<td>${user.wxname }</td>
								</tr>
								<tr>
									<td>用户邮箱</td>
									<td>${user.email }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</section>
			</div>
		</div>
		
		
		<div class="am-u-md-4 blog-sidebar">
			<div class="am-panel-group">
				<section class="am-panel am-panel-default">
					<div class="am-panel-hd">用户胶囊信息</div>
					<div class="am-panel-bd">
						<table class="am-table am-table-striped am-table-hover blog-meta">
							<tbody>
								<tr>
									<td>胶囊主题</td>
									<td>放置时间</td>
									<td>封条信息</td>
									<td>是否阅读过</td>
									<td>操作</td>
								</tr>
								<c:forEach var="c" items="${cbl}" varStatus="status">
									<tr class="am-primary">
									<td>${c.subject }</td>
									<td>${c.putTime }</td>
									<td>${c.preShowText }</td>
									<c:if test="${c.actOpenTime==null }">
									<td>没有阅读过</td>
									</c:if>
									
									<c:if test="${c.actOpenTime!=null }">
									<td>阅读过</td>
									</c:if>
									<td><a href="/tc/open?key=${c.key }">open</a></td>
								</tr>
								</c:forEach>
								
								
							</tbody>
						</table>
					</div>
				</section>
			</div>
		</div>

	<!-- Content End -->




	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule by yinbro</p>
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
