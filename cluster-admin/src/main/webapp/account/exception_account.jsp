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
					<li><a href="#" class="active">异常帐号</a></li>
				</ol>
			</div>
			<div class="col-xs-10 text-right">
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
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>日期</th>
							<th>用户名</th>
							<th>电话</th>
							<th>apple ID</th>
							<th>地址</th>
							<th>IDFA（异常历史次数）</th>
							<th></th>
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
				"searching" : false,
				"bLengthChange" : true,
				"scrollCollapse" : true,
				//"scrollY": "400px",
				"pagingType" : "full_numbers",
				// "dom": '<"toolbar">frtip',
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/account/getExceptionAccountList",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "createTime",

				}, {
					"data" : "moblie"
				}, {
					"data" : "moblie"
				}, {
					"data" : "appleId"
				}, {
					"render" : function(data, type, row) {
						return row.province + '-' + row.city;
					}
				}, {
					"data" : "exceptionnum"
				}, {
					"render" : function(data, type, row) {
						return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/account/exception/detail?id=' + row.id + '&mobile=' + row.moblie + '">查看</a>';
					}
				}

				],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

		});
	</script> </main>
</body>
</html>
