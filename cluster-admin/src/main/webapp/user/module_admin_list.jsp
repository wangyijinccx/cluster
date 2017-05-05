<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 普通管理员 start -->
<div id="adminList" class="container">
	<div class="op-container clearfix">
		<div class="pull-left">
			<h4>普通管理员</h4>
		</div>
		<%-- <button class="btn btn-info pull-right" data-toggle="modal"
			data-target="#superAdminAddUserModal">添加</button>
		<jsp:include page="super_admin_add_user_dialog.jsp" flush="true"></jsp:include> --%>
	</div>
	<table id="table" class="table table-bordered">
		<thead>
			<tr class="active">
				<th style="width: 400px;">用户名</th>
				<th>备注</th>
				<th style="width: 120px;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="admin" items="${admins}">
				<tr>
					<td>${admin.username}</td>
					<td>${admin.comment}</td>
					<td>
						<button data-toggle="modal" data-target="#superAdminEditUserModal${admin.id}" class="btn btn-primary btn-sm">编辑</button>
							<jsp:include page="/admin/user/get_user_by_id?id=${admin.id}" flush="true"></jsp:include>
						<button class="btn btn-danger btn-sm" onClick="deleteUser(${admin.id})">删除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- 普通管理员 end -->
