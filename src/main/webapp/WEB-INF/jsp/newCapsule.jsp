<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script src="assets/artEditor/artEditor.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#content').artEditor({
			imgTar : '#imageUpload',
			limitSize : 5, // 兆
			showServer : false,
			uploadUrl : '',
			data : {},
			uploadField : 'image',
			placeholader : '<p>请输入文章正文内容</p>',
			validHtml : [ "<br/>" ],
			formInputId : 'target',
			uploadSuccess : function(res) {
				// return img url
				return res.path;
			},
			uploadError : function(res) {
				// something error
				console.log(res);
			}
		});
	});
</script>




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

			<div class="am-tabs am-margin" data-am-tabs>
				<ul class="am-tabs-nav am-nav am-nav-tabs">
					<li class="am-active"><a href="#tab1">基本信息</a></li>
					<li><a href="#tab2">胶囊内容</a></li>
				</ul>

				<div class="am-tabs-bd">
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">胶囊主题</div>
							<div class="am-u-sm-8 am-u-md-10">
								<input type="text">
							</div>
						</div>
						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">通知邮箱</div>
							<div class="am-u-sm-8 am-u-md-10">
								<input type="text" placeholder="默认使用注册预留邮箱">
							</div>
						</div>


						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">联系手机</div>
							<div class="am-u-sm-8 am-u-md-10">
								<input type="text" placeholder="默认使用注册预留手机号">
							</div>
						</div>



						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">阅后即焚</div>
							<div class="am-u-sm-8 am-u-md-10">
								<div class="am-btn-group" data-am-button>
									<label class="am-btn am-btn-default am-btn-xs"> <input
										type="radio" name="isOneOff" value="1"> 是
									</label> <label class="am-btn am-btn-default am-btn-xs"> <input
										type="radio" name="isOneOff" value="0"> 否
									</label>
								</div>
							</div>
						</div>


						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">安全策略</div>
							<div class="am-u-sm-8 am-u-md-10">
								<select data-am-selected="{btnSize: 'sm'}">
									<option value="option1">仅需凭证开启</option>
									<option value="option2">凭证+微信内开启</option>
									<option value="option3">指定微信用户开启</option>
								</select>
							</div>
						</div>


						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">开启时间</div>
							<div class="am-u-sm-8 am-u-md-10">
								<form action="" class="am-form am-form-inline">
									<div class="am-form-group am-form-icon">
										<i class="am-icon-calendar"></i> <input type="text"
											class="am-form-field am-input-sm" placeholder="时间">
									</div>
								</form>
							</div>
						</div>


						<div class="am-g am-margin-top">
							<div class="am-u-sm-4 am-u-md-2 am-text-right">封条提醒</div>
							<div class="am-u-sm-8 am-u-md-4 am-u-end">
								<textarea rows="4" placeholder="未到开启时间的开启提醒"></textarea>
							</div>
						</div>


					</div>

					<div class="am-tab-panel am-fade" id="tab2">
						<form class="am-form">
							<div class="am-g am-margin-top">
								<div class="am-u-sm-4 am-u-md-2 am-text-right">胶囊标题</div>
								<div class="am-u-sm-8 am-u-md-4">
									<input type="text" class="am-input-sm">
								</div>
								<div class="am-hide-sm-only am-u-md-6">*必填</div>
							</div>



							<div class="am-g am-margin-top-sm">
								<div class="am-u-sm-12 am-u-md-2 am-text-right admin-form-text">
									胶囊内容</div>
								<div class="am-u-sm-12 am-u-md-10">
									<!-- ----------------------- -->

									Content

									<!-- ----------------------- -->
								</div>
							</div>

						</form>
					</div>

				</div>
			</div>
			<br> <br> <br> <br> <br> <br>
			<div class="am-margin">
				<button type="button" class="am-btn am-btn-primary am-btn-xs">埋藏胶囊</button>
				<button type="button" class="am-btn am-btn-primary am-btn-xs">暂时取消</button>
			</div>
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
	<script src="assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>
