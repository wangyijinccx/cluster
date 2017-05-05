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
	src="${pageContext.request.contextPath}/js/add_game_validate.js"></script>

</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	<div class="container-fluid">
		<div class="row border-bottom padding-top-15 ">
			<div class="col-xs-4 text-left">
				<ol class="breadcrumb">
					<li><a href="#">游戏</a></li>
					<li><a href="#" class="active">编辑</a></li>
				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<form id="form_task" class="form-horizontal"
					action="${pageContext.request.contextPath}/game/updateInfo">
					<input type="hidden" name="id" value="${game.id}" />
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">游戏名称</label>
						<div class="col-xs-3 s">
							<input name="name" type="text" class="form-control"
								value="${game.name}" id="" placeholder="游戏名称"
								required="required">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">游戏内时间更新点</label>
						<div class="col-xs-3 s">

							<input type="text" class="form-control" name="gameTime"
								onFocus="WdatePicker({dateFmt:'HH:mm:ss'})"
								value="<fmt:formatDate value="${game.gameTime2}" pattern="HH:mm:ss" />"
								id="gameTime">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">bundleId</label>
						<div class="col-xs-3 s">
							<input name="bundleid" type="text" class="form-control"
								value="${game.bundleid}" id="bundleid" placeholder="bundleId"
								required="required">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">游戏版本</label>
						<div class="col-xs-3 s">
							<input name="version" type="text" class="form-control"
								value="${game.version}" id="version" placeholder="游戏版本"
								required="required">
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">游戏平台</label>
						<div class="col-xs-3 s">
							<select class="form-control" id="platform" name="platform">
								<option value="ANDROID"
									<c:if test = "${game.platform eq 'ANDROID'}">selected="selected"</c:if>>ANDROID</option>
								<option value="IOS"
									<c:if test = "${game.platform eq 'IOS'}">selected="selected"</c:if>>IOS</option>
							</select>
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
