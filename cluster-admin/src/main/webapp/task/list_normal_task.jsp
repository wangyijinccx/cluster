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
			<div class="col-xs-3 text-left">
				<ol class="breadcrumb">
					<li><a href="#">管理</a></li>
					<li><a href="#" class="active">已发布任务</a></li>

				</ol>
			</div>
		</div>

		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>积分墙名称</th>
							<th>描述</th>
							<th>优先级</th>
							<th>显示</th>
							<th>管理员</th>
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
		$(document).ready(function() {
			var table = $('#datalist').dataTable({
				"bAutoWidth" : false,
				"bPaginate" : true, //是否分页。
				"bServerSide" : true,
				"bProcessing" : true,
				"searching" : true,
				"bLengthChange" : true,
				"scrollCollapse" : true,
				//"scrollY": "400px",
				"pagingType" : "full_numbers",
				// "dom": '<"toolbar">frtip',
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/task/normal",
					"data" : function(d) {

					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "name"
				}, {
					"data" : "description"
				}, {
					"render" : function(data, type, row) {
						return row.priority == 1 ? '<span class="label label-info">高级</span>' : '<span class="label label-default">普通</span>';
					}
				}, {
					"render" : function(data, type, row) {
						return row.enable == 'Y' ? '<span class="label label-success">是</span>' : '<span class="label label-default">否</span>';
					}
				}, {
					"data" : "userName"
				}, {
					"render" : function(data, type, row) {
						return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/task/normal/update?id=' + row.id + '">编辑</a>';
					}
				}

				],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

			$("#btn_search").on("click", function() {
				table.fnDraw();
			});
		});
	</script> </main>
</body>
</html>
