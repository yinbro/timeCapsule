<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>注册资料补全</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 user-scalable=no" >
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


<script type="text/javascript">
	$(function() {
		$('ck').bootstrapSwitch();
		alert("1");
	});
</script>

</head>
<body>

	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">注册资料补全</strong> / <small>Personal
						information implement</small>
				</div>
			</div>
			<hr />
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
					<form class="am-form am-form-horizontal" action="register"
						method="post">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">微信ID/
								WeChat</label>
							<div class="am-u-sm-9">
								<input  type="hidden" name="wxopenid"
									value="<c:if
										test="${not empty param.wxopenid}">${param.wxopenid}</c:if>">
								<br> <small><c:if
										test="${not empty param.wxopenid}">${param.wxopenid}</c:if></small>

							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">昵称/
								NicName</label>
							<div class="am-u-sm-9">
								<input type="text" name="name" placeholder="姓名 /Name"> <small>向未来的你做个自我介绍，先取个好名字吧</small>
							</div>
						</div>



						<div class="am-form-group">
							<label for="wxname" class="am-u-sm-3 am-form-label">微信/
								WeChat</label>
							<div class="am-u-sm-9">
								<input type="text" name="wxname"> <small>微信里你的名字~</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-gender" class="am-u-sm-3 am-form-label">性别/
								Gender</label>
							<div class="am-u-sm-9">
								<div class="am-btn-group" data-am-button>
									<label class="am-btn am-btn-primary  am-btn-xs"> <input
										type="radio" name="gender" value="1" checked="checked">
										男
									</label> <label class="am-btn am-btn-danger am-btn-xs"> <input
										type="radio" name="gender" value="0"> 女
									</label>
								</div>
								<br> <small>敢问阁下贵性？</small>
							</div>
						</div>



						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">电子邮件/
								Email</label>
							<div class="am-u-sm-9">
								<input type="email" name="email" placeholder="输入你的电子邮件 / Email">
								<small>最好是一个伴随一生的邮箱哦...</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">电话/
								Tele</label>
							<div class="am-u-sm-9">
								<input type="tel" name="tele" placeholder="输入你的电话号码 / Telephone"><small>放心，我不会告诉卖保险的...</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">简介/
								Intro</label>
							<div class="am-u-sm-9">
								<textarea name="showMsg" class="" rows="5" placeholder="输入个人简介"></textarea>
								<small>250字以内写出你的一生...</small>
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button type="submit" class="am-btn am-btn-primary">保存修改</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<!-- content end -->


	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule </p>
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

