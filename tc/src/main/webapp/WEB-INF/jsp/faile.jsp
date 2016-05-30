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

.header {
	text-align: center;
}

#preShowText {
font-size:2rem;
text-align: center;
color:red;
	-moz-border-radius: 5em;
	-webkit-border-radius: 5em;
	border-radius: 5em;
	-moz-box-shadow: 6px 3px 8px #333333;
	-webkit-box-shadow: 6px 3px 8px #333333;
	box-shadow: 6px 3px 8px #333333;
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
	<div class="header">
		<div class="am-g">
			<h1>时间胶囊</h1>
			<p>
				Time Capsule<br />把最好的，留给未来的自己
			</p>
		</div>
	</div>

	<div class="am-g am-g-fixed blog-g-fixed">
		<div class="am-u-md-4 blog-sidebar">
			<div class="am-panel-group">
				<section class="am-panel am-panel-default">
					<div class="am-panel-hd header">主题：<Strong>${capsule.subject }</Strong><br/><small>请与${capsule.preOpenTime }打开</small></div>
					<div class="am-panel-bd">
						
						<p id="preShowText"><small>封条</small>:${capsule.preShowText }</p>
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
