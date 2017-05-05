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
</style>
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
					<li><a href="#" class="active">已发布任务</a></li>
				</ol>
			</div>
		</div>
		<div class="row border-bottom padding-15-tb">
			<div class="col-xs-12 text-right">
				<div class="form-inline " role="form">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">从</div>
							<input id="start" name="start" class="form-control "
								placeholder="请选择开始日期" type="text"
								onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,onpicked:search,oncleared:search})" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">到</div>
							<input id="end" name="end" class="form-control" type="text"
								placeholder="请选择结束日期"
								onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,onpicked:search,oncleared:search})" />
						</div>
					</div>
					<a class="btn btn-success" href="published/create">添加新任务</a>
				</div>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
						    <th>任务编号</th>
							<th>发布日期</th>
							<th>下线日期</th>
							<th>任务名称</th>
							<th>奖励</th>
							<th>有效时间</th>
							<th>任务类型</th>
							<th>优先级</th>
							<th>总份数</th>
							<th>已完成</th>
							<th>状态</th>
							<th width="20"></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					var table = $('#datalist').dataTable(
							{
								"bAutoWidth" : false,
								"bPaginate" : true, //是否分页。
								"bServerSide" : true,
								"bProcessing" : true,
								"searching" : true,
								"bLengthChange" : true,
								"scrollCollapse" : true,
								"order" : [ [ 0, "desc" ] ],
								//"scrollY": "400px",
								"pagingType" : "full_numbers",
								"aLengthMenu" : [ 20, 50, 100 ],
								// "dom": '<"toolbar">frtip',
								// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
								"ajax" : {
									"url" : "${pageContext.request.contextPath}/task/data_load",
									"data" : function(d) {
										d.start_date = $("#start").val();
										d.end_date = $("#end").val();
									},
									"dataType" : "json",
									"method" : "POST"
								},
								"columns" : [
										{
											"data" : "id"
										},
										{
											"data" : "createTime"
										},
										{
											"data" : "endTime"
										},
										{
											"data" : "taskname"
										},
										{
											"data" : "award"
										},
										{

											"render" : function(data, type, row) {
												return row.startTime + ' 至 ' + row.endTime;
											}
										},
										{
											"render" : function(data, type, row) {
												//var taskType = row.taskType;
												//var type = ("1"==taskType) ? "快速任务":("2"==taskType) ? "快速搜索任务" : ("3"==taskType) ? "奖励任务":"其他类型任务";
												//return '<span class="label label-info">'+type+'</span>';
												return row.taskType == "1" ? '<span class="label label-info">快速任务</span>' : row.taskType == "2" ? '<span class="label label-warning">快速搜索任务</span>'
														: row.taskType == "3" ? '<span class="label label-success">奖励任务</span>'
																: row.taskType == "101" ? '<span class="label label-info">第三方快速任务</span>'
																		: row.taskType == "102" ? '<span class="label label-warning">第三方快速搜索任务</span>'
																				: row.taskType == "103" ? '<span class="label label-success">第三方奖励任务</span>'
																						: '<span class="label label-default">其他任务</span>';
											}
										}, {

											"render" : function(data, type, row) {
												return row.priority == "0" ? '<span class="label label-default">普通</span>' : '<span class="label label-info">高级</span>';
											}
										}, {
											"data" : "total"
										}, {
											"data" : "finished"
										}, {
											"render" : function(data, type, row) {
												if (row.statusName == '已结束') {
													return '<span class="label label-default">已结束</span>';
												} else if (row.statusName == '未开始') {
													return '<span class="label label-warning">未开始</span>';
												} else if (row.statusName == '进行中') {
													return '<span class="label label-success">进行中</span>';
												} else {
													return row.statusName
												}
											}

										}, {
											"render" : function(data, type, row) {
												return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/task/published/update?id=' + row.id + '">编辑</a>'
													+ '<a type="button" class="btn btn-primary btn-xs" href="javascript:testSpeed(\''+ row.id +'\')">测速</a>';
											}
										}

								],
								"oLanguage" : {
									"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
								}
							});

				});
		function search() {
			$('#datalist').dataTable().fnDraw();
		}
		
		function testSpeed(id) {
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath}/task/testSpeed',
				data : {
					id : id
				},
				error : function(request) {
					console.inf('链接错误');

				},
				success : function(data) {
					if (1000 <= data) {
						alert('任务时间：'+data+'ms，不建议使用');
						window.location = flushurl;
					} else {
						alert('任务时间：'+data+'ms，可用');
					}
				}
			});
		}
	</script> </main>
</body>
</html>
