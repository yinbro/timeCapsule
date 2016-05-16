<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>新建颊囊</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<script src="assets/js/jquery.min.js"></script>

<style type="text/css">
div {
	width: 100%;
}
</style>


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

	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">新建胶囊</strong> / <small>Create
						Capsule</small>
				</div>
			</div>

			<hr>


			<form id="" action="newCapsule2Post" method="post">

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">胶囊内容</div>
					<div class="am-u-sm-8 am-u-md-4 am-u-end">
						<textarea name="content" rows="4" placeholder="给未来带去点什么？都装在胶囊里吧！"></textarea>
					</div>
				</div>


				<input type="submit"
					class="am-g am-margin-top am-btn am-btn-primary am-btn-xs"
					value="埋入胶囊">
			</form>
			<br> <br> <br>


		</div>

	</div>




	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule by yinbro</p>
	</footer>



	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->

	<!--<![endif]-->
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>
