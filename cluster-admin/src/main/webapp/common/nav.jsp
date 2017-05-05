<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page
	import="com.ipeaksoft.moneyday.admin.util.security.SpringSecurityUtils"%>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand">群控管理后台</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<!--
				<c:forEach items="${menus}" var="menu">
					<c:choose>
						<c:when test="${fn:length(menu.subMenus)==0}">
							<li><a href="${pageContext.request.contextPath}${menu.link}">${menu.name }</a></li>
						</c:when>
						<c:otherwise>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">${menu.name }<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<c:forEach items="${menu.subMenus }" var="subMenu">
										<li class=""><a
											href="${pageContext.request.contextPath}${subMenu.link }">${subMenu.name }</a></li>
									</c:forEach>
								</ul></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				 
				<security:authorize ifNotGranted="R_WEIGHT_ACCOUNT_MANAGER">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">查询<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR">
							<li class=""><a
								href="${pageContext.request.contextPath}/search/search_user">用户概览</a></li>
							<li class=""><a
							href="${pageContext.request.contextPath}/search/quick_task">快速任务</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/search/general_task">常规任务</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/search/member_list">成员查询</a></li>
						</security:authorize>
						<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR, R_PROMOTER">
							<li class=""><a
								href="${pageContext.request.contextPath}/search/search_performance">业绩查询</a></li>
						</security:authorize>
					</ul></li>
				</security:authorize>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR, R_PROMOTER">
							<li class=""><a
								href="${pageContext.request.contextPath}/account/create">创建用户</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/account/list">成员信息</a></li>
						</security:authorize>
						<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR">
							<li class=""><a
								href="${pageContext.request.contextPath}/account/exception">异常帐号</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/account/backlist">黑名单</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/account/create_weight_account_manager.jsp">创建vip账号管理员</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/account/weight_account_manager_list.jsp">vip账号管理员信息</a></li>
						</security:authorize>
						<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR, R_WEIGHT_ACCOUNT_MANAGER">
							<li class=""><a
								href="${pageContext.request.contextPath}/weightAccount/weight_account_list.jsp">vip账号</a></li>
						</security:authorize>
						<security:authorize ifAnyGranted="R_ADMIN">
							<li class=""><a
								href="${pageContext.request.contextPath}/UserLoginHistory/user_login_history_list.jsp">登陆纪录</a></li>
						</security:authorize>
					</ul></li>
				<security:authorize ifAnyGranted="R_ADMIN">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">发布<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class=""><a
								href="${pageContext.request.contextPath}/task/published">已发布任务</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/task/published/create">添加快速任务</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/task/normal">联盟平台</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/task/normal/add">发布平台</a></li>
						    <li class=""><a
								href="${pageContext.request.contextPath}/adsource/list">广告主接口配置</a></li>
						</ul></li>
				</security:authorize>
				<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">兑换<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class=""><a
								href="${pageContext.request.contextPath}/bill/checked/list">审核订单</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/bill/delayed/list">推迟订单</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/bill/wrong/list">异常订单</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/bill/recharged/list">充值订单</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/bill/searched/list">查询订单</a></li>
						</ul></li>
				</security:authorize>
				<security:authorize ifAnyGranted="R_ADMIN">
					<li><a href="${pageContext.request.contextPath}/notice/list">公告</a>
					</li>
				</security:authorize>
				<security:authorize ifAnyGranted="R_ADMIN">
					<li><a href="${pageContext.request.contextPath}/checkidfa">idfa审核</a>
					</li>
				</security:authorize>
				 -->
				
				<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">游戏<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class=""><a
								href="${pageContext.request.contextPath}/game/create">添加游戏</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/game/published">游戏列表</a></li>
						</ul></li>
				</security:authorize>
				
				
				<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">游戏账号<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class=""><a
								href="${pageContext.request.contextPath}/game/account/create">添加游戏账号</a></li>
							<li class=""><a
								href="${pageContext.request.contextPath}/game/account/manager">游戏账号管理</a></li>
						</ul></li>
				</security:authorize>
				
				
				<security:authorize ifAnyGranted="R_ADMIN, R_OPERATOR">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">运行状态<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class=""><a
								href="${pageContext.request.contextPath}/cserver/publish">运行状态</a></li>
						</ul></li>
				</security:authorize>
				
				
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown"><%=SpringSecurityUtils.getCurrentUserName()%>
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/common/change_password.jsp">修改密码</a></li>
						<li><a
							href="${pageContext.request.contextPath}/j_spring_security_logout">退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>
