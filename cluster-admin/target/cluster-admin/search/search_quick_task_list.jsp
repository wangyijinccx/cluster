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
	width: 46px;
	height: 46px;
	margin: 0 5px;
	border-radius: 3px;
	float: left;
	box-sizing: border-box;
	display: block;
	line-height: 46px;
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
</style>
</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
		<div class="container-fluid">
			<div class="row border-bottom padding-top-15 ">
				<div class="col-xs-3 text-left">
					<ol class="breadcrumb">
						<li><a href="#">查询</a></li>
						<li><a
							href=" ${pageContext.request.contextPath}/search/quick_task">快速任务</a></li>
						<li><a href="#" class="active">快速详情</a></li>

					</ol>
				</div>
				<div class="col-xs-9 text-right">

					<div class="form-group form-inline">
						<input id="keywords" class="form-control input-lg" type="text"
							placeholder="用户ID/用户名/IDFA" />
						<button id="btn_search" type="button"
							class="btn btn-primary btn-lg">搜索</button>
					</div>


				</div>
			</div>
			<div class="row border-bottom padding-15-tb">
				<div class="col-xs-4 line-height-34 ">${day}</div>
				<div class="col-xs-8 text-right ">
					<div class="form-inline " role="form">
						<button type="button" class="btn btn-primary">导出Excel</button>


					</div>
				</div>
			</div>
			<div class="row padding-15-tb">
				<div class="col-xs-12">
					<table id="datalist"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>任务名称</th>
								<th>发布数量(份)</th>
								<th>单价(金币)</th>
								<th>完成数(人)</th>
								<th>A类用户(人)</th>
								<th>B类型用户(人)<br />线上线下
								</th>
								<th>C类型用户(人)<br />线上线下
								</th>
								<th>普通用户(人)<br />线上线下
								</th>
								<th>完成度</th>
								<th>总收益(金币)</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document)
					.ready(
							function() {
								var table = $('#datalist')
										.dataTable(
												{
													"bAutoWidth" : false,
													"bPaginate" : true, //是否分页。
													"bServerSide" : true,
													"bProcessing" : true,
													"searching" : false,
													"bLengthChange" : true,
													"scrollCollapse" : true,
													//"scrollY": "400px",
													"pagingType" : "full_numbers",
													// "dom": '<"toolbar">frtip',
													// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
													"ajax" : {
														"url" : "${pageContext.request.contextPath}/search/quick_task_list",
														"data" : function(d) {
															d.search = $(
																	"#keywords")
																	.val();
															d.day = '${day}';
														},
														"dataType" : "json",
														"method" : "POST"
													},
													"columns" : [
															{
																"data" : "taskName"
															},
															{
																"data" : "publishNum"
															},
															{
																"data" : "price"
															},
															{
																"data" : "compNum"
															},
															{
																"data" : "offaUser"
															},
															{
																"render" : function(
																		data,
																		type,
																		row) {
																	return row.onbUser
																			+'/'+ row.offbUser;
																}
															},
															{
																"render" : function(
																		data,
																		type,
																		row) {
																	return row.oncUser+'/'+
																			 row.offcUser;
																}
															},

															{
																"render" : function(
																		data,
																		type,
																		row) {
																	return row.ondUser
																			+'/'+ row.offdUser;
																}
															},

															{
																"data" : "comp"
															},
															{
																"data" : "award"
															},

															{
																"render" : function(
																		data,
																		type,
																		row) {
																	return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/search/quick_task_list_detail?taskid='
																			+ row.taskId
																			+ '&day='
																			+ row.day
																			+ '&taskname='
																			+ row.taskName
																			+ ' &comp= '
																			+ row.comp
																			+ '">查看</a>';
																}
															} ],
													"oLanguage" : {
														"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
													}
												});

							});
		</script>
	</main>
</body>