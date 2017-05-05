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
	src="${pageContext.request.contextPath}/js/add_adsource_validate.js"></script>

</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	<div class="container-fluid">
		<div class="row border-bottom padding-top-15 ">
			<div class="col-xs-4 text-left">
				<ol class="breadcrumb">
					<li><a href="#">已发布任务</a></li>
					<li><a href="#">广告主接口</a></li>
					<li><a href="#" class="active">创建</a></li>
				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<form id="form_task" class="form-horizontal"
					action="${pageContext.request.contextPath}/adsource/createDate">
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">广告主</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="value"
								name="value">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">广告主标示</label>
						<div class="col-xs-7">
							<input name="key" type="text" class="form-control"
							     id="key" >
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">描述</label>
						<div class="col-xs-7">
							<input name="description" type="text" class="form-control"
								 id="description" >
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">是否有效</label>
						<div class="col-xs-7">
							<select class="form-control" id="enable" name="enable">
							    <option value="1">是</option>
								<option value="0">否</option>
							</select>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">点击url</label>
						<div class="col-xs-7">
							<input name="clickUrl" type="text" class="form-control"
								id="clickUrl" >
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">排重url</label>
						<div class="col-xs-7">
							<input name="duplicateUrl" type="text" class="form-control"
								id="duplicateUrl" >
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">激活url</label>
						<div class="col-xs-7">
							<input name="activeUrl" type="text" class="form-control"
								id="activeUrl" >
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-8 text-center">
							<button type="submit" class="btn btn-primary" id="btn_add">创建</button>
							<button type="reset" class="btn btn-default">重置</button>
							<a href="../adsource/list" type="reset" class="btn btn-default">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	</main>

</body>
</html>
