<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>群控管理后台</title>
<%@ include file="/common/meta.jsp"%>
<style type="text/css">
html {
	background: url(img/login_bg.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

body {
	padding-top: 100px;
	font-size: 16px;
	font-family: "Open Sans", serif;
	background: transparent;
}

h1 {
	font-family: "Abel", Arial, sans-serif;
	font-weight: 400;
	font-size: 40px;
}

.panel {
	background-color: rgba(255, 255, 255, 0.9);
}

.margin-base-vertical {
	margin: 40px 0;
}

.w650 {
	width: 650px;
}
</style>
</head>
<body>
	<div class="container w650">
		<div class="row">
			<div class="col-xs-6 col-xs-offset-3 panel panel-default">
				<c:url var="loginUrl" value="/j_spring_security_check"></c:url>
				<form class="form-horizontal" role="form" action="${loginUrl}"
					method="POST">
					<h2 class="text-center">管理后台</h2>
					<c:if test="${not empty errorMessage}">
						<label style="color: red;">${errorMessage}</label>
					</c:if>

					<div class="form-group">
						<label for="username" class="col-xs-3 control-label">帐号</label>
						<div class="col-xs-8">
							<input type="text" class="form-control" id="inputEmail3"
								name="username" placeholder="请输入帐号" required="required"
								autofocus="autofocus">
						</div>
					</div>
					<div class="form-group">
						<label for="pwd" class="col-xs-3 control-label">密码</label>
						<div class="col-xs-8">
							<input type="password" class="form-control" id="inputPassword3"
								name="password" placeholder="请输入密码" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-2 col-xs-push-3">
							<button type="submit" class="btn btn-primary">登录</button>
						</div>
						<div class="col-xs-2 col-xs-push-4">
							<button type="reset" class="btn btn-default">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>