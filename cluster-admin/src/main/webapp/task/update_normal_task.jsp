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
	src="${pageContext.request.contextPath}/js/add_normal_task_validate.js"></script>

</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
		<div class="container-fluid">
			<div class="row border-bottom padding-top-15 ">
				<div class="col-xs-4 text-left">
					<ol class="breadcrumb">
						<li><a href="#">管理</a></li>
						<li><a href="#">已发布任务</a></li>
						<li><a href="#" class="active">添加</a></li>
					</ol>
				</div>
				<div class="col-xs-8 text-right">

					<div class="form-group form-inline">
						<input id="keywords" class="form-control input-lg" type="text"
							placeholder="用户ID/用户名/IDFA" />
						<button id="btn_search" type="button"
							class="btn btn-primary btn-lg">搜索</button>
					</div>


				</div>
			</div>
			<div class="row padding-15-tb">
				<div class="col-xs-12">
					<form id="form_task" class="form-horizontal"
						action="${pageContext.request.contextPath}/task/normal/update">
						<input type="hidden" name="id" value="${model.id}"/>
						<div class="form-group">
							<label for="name" class="col-xs-3 control-label">积分墙名称</label>
							<div class="col-xs-7">
								<input name="name" type="text" class="form-control" value="${model.name}"
									id="name" placeholder="任务名称" required="required">
							</div>
						</div>
					<div class="form-group">
							<label for="inputPassword"
								class="col-xs-3  control-label">图标</label>
							<div class="col-xs-7">
								<div>
									<div class="col-sm-10 p0">
										<input class="form-control " type="text" name="image" id="image" value="${model.image}" />
									</div>
									<div class="col-sm-2 text-right p0"
										style="padding-right:0px;padding-left:5px;">
										<span class="btn btn-success fileinput-button"
											style="width:70px;"> <i
											class="glyphicon glyphicon-plus"></i> <span>选择</span> <!-- The file input field used as target for the file upload widget -->
											<input id="fileupload" type="file" name="file" />
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="col-xs-3 control-label">描述</label>
							<div class="col-xs-7">
								<input name="description" type="text" class="form-control" value="${model.description}"
									id="description" placeholder="描述" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword"
								class="col-xs-3  control-label">接口地址</label>
							<div class="col-xs-7">
								<input type="text" class="form-control" id="requestUrl" value="${model.requestUrl}"
									name="requestUrl" placeholder="应用描述">
							</div>
						</div>
						
						<div class="form-group">
							<label for="priority"
								class="col-xs-3  control-label">是否显示</label>
							<div class="col-xs-7">
								<label class="radio-inline"> <input type="radio"
									name="enable" id="inlineRadio1" value="Y"  <c:if test="${model.enable == 'Y'}"> checked="checked" </c:if>>显
								</label> <label class="radio-inline"> <input type="radio"
									name="enable" id="inlineRadio2" value="N"  <c:if test="${model.enable == 'N'}"> checked="checked" </c:if>> 否
								</label>

							</div>
						</div>
						<div class="form-group">
							<label for="priority"
								class="col-xs-3  control-label">优先级</label>
							<div class="col-xs-7">
								<label class="radio-inline"> <input type="radio"
									name="priority" id="inlineRadio1" value="0" <c:if test="${model.priority == 0}"> checked="checked" </c:if>>普通
								</label> <label class="radio-inline"> <input type="radio"
									name="priority" id="inlineRadio2" value="1" <c:if test="${model.priority == 1}"> checked="checked" </c:if>> 高级
								</label>

							</div>
						</div>
						<div class="form-group">
							<label for="numorder" class="col-xs-3 control-label">有效期排序</label>
							<div class="col-xs-2">
								<input type="text" class="form-control" id="numorder"
									name="numorder" placeholder="有效期排序"  value="${model.numorder}">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8 text-center">
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
