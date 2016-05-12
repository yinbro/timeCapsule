<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>新建颊囊</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />


<!-- 编辑器相关 -->
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/ueditor.all.min.js">
	
</script>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>


<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');

	function isFocus(e) {
		alert(UE.getEditor('editor').isFocus());
		UE.dom.domUtils.preventDefault(e)
	}
	function setblur(e) {
		UE.getEditor('editor').blur();
		UE.dom.domUtils.preventDefault(e)
	}
	function insertHtml() {
		var value = prompt('插入html代码', '');
		UE.getEditor('editor').execCommand('insertHtml', value)
	}
	function createEditor() {
		enableBtn();
		UE.getEditor('editor');
	}
	function getAllHtml() {
		alert(UE.getEditor('editor').getAllHtml())
	}
	function getContent() {
		var arr = [];
		arr.push("使用editor.getContent()方法可以获得编辑器的内容");
		arr.push("内容为：");
		arr.push(UE.getEditor('editor').getContent());
		alert(arr.join("\n"));
	}
	function getPlainTxt() {
		var arr = [];
		arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
		arr.push("内容为：");
		arr.push(UE.getEditor('editor').getPlainTxt());
		alert(arr.join('\n'))
	}
	function setContent(isAppendTo) {
		var arr = [];
		arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
		UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
		alert(arr.join("\n"));
	}
	function setDisabled() {
		UE.getEditor('editor').setDisabled('fullscreen');
		disableBtn("enable");
	}

	function setEnabled() {
		UE.getEditor('editor').setEnabled();
		enableBtn();
	}

	function getText() {
		//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
		var range = UE.getEditor('editor').selection.getRange();
		range.select();
		var txt = UE.getEditor('editor').selection.getText();
		alert(txt)
	}

	function getContentTxt() {
		var arr = [];
		arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
		arr.push("编辑器的纯文本内容为：");
		arr.push(UE.getEditor('editor').getContentTxt());
		alert(arr.join("\n"));
	}
	function hasContent() {
		var arr = [];
		arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
		arr.push("判断结果为：");
		arr.push(UE.getEditor('editor').hasContents());
		alert(arr.join("\n"));
	}
	function setFocus() {
		UE.getEditor('editor').focus();
	}
	function deleteEditor() {
		disableBtn();
		UE.getEditor('editor').destroy();
	}
	function disableBtn(str) {
		var div = document.getElementById('btns');
		var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
		for (var i = 0, btn; btn = btns[i++];) {
			if (btn.id == str) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			} else {
				btn.setAttribute("disabled", "true");
			}
		}
	}
	function enableBtn() {
		var div = document.getElementById('btns');
		var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
		for (var i = 0, btn; btn = btns[i++];) {
			UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
		}
	}

	function getLocalData() {
		alert(UE.getEditor('editor').execCommand("getlocaldata"));
	}

	function clearLocalData() {
		UE.getEditor('editor').execCommand("clearlocaldata");
		alert("已清空草稿箱")
	}
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
										type="radio" name="options" id="option1"> 是
									</label> <label class="am-btn am-btn-default am-btn-xs"> <input
										type="radio" name="options" id="option2"> 否
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


						***后期添加时间选择器***
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


									<p>此处用来添加富媒体编辑器</p>


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
