<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- 表单验证 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/edit_user_validate.js"></script>
	
<!-- 超级管理员编辑用户模态对话框 -->
<div class="modal fade" id="superAdminEditUserModal${user.id}" tabindex="-1" role="dialog"
	aria-labelledby="superAdminEditUserModalLabel${user.id}" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="editUserForm" method="post" class="form-horizontal"
				action="${pageContext.request.contextPath}/admin/user/update_user">
				<input type="hidden" name="id" value="${user.id}" />
				<div class="modal-header" align="left">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="superAdminEditUserModalLabel${user.id}">编辑用户</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label class="col-sm-3 control-label">用户名 ：</label>
						<div class="col-sm-9">
							<input name="username" type="text" class="form-control"
								placeholder="登录使用的用户名，长度为2到30，可用中文" value="${user.username}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密码 ：</label>
						<div class="col-sm-9">
							<input name="password" type="password" class="form-control"
								placeholder="不修改留空即可，长度为6到15">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">公司名 ：</label>
						<div class="col-sm-9">
							<input name="companyName" type="text" class="form-control"
								placeholder="公司名" value="${user.companyName}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">联系人 ：</label>
						<div class="col-sm-9">
							<input name="linkman" type="text" class="form-control"
								placeholder="联系人姓名" value="${user.linkman}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">联系电话 ：</label>
						<div class="col-sm-9">
							<input name="phone" type="text" class="form-control"
								placeholder="联系电话" value="${user.phone}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">用户类型 ：</label>
						<div class="col-sm-9">
							<select class="form-control" name="roleId">
								<c:if test="${user.roleId eq 3}">
									<option value="3" selected>CP</option>
									<option value="2">普通管理员</option>
								</c:if>
								<c:if test="${user.roleId eq 2}">
									<option value="3">CP</option>
									<option value="2" selected>普通管理员</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">备注 ：</label>
						<div class="col-sm-9" align="left">
							<textarea cols="40" name="comment">${user.comment}</textarea>
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