<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>胶囊创建成功</title>
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
	<div class="header">
		<div class="am-g">
			<h1>胶囊创建成功！</h1>
			<p>
				我在 ${ capsule.preOpenTime} 等你<br />
			</p>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<hr>
			<div>
				<figure data-am-widget="figure"
					class="am am-figure am-figure-default "
					data-am-figure="{  pureview: 'true' }">
					<img src=${capsule.qrImgUrl }
						+ "/imageView2/0/w/640";
						data-rel=${capsule.qrImgUrl }
						alt="时间胶囊二维码图片" />
					<figcaption class="am-figure-capition-btm">
						你可以自行保存本时间胶囊的二维码</figcaption>


				</figure>
			</div>
			<hr>
		</div>
	</div>
	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule </p>
	</footer>
</body>
</html>
