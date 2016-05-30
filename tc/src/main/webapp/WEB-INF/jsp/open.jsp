<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>胶囊详情</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<style>
@media only screen and (min-width: 1200px) {
	.blog-g-fixed {
		max-width: 1200px;
	}
}
@media only screen and (min-width: 641px) {
	.blog-sidebar {
		font-size: 1.4rem;
	}
}
.blog-main {
	padding: 20px 0;
}
.blog-title {
	margin: 10px 0 20px 0;
}
.blog-meta {
	font-size: 14px;
	margin: 10px 0 20px 0;
	color: #222;
}
.blog-meta a {
	color: #27ae60;
}

.blog-pagination a {
	font-size: 1.4rem;
}

.blog-team li {
	padding: 4px;
}

.blog-team img {
	margin-bottom: 0;
}

.blog-content img, .blog-team img {
	max-width: 100%;
	height: auto;
}

.blog-footer {
	padding: 10px 0;
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		var ua = navigator.userAgent.toLowerCase();
		alert(ua);
		if (ua.match(/MicroMessenger/i) == "micromessenger") {
			return true;
		} else {
			return false;
		}
	})
</script>

</head>
<body>
	<header class="am-topbar ">
		<h1 class="am-topbar-brand">
			时间胶囊 / <small>Time Capsule</small>
		</h1>
	</header>

	<div class="am-g am-g-fixed blog-g-fixed">
		<div class="am-u-md-8">
			<article class="blog-main">
				<div class="am-g blog-content">
					<h3 >主题:${capsule.subject }</h3>
					<img class="am-img-responsive" alt="capsule slogen"
						src="assets/i/TimeCapsuleImage.jpg">
					<hr>
					<div class="am-u-lg-7">
						<h3>内容:</h3>
						<!-- content -->
						<hr>
						${content }

						<!-- content -->
					</div>
				</div>
			</article>
			<hr class="am-article-divider blog-hr">
		</div>

		<div class="am-u-md-4 blog-sidebar">
			<div class="am-panel-group">
				<section class="am-panel am-panel-default">
					<div class="am-panel-hd">胶囊详情</div>
					<div class="am-panel-bd">
						<table class="am-table am-table-striped am-table-hover blog-meta">
							<tbody>
								<tr>
									<td>用户名称</td>
									<td>${user.name }</td>
								</tr>
								<tr class="am-primary">
									<td>埋入日期</td>
									<td>${capsule.putTime }</td>
								</tr>
								<tr>
									<td>开启日期</td>
									<td>${capsule.preOpenTime }</td>
								</tr>
								<tr class="am-primary">
									<td>安全策略</td>
									<td>${capsule.safeStrategy }</td>
								</tr>
								<tr>
									<td>封条信息</td>
									<td>${capsule.preShowText }</td>
								</tr>

							</tbody>
						</table>
						<a class="am-btn am-btn-danger am-btn-sm am-round" href="#">阅后销毁</a>
					</div>
				</section>

			</div>
		</div>

	</div>

	<footer class="blog-footer">
		<p>©2016 Time Capsule </p>
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

</body>
</html>
