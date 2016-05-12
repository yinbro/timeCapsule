<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>埋藏胶囊</title>
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
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<h3>登录</h3>
			<hr>
			<div class="am-btn-group">
				<a href="#" class="am-btn am-btn-secondary am-btn-sm"><i
					class="am-icon-qq am-icon-sm"></i> QQ登录</a> <a href="#"
					class="am-btn am-btn-success am-btn-sm"><i
					class="am-icon-weixin am-icon-sm"></i> 微信登录</a> <a href="#"
					class="am-btn am-btn-danger am-btn-sm"><i
					class="am-icon-weibo am-icon-sm"></i> 微博登录</a>
			</div>
			<br> <br>

			<form method="post" class="am-form">
				<label for="email">账 号:</label> <input type="text" name=""
					id="email" value=""> <br> <label for="password">密
					码:</label> <input type="password" name="" id="password" value=""> <br>
				<label for="remember-me"> <input id="remember-me"
					type="checkbox"> 记住密码
				</label> <br />
				<div class="am-cf">
					<input type="submit" name="" value="登 录"
						class="am-btn am-btn-primary am-btn-sm am-fl"> <input
						type="submit" name="" value="忘记密码 ^_^? "
						class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
			<hr>
		</div>
	</div>
	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule by yinbro</p>
	</footer>
</body>
</html>
