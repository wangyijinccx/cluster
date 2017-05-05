<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/common/meta.jsp"%>
<style type="text/css">
.logo_top_left {
	background-color: #428bca;
	width: auto;
	height: 46px;
	margin: 0 5px;
	border-radius: 3px;
	float: left;
	box-sizing: border-box;
	display: block;
	padding-left: 5px;
	padding-right: 5px;
}

.border-bottom {
	border-bottom: 1px solid #eee;
}

.padding-top-15 {
	padding-top: 15px;
}

.padding-15-tb {
	padding: 15px 0px 15px 0px;
}

.line-height-34 {
	line-height: 34px;
}

div.dataTables_info {
	float: left;
	padding-top: 4px;
}

select.form-control {
	width: auto;
}

.p0 {
	padding: 0px;
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_game_account_validate.js"></script>

</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	<div class="container-fluid">
		<div class="row border-bottom padding-top-15 ">
			<div class="col-xs-4 text-left">
				<ol class="breadcrumb">
					<li><a href="#">游戏账号</a></li>
					<li><a href="#" class="active">编辑</a></li>
				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<form id="form_task" class="form-horizontal"
					action="${pageContext.request.contextPath}/game/account/updateInfo">
					<input type="hidden" name="id" value="${id}" />
					<input type="hidden" name="gameId" value="${gameId}" />
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">游戏名称</label>
						<div class="col-xs-3 s">
							<input name="gameId" type="text" class="form-control"
								value="${game.name}" id="gameId" placeholder="游戏名称"
								disabled = 'true'>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">游戏账号</label>
						<div class="col-xs-3 s">
							<input name="account" type="text" class="form-control"
								value="${account.account}" id="account" placeholder="游戏账号"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">游戏密码</label>
						<div class="col-xs-3 s">
							<input name="passwd" type="text" class="form-control"
								value="${account.passwd}" id="passwd" placeholder="游戏密码"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">所在服务器</label>
						<div class="col-xs-3 s">
							<input name="gameServer" type="text" class="form-control"
								value="${account.gameServer}" id="gameServer" placeholder="所在服务器"
								required="required">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">脚本运行时长(分钟)</label>
						<div class="col-xs-3 s">
							<input name="runTime" type="text" class="form-control"
								value="${account.runTime}" id="runTime" placeholder="脚本运行时长(分钟)"
								required="required">
						</div>
					</div>
					
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-xs-3 s text-center">
							<button type="submit" class="btn btn-primary" id="btn_add">保存</button>
							<button type="reset" class="btn btn-default">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	</main>

</body>
</html>
