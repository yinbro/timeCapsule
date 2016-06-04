<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="assets/shop/static/css/template/reset.css?2014-03-07-1"
	media="all" />

<link rel="stylesheet" type="text/css"
	href="assets/shop/static/css/template/snower.css?2014-03-07-1"
	media="all" />

<link rel="stylesheet" type="text/css"
	href="assets/shop/static/css/template/common.css?2014-03-07-1"
	media="all" />

<link rel="stylesheet" type="text/css"
	href="assets/shop/static/css/template/home-19.css?2014-03-07-1"
	media="all" />

<link rel="stylesheet" type="text/css"
	href="assets/shop/static/css/template/home-menu-2.css?2014-03-07-1"
	media="all" />

<script type="text/javascript"
	src="assets/shop/static/src/template/maivl.js?2014-03-07-1"></script>

<script type="text/javascript"
	src="assets/shop/static/src/jQuery.js?2014-03-07-1"></script>

<script type="text/javascript"
	src="assets/shop/static/src/template/swipe.js?2014-03-07-1"></script>

<script type="text/javascript"
	src="assets/shop/static/src/template/zepto.js?2014-03-07-1"></script>


<title>时间胶囊微商城</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport">
<!-- Mobile Devices Support @begin -->
<meta content="application/xhtml+xml;charset=UTF-8"
	http-equiv="Content-Type">
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
<meta content="no-cache" http-equiv="pragma">
<meta content="0" http-equiv="expires">
<meta content="telephone=no, address=no" name="format-detection">
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- apple devices fullscreen -->
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent" />
<!-- Mobile Devices Support @end -->
<link rel="shortcut icon" href="assets/shop/static/img/favicon.ico" />
</head>
<body onselectstart="return true;" ondragstart="return false;">

	<link rel="stylesheet" type="text/css"
		href="wm-xin-a/font-awesome.css?v=2014032314" media="all" />

	<div class="body">
		<!--
	幻灯片管理
	-->
		<div style="-webkit-transform: translate3d(0, 0, 0);">
			<div id="banner_box" class="box_swipe" style="height: 400px">
				<ul>
					<li><a onclick="return false;"> <img
							src="assets/shop/tcImg/tc_1_1.jpg" alt="全铝合金时间胶囊"
							style="width: 100%;" />
					</a></li>
					<li><a onclick="return false;"> <img
							src="assets/shop/tcImg/tc_2_3.jpg" alt="蛋形状时间胶囊"
							style="width: 100%;" />
					</a></li>
					<li><a onclick="return false;"> <img
							src="assets/shop/tcImg/tc_3_1.jpg" alt="炫彩时间胶囊"
							style="width: 100%;" />
					</a></li>
					<li><a onclick="return false;"> <img
							src="assets/shop/tcImg/tc_disc.jpg" alt="胶囊数据光盘"
							style="width: 100%;" />
					</a></li>
				</ul>
			</div>
		</div>
		<script>
		$(function(){
			new Swipe(document.getElementById('banner_box'), {
				speed:500,
				auto:3000,
				callback: function(){
					var lis = $(this.element).next("ol").children();
					lis.removeClass("on").eq(this.index).addClass("on");
				}
			});
		});
	</script>
		<br />
		<section>
			<a href="#" class="link_tel icon-phone">选购胶囊相关产品</a>
		</section>
		<!--
		用户分类管理
		-->
		<section>
			<ul class="list_ul">
				<li><a href="#">
						<figure>
							<div>
								<img src="assets/shop/tcImg/tc_1_2.jpg" />
							</div>
							<figcaption>
								全铝胶囊
								<p>全不锈钢时间囊时间胶囊时光胶囊</p>
							</figcaption>
						</figure>
				</a></li>
				<li><a href="#">
						<figure>
							<div>
								<img src="assets/shop/tcImg/tc_2_0.jpg" />
							</div>
							<figcaption>
								蛋形胶囊
								<p>蛋形特种工程塑料</p>
							</figcaption>
						</figure>
				</a></li>

				<li><a href="#">
						<figure>
							<div>
								<img src="assets/shop/tcImg/tc_3_2.jpg" />
							</div>
							<figcaption>
								夜光胶囊
								<p>夜光创意时间胶囊</p>
							</figcaption>
						</figure>
				</a></li>

				<li><a href="#">
						<figure>
							<div>
								<img src="assets/shop/tcImg/tc_disc.jpg" />
							</div>
							<figcaption>
								胶囊光盘
								<p>满载胶囊数据的数字光盘</p>
							</figcaption>
						</figure>
				</a></li>
	</div>
	</section>
	</div>

	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule</p>
	</footer>
</body>
</html>


