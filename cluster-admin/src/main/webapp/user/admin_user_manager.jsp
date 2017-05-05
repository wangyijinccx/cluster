<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户管理流量交换平台</title>
<%@ include file="/common/meta.jsp"%>
</head>
<body>
	<header class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">流量交换平台</a>
			</div>

			<ul class="nav navbar-nav">
				<li><a href="#/">任务</a></li>
				<li><a href="#/device">设备</a></li>
				<li><a href="#/apps">应用</a></li>
				<li class="active"><a href="#/user">用户</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">ljt <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a>退出</a></li>
					</ul></li>
			</ul>
		</div>
	</header>
	<main>
	<!-- CP start -->
	<div class="container">
		<div class="op-container clearfix">
			<div class="pull-left"><h4>CP(Content Provider)</h4></div>
			<div class="op-container clearfix">
			<button class="btn btn-info pull-right" data-toggle="modal"
				data-target="#adminAddUserModal">添加</button>
			<jsp:include page="admin_add_user_dialog.jsp" flush="true"></jsp:include>
		</div>	
		</div>
		<table id="app-table" class="table table-bordered">
			<thead>
				<tr class="active">
					<th>用户名</th>
					<th>公司名</th>
					<th>联系人</th>
					<th>联系电话</th>
					<th>备注</th>
					<th style="width: 200px;">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>yunruimin</td>
					<td>天津掌通无线有限公司</td>
					<td>云睿民</td>
					<td>13800138000</td>
					<td>这是云睿民的备注信息</td>
					<td>
						<button class="btn btn-primary btn-sm">编辑</button>
						<button class="btn btn-danger btn-sm">删除</button>
					</td>
				</tr>
				<tr>
					<td>lijunlong</td>
					<td>天津掌通无线有限公司</td>
					<td>李俊龙</td>
					<td>13800138000</td>
					<td>这是李俊龙的备注信息</td>
					<td>
						<button class="btn btn-primary btn-sm">编辑</button>
						<button class="btn btn-danger btn-sm">删除</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- CP end -->
	</main>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_user_validate.js"></script>
<!-- 引入Bootstrap验证框架 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/bootstrapvalidator/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
</html>