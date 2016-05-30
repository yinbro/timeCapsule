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
	<c:set var="wxopenid" scope="session" value="${param.wxopenid }" />

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
			<form action="newCapsule1Post" method="post">
				<div class="am-tabs-bd">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">胶囊主题</div>
						<div class="am-u-sm-8 am-u-md-10">
							<input type="text" name="subject" required="required">
						</div>
					</div>

					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">阅后即焚</div>
						<div class="am-u-sm-8 am-u-md-10">
							<div class="am-btn-group" data-am-button>
								<label class="am-btn am-btn-default am-btn-xs"> <input
									type="radio" name="isSnap" value="yes"> 是
								</label> <label class="am-btn am-btn-default am-btn-xs"> <input
									type="radio" checked="checked" name="isSnap" value="no">
									否
								</label>
							</div>
						</div>
					</div>

					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">安全策略</div>
						<div class="am-u-sm-8 am-u-md-10">
							<select data-am-selected="{btnSize: 'sm'}" name="safeStrategy">
								<option value="1" selected="selected">仅需凭证模式</option>
								<option value="2">凭证+微信认证模式</option>
								<option value="3">绝对加密模式</option>
							</select>
						</div>
					</div>


					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">开启日期</div>
						<div class="am-u-sm-8 am-u-md-10">
							<div class="am-form-group am-form-icon">
								<i class="am-icon-calendar"></i> <input type="text"
									name="preOpenTime" class="am-form-field"
									placeholder="请选择胶囊开启日期"  readonly required id="my-start-2"/>
							</div>
						</div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">封条信息</div>
						<div class="am-u-sm-8 am-u-md-4 am-u-end">
							<textarea name="preShowText" rows="4" placeholder="未到开启时间的开启提醒"></textarea>
						</div>
					</div>
				</div>
				<br>
				<hr>
				<input type="submit"
					class="am-g am-margin-top am-btn am-btn-primary am-btn-xs"
					value="下一步">
			</form>
			<br> <br> <br>
		</div>
	</div>
	<footer class="blog-footer">
		<p align="center">©2016 Time Capsule by yinbro</p>
	</footer>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
	<script>
  $(function() {
    var nowTemp = new Date();
    var nowDay = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate()+3, 0, 0, 0, 0).valueOf();
    var nowMoth = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), 1, 0, 0, 0, 0).valueOf();
    var nowYear = new Date(nowTemp.getFullYear(), 0, 1, 0, 0, 0, 0).valueOf();
    var $myStart2 = $('#my-start-2');

    var checkin = $myStart2.datepicker({
      onRender: function(date, viewMode) {
        // 默认 days 视图，与当前日期比较
        var viewDate = nowDay;

        switch (viewMode) {
          // moths 视图，与当前月份比较
          case 1:
            viewDate = nowMoth;
            break;
          // years 视图，与当前年份比较
          case 2:
            viewDate = nowYear;
            break;
        }

        return date.valueOf() < viewDate ? 'am-disabled' : '';
      }
    }).on('changeDate.datepicker.amui', function(ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
          var newDate = new Date(ev.date)
          newDate.setDate(newDate.getDate() + 1);
          checkout.setValue(newDate);
        }
        checkin.close();
        $('#my-end-2')[0].focus();
    }).data('amui.datepicker');

    var checkout = $('#my-end-2').datepicker({
      onRender: function(date, viewMode) {
        var inTime = checkin.date;
        var inDay = inTime.valueOf();
        var inMoth = new Date(inTime.getFullYear(), inTime.getMonth(), 1, 0, 0, 0, 0).valueOf();
        var inYear = new Date(inTime.getFullYear(), 0, 1, 0, 0, 0, 0).valueOf();

        // 默认 days 视图，与当前日期比较
        var viewDate = inDay;

        switch (viewMode) {
          // moths 视图，与当前月份比较
          case 1:
            viewDate = inMoth;
            break;
          // years 视图，与当前年份比较
          case 2:
            viewDate = inYear;
            break;
        }

        return date.valueOf() <= viewDate ? 'am-disabled' : '';
      }
    }).on('changeDate.datepicker.amui', function(ev) {
      checkout.close();
    }).data('amui.datepicker');
  });
</script>
</body>
</html>
