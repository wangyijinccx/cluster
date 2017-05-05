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
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/create_account_validate.js"></script>
</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	<div class="container-fluid">
		<div class="row border-bottom padding-top-15 ">
			<div class="col-xs-2 text-left">
				<ol class="breadcrumb">
					<li><a href="#">管理</a></li>
					<li><a href="#" class="active">创建账号</a></li>

				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<form id="account_form" class="form-horizontal" role="form"
					action="${pageContext.request.contextPath}/account/create_weight_account_manager">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="username"
								name="username" placeholder="用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpassword" class="col-sm-2 control-label">密码确认</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="confirmpassword"
								name="confirmpassword" placeholder="密码确认">
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-2 control-label">身份</label>
						<div class="col-sm-8">
							<p class="form-control-static">vip账号管理员</p>
						</div>
					</div>
					<div class="form-group">
						<label for="companyName" class="col-sm-2 control-label">公司名称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="companyName"
								name="companyName" placeholder="公司名称">
						</div>
					</div>
					<div class="form-group">
						<label for="linkman" class="col-sm-2 control-label">联系人</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="linkman"
								name="linkman" placeholder="联系人">
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="电话">
						</div>
					</div>
					<div class="form-group">
						<label for="comment" class="col-sm-2 control-label">备注</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="comment"
								name="comment" placeholder="电话">
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6 text-center">
							<button type="submit" class="btn btn-primary">创建</button>
							<button type="reset" class="btn btn-default">重置</button>
							<a href="list" type="reset" class="btn btn-default">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	</main>
	<script type="text/javascript">
		$(function() {
			function findAreaByParent(pid, target) {
				$.ajax({
					type : "POST",
					url : '${pageContext.request.contextPath}/Area/findAreaByParent',
					data : {
						pid : pid
					},
					error : function(request) {
						console.inf('获取数据错误');

					},
					success : function(data) {
						var jsonObjectData = JSON.parse(data);

						var target_select = $(target);
						target_select.empty();
						target_select.append('<option value="">请选择</option>');
						$.each(jsonObjectData, function(i) {
							var item = jsonObjectData[i];
							target_select.append('<option value="'+ item.id +'">' + item.areaName + '</option>')
						})
					}
				});
			}
			findAreaByParent(0, province);
			$('#province').on('change', function() {
				if (this.value != "") {
					findAreaByParent(this.value, city);
				} else {
					$('#city').empty().append('<option value="">请选择</option>')
				}

				$('#area').empty().append('<option value="">请选择</option>')

			});
			$('#city').on('change', function() {
				if (this.value != "") {
					findAreaByParent(this.value, area);
				} else {
					$('#area').empty().append('<option value="">请选择</option>')
				}
			})
		});
	</script>
</body>
</html>
