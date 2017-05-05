<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- 表单验证 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_user_validate.js"></script>

<!-- 超级管理员添加用户模态对话框 -->
<div class="modal fade" id="superAdminAddUserModal" tabindex="-1" role="dialog"
	aria-labelledby="superAdminAddUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="addUserForm" method="post" class="form-horizontal"
				action="${pageContext.request.contextPath}/admin/user/add_user">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="superAdminAddUserModalLabel">添加用户</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label class="col-sm-3 control-label">用户名 ：</label>
						<div class="col-sm-9">
							<input name="username" type="text" class="form-control"
								placeholder="登录使用的用户名，长度为2到30，可用中文">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密码 ：</label>
						<div class="col-sm-9">
							<input name="password" type="password" class="form-control"
								placeholder="登录密码，长度为6到15">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">公司名 ：</label>
						<div class="col-sm-9">
							<input name="companyName" type="text" class="form-control"
								placeholder="公司名">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">联系人 ：</label>
						<div class="col-sm-9">
							<input name="linkman" type="text" class="form-control"
								placeholder="联系人姓名">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">联系电话 ：</label>
						<div class="col-sm-9">
							<input name="phone" type="text" class="form-control"
								placeholder="联系电话">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">用户类型 ：</label>
						<div class="col-sm-9">
						<input name="roleId" type="text" class="form-control"
								placeholder="用户类型">
								<!--
							<select class="form-control" name="roleId">
								<security:authorize ifAnyGranted="A_CP_SECTION">
								<option value="3">CP</option>
								</security:authorize>
								<security:authorize ifAnyGranted="A_ADMIN_SECTION">
								<option value="2">普通管理员</option>
								</security:authorize>
							</select>
							  -->
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">备注 ：</label>
						<div class="col-sm-9">
							<textarea cols="40" name="comment"></textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">保存</button>
				</div>
			</form>
		</div>
	</div>
</div>