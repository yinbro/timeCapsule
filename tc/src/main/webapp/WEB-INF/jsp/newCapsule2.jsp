<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>新建颊囊</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- 强制让文档的宽度与设备的宽度保持1:1，并且文档最大的宽度比例是1.0，且不允许用户点击屏幕放大浏览 -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width, minimal-ui">
    <!-- iphone设备中的safari私有meta标签，它表示：允许全屏模式浏览 -->
    <meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/style.css" />
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/artEditor.min.js"></script>
<script src="assets/js/index.js"></script>

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
					<div class="am-u-sm-12 am-u-md-12 ">
					<div class="publish-article-content">
				            <div class="title-tips">正文</div>
				            <input type="hidden" id="target" name="content" value="<img src='${imgurl }' >">
				            <div class="article-content" id="content">
				            </div>
				            <div class="footer-btn g-image-upload-box">
				                <div class="upload-button">
				                    <span class="upload"><i class="upload-img"></i>插入图片</span>
				                    <input class="input-file" id="imageUpload" type="file" name="fileInput" capture="camera" accept="image/*" style="position:absolute;left:0;opacity:0;width:100%;">
				                </div>
				            </div>
				        </div>
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
		<p align="center">©2016 Time Capsule </p>
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
	<script type="text/javascript">
	$(function(){
	var i=	$("#target").val();
	$("#content").html(i);
	});
	
	</script>
</body>
</html>
