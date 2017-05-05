<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户管理------流量交换平台</title>
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
					${msg}
				</div>
			</c:if>
			<c:if test="${success ne null && success eq false}">
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${msg}
				</div>
			</c:if>
			<!-- 操作结果提示 end -->
		</div>
	</div>
	<button class="btn btn-info pull-right" data-toggle="modal"
			data-target="#superAdminAddUserModal" style="margin-right:80px;">添加</button>
	<jsp:include page="super_admin_add_user_dialog.jsp" flush="true"></jsp:include>
	<!-- 普通管理员list -->
	<security:authorize ifAnyGranted="A_ADMIN_SECTION">
		<div id="adminList"></div>
	</security:authorize>

	<!-- CP list -->
	<security:authorize ifAnyGranted="A_CP_SECTION">
		<div id="cpList"></div>
	</security:authorize>
	
	<!-- 超级管理员添加用户模态对话框 -->
	<jsp:include page="super_admin_add_user_dialog.jsp" flush="true"></jsp:include>
	<!-- 超级管理员编辑普通管理员模态对话框 -->
	<jsp:include page="super_admin_add_user_dialog.jsp" flush="true"></jsp:include>
	<c:forEach var="admin" items="${admins}">
		<jsp:include page="/admin/user/get_user_by_id?id=${admin.id}" flush="true"></jsp:include>
	</c:forEach>
	<!-- 超级管理员编辑CP模态对话框 -->
	<c:forEach var="cp" items="${cps}">
		<jsp:include page="/admin/user/get_user_by_id?id=${cp.id}" flush="true"></jsp:include>
	</c:forEach>
	</main>
</body>

<script type="text/javascript">
	deleteUser = function(id) {
		if(window.confirm('您确定要删除该用户吗？')){
			location.href = "${pageContext.request.contextPath}/admin/user/delete_user?id="+id;
		} else {
			return;
		}
	}
	//异步加载普通管理员列表
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/user/list_admin',
			dataType : 'html', //返回HTML类型
			success : function(r) { //AJAX请求成功时执行此回调函数
				$('#adminList').html(r);
			}
		});
	});
	//异步加载CP列表
	$(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/user/list_cp',
			dataType : 'html', //返回HTML类型
			success : function(r) { //AJAX请求成功时执行此回调函数
				$('#cpList').html(r);
			}
		});
	});
	</script>
</html>