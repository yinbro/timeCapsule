<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>注册资料补全</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<div class="header">
		<div class="am-g">
			<h1>时间胶囊</h1>
			<p>
				Time Capsule<br />把最好的，留给未来的自己
			</p>
		</div>
		<hr />
	</div>


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
				<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
					<div class="am-panel am-panel-default">
						<div class="am-panel-bd">
							<div class="am-g">
								<div class="am-u-md-4">
									<img class="am-img-circle am-img-thumbnail"
										src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/200/h/200/q/80"
										alt="" />
								</div>
								<div class="am-u-md-8">
									<p>选择一张照片作为头像</p>
									<form class="am-form">
										<div class="am-form-group">
											<input type="file" id="user-pic">
											<p class="am-form-help">请选择要上传的照片...</p>
											<button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

				</div>

				<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
					<form class="am-form am-form-horizontal">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">昵称
								/ Nickname</label>
							<div class="am-u-sm-9">
								<input type="text" id="user-name" placeholder="姓名 / Name">
								<small>向未来的你做个自我介绍，先取个好名字吧</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-gender" class="am-u-sm-3 am-form-label">性别
								/ Gender</label>
							<div class="am-u-sm-9">
								<div class="am-btn-group" data-am-button>
									<label class="am-btn am-btn-primary  am-btn-xs"> <input
										type="radio" name="options" id="option1"> 男
									</label> <label class="am-btn am-btn-danger am-btn-xs"> <input
										type="radio" name="options" id="option2"> 女
									</label>
								</div>
								<br> <small>敢问阁下贵性？</small>
							</div>
						</div>






						<div class="am-form-group">
							<label for="user-email" class="am-u-sm-3 am-form-label">电子邮件
								/ Email</label>
							<div class="am-u-sm-9">
								<input type="email" id="user-email"
									placeholder="输入你的电子邮件 / Email"> <small>最好是一个伴随一生的邮箱哦...</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">电话
								/ Telephone</label>
							<div class="am-u-sm-9">
								<input type="email" id="user-phone"
									placeholder="输入你的电话号码 / Telephone"><small>放心，我不会告诉卖保险的...</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">微博
								/ Twitter</label>
							<div class="am-u-sm-9">
								<input type="email" id="user-weibo"
									placeholder="输入你的微博 / Twitter">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-intro" class="am-u-sm-3 am-form-label">简介
								/ Intro</label>
							<div class="am-u-sm-9">
								<textarea class="" rows="5" id="user-intro" placeholder="输入个人简介"></textarea>
								<small>250字以内写出你的一生...</small>
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button type="button" class="am-btn am-btn-primary">保存修改</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<!-- content end -->



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

