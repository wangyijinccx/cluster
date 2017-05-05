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
	src="${pageContext.request.contextPath}/js/add_taskfast_validate.js"></script>

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
					action="${pageContext.request.contextPath}/task/update">
					<input type="hidden" name="id" value="${task.id}" />
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">任务名称</label>
						<div class="col-xs-7">
							<input name="taskname" type="text" class="form-control"
								value="${task.taskname}" id="taskname" placeholder="任务名称"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">任务描述</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="description"
								value="${task.description}" name="description"
								placeholder="任务描述">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">任务来源</label>
						<div class="col-xs-7">
							<select class="form-control" id="taskSource" name="taskSource">
								<c:forEach var="taskSource" items="${taskSourceList }">
									<option value="${taskSource.key }"
										<c:if test = "${taskSource.key eq task.taskSource }">selected="selected"</c:if>>${taskSource.value }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div id="ad" class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">广告ID</label>
						<div class="col-xs-7">
							<input name="adId" type="text" class="col-xs-7 form-control"
								id="adId" placeholder="渠道商提供，广告的唯一标识"
								value="${task.adId }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">APPID</label>
						<div class="col-xs-7">
							<input name="appid" type="text" class="form-control" id="appid"
								placeholder="任务名称" required="required" value="${task.appid}">
						</div>
					</div>
					<div class="form-group">
						<label for="size" class="col-xs-3  control-label">应用大小</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="size" name="size"
								value="${task.size}" placeholder="应用大小">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">应用描述</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="appDescription"
								value="${task.appDescription}" name="appDescription"
								placeholder="应用描述">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">操作步骤</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="operateStep"
								value="${task.operateStep}" name="operateStep"
								placeholder="操作步骤">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">应用图标</label>
						<div class="col-xs-7">
							<div>
								<div class="col-sm-10 p0">
									<input class="form-control " type="text" name="img" id="img"
										value="${task.img}" />
								</div>
								<div class="col-sm-2 text-right p0"
									style="padding-right: 0px; padding-left: 5px;">
									<span class="btn btn-success fileinput-button"
										style="width: 70px;"> <i
										class="glyphicon glyphicon-plus"></i> <span>选择</span> <!-- The file input field used as target for the file upload widget -->
										<input id="fileupload" type="file" name="file" />
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">任务类型</label>
						<div class="col-xs-7">
							<label class="radio-inline"> <input type="radio"
								name="taskType" id="taskType" value="1"
								<c:if test="${task.taskType == 1}"> checked="checked" </c:if>>快速任务
							</label> <label class="radio-inline"> <input type="radio"
								name="taskType" id="taskType" value="2"
								<c:if test="${task.taskType == 2}"> checked="checked" </c:if>>
								快速搜索任务
							</label> <label class="radio-inline"> <input type="radio"
								name="taskType" id="taskType" value="3"
								<c:if test="${task.taskType == 3}"> checked="checked" </c:if>>
								奖励任务
							</label> <label class="radio-inline"> <input type="radio"
								name="taskType" id="taskType" value="101"
								<c:if test="${task.taskType == 101}"> checked="checked" </c:if>>
								第三方快速任务
							</label> <label class="radio-inline"> <input type="radio"
								name="taskType" id="taskType" value="102"
								<c:if test="${task.taskType == 102}"> checked="checked" </c:if>>
								第三方快速搜索任务
							</label> <label class="radio-inline"> <input type="radio"
								name="taskType" id="taskType" value="103"
								<c:if test="${task.taskType == 103}"> checked="checked" </c:if>>
								第三方奖励任务
							</label>
						</div>
					</div>
					<c:if test="${not empty task.channelName }">
						<div id="channel" class="form-group">
							<label for="inputEmail" class="col-xs-3 control-label">渠道商名称</label>
							<div class="col-xs-7">
								<select class="form-control" id="channelName" name="channelName">
									<c:forEach var="channelName" items="${channelNameList }">
										<option value="${channelName.key }"
											<c:if test="${channelName.key eq task.channelName }">selected="selected"</c:if>>${channelName.value }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</c:if>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3 control-label">关键词</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="keyWord"
								name="keyWord" placeholder="关键词" value="${task.keyWord}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3 control-label">搜索结果排列位置</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="searchOrderNum"
								name="searchOrderNum" placeholder="搜索结果排列位置"
								value=${task.searchOrderNum} }>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">优先级</label>
						<div class="col-xs-7">
							<label class="radio-inline"> <input type="radio"
								name="priority" id="inlineRadio1" value="0"
								<c:if test="${task.priority == 0}"> checked="checked" </c:if>>普通
							</label> <label class="radio-inline"> <input type="radio"
								name="priority" id="inlineRadio2" value="1"
								<c:if test="${task.priority == 1}"> checked="checked" </c:if>>
								高级
							</label>

						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3  control-label">对比方式</label>
						<div class="col-xs-7">
							<label class="radio-inline"> <input type="radio"
								name="compareType" id="compareType1" value="0"
								<c:if test="${task.compareType == 0}"> checked="checked" </c:if>>对比idfa
							</label> <label class="radio-inline"> <input type="radio"
								name="compareType" id="compareType2" value="1"
								<c:if test="${task.compareType == 1}"> checked="checked" </c:if>>
								不对比idfa
							</label>

						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3 control-label">下载地址</label>
						<div class="col-xs-7">
							<input type="text" class="form-control" id="downloadUrl"
								value="${task.downloadUrl}" name="downloadUrl"
								placeholder="下载地址">
						</div>
					</div>
					<div class="form-group">
						<label for="urlscheme" class="col-xs-3 control-label">urlscheme</label>
						<div class="col-xs-7">
							<input name="urlscheme" type="text" class="form-control"
								id="urlscheme" placeholder="urlscheme" required="required"
								value="${task.urlscheme}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3 control-label">任务奖励</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="award" name="award"
								value="${task.award}" placeholder="任务奖励">
						</div>
					</div>
					<div class="form-group">
						<label for="limittime" class="col-xs-3 control-label">审核时间</label>
						<div class="col-xs-2 s">
							<div class="input-group">
								<input type="text" class="form-control" name="limittime"
									id="limittime" value="${task.limit}" /> <span
									class="input-group-addon" id="basic-addon2">分</span>
							</div>
						</div>

					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">有效期时间</label>
						<div class="col-xs-3 s">

							<input type="text" class="form-control" name="startTime"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								value="<fmt:formatDate value="${task.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />"
								id="startTime">
						</div>
						<div class="col-xs-3 e">
							<input type="text"
								value="<fmt:formatDate value="${task.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								class="form-control" name="endTime" id="endTime"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">

						</div>
					</div>
					<div class="form-group">
						<label for="numorder" class="col-xs-3 control-label">有效期排序</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="numorder"
								value="${task.numorder}" name="numorder" placeholder="有效期排序"
								value="0">
						</div>
					</div>

					<div class="form-group">
						<label for="numorder" class="col-xs-3 control-label">展示期排序</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="showNumorder"
								value="${task.showNumorder}" name="showNumorder"
								placeholder="展示期" value="0">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">总份数</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="total" name="total"
								value="${task.total}" placeholder="发布数量">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">SDK短链</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="sdkLink" name="sdkLink"
								value="${task.sdkLink}" placeholder="SDK短链">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">是否需要去重</label>
						<div class="col-xs-7">
							<select class="form-control" id="duplicate" name="duplicate">
								<option value="0"
									<c:if test = "${!task.duplicate}">selected="selected"</c:if>>否</option>
								<option value="1"
									<c:if test = "${task.duplicate}">selected="selected"</c:if>>是</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">是否需要激活上报</label>
						<div class="col-xs-7">
							<select class="form-control" id="activeUpload" name="activeUpload">
								<option value="0"
									<c:if test = "${!task.activeUpload}">selected="selected"</c:if>>否</option>
								<option value="1"
									<c:if test = "${task.activeUpload}">selected="selected"</c:if>>是</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">附加广告ID</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="adId2" name="adId2"
								value="${task.adId2}" placeholder="附加广告ID">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword" class="col-xs-3  control-label">DspId</label>
						<div class="col-xs-3">
							<input type="text" class="form-control" id="xyId" name="xyId"
								value="${task.xyId}" placeholder="DspId">
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
