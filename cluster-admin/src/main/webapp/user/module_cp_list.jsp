<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- CP start -->
<div id="cpList" class="container">
	<div class="op-container clearfix">
		<div class="pull-left">
			<h4>合作CP</h4>
		</div>
	</div>
	<table id="table" class="table table-bordered">
		<thead>
			<tr class="active">
				<th>用户名</th>
				<th>公司名称</th>
				<th>联系人</th>
				<th>联系电话</th>
				<th>备注</th>
				<th style="width: 120px;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cp" items="${cps}">
				<tr>
					<td>${cp.username}</td>
					<td>${cp.companyName}</td>
					<td>${cp.linkman}</td>
					<td>${cp.phone}</td>
					<td>${cp.comment}</td>
					<td>
						<button data-toggle="modal" data-target="#superAdminEditUserModal${cp.id}" class="btn btn-primary btn-sm">编辑</button>
							<jsp:include page="/admin/user/get_user_by_id?id=${cp.id}" flush="true"></jsp:include>
						<button class="btn btn-danger btn-sm" onClick="deleteUser(${cp.id})">删除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- CP end -->