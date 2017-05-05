<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改员工信息</title>
<%@ include file="/common/meta.jsp"%>
</head>
<body>
	<c:set var="currentNav" value="user"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	<div class="container">
		<div class="op-container clearfix">
			<!-- 操作结果提示 start -->
			<c:if test="${success ne null && success eq true}">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</c:if>
			<c:if test="${success ne null && success eq false}">
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</c:if>
			<c:if test="${param.success ne null && param.success eq true}">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${param.message}
				</div>
			</c:if>
			<c:if test="${param.success ne null && param.success eq false}">
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${param.message}
				</div>
			</c:if>
			<!-- 操作结果提示 end -->
		</div>
	</div>
	<div class="container">
		<div class="op-container clearfix"></div>
	</div>
	<div class="container">
		<div class="well">
			<form id="changePasswordForm" method="post" class="form-horizontal"
				action="${pageContext.request.contextPath}/admin/user/change_password">
				<legend>
					<h3>修改密码</h3>
				</legend>
				<fieldset>
					<input type="hidden" name="userId" value="${user_session_key.id}">
					<div class="form-group">
						<label class="col-sm-3 control-label">用户名：</label>
						<div class="col-sm-4">${user_session_key.username}</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">新密码 ：</label>
						<div class="col-sm-4">
							<input name="password" type="password" class="form-control"
								placeholder="登录密码，长度为6到15，不修改留空即可">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">确认密码 ：</label>
						<div class="col-sm-4">
							<input name="rePassword" type="password" class="form-control"
								placeholder="请再输入一次密码">
						</div>
					</div>
					<hr />
					<div class="form-group">
						<div align="center">
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	</main>
</body>

<script type="text/javascript">
	$(function() {
		$('#changePasswordForm').bootstrapValidator({
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				password : {
					validators : {
						notEmpty : {
							message : '密码为必填项，不能为空'
						},
						stringLength : {
							min : 6,
							max : 15,
							message : '密码长度为长度为6到15'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_]+$/,
							message : '密码只能使用大小写字母、数字和下划线'
						}
					}
				},
				rePassword : {
					validators : {
						identical : {
							field : 'password',
							message : '两次密码不相同'
						}
					}
				}
			}
		});
	});
</script>
</html>