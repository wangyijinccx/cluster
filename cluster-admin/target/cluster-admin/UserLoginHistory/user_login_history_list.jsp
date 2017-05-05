<%@page import="com.ipeaksoft.moneyday.core.entity.AdminUser"%>
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
					<li><a href="#" class="active">账号登陆纪录</a></li>
				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>一级推广员</th>
							<th>二级推广员</th>
							<th>三级推广员</th>
							<th>手机</th>
							<th>ip</th>
							<th>国家</th>
							<th>地区</th>
							<th>省份</th>
							<th>城市</th>
							<th>县城</th>
							<th>isp</th>
							<th>登陆时间</th>
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
				"dom" : 'rtilp',
				"aLengthMenu" : [ 100, 500, 1000 ],
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/UserLoginHistory/getUserLoginHistoryList",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "puser1"
				}, {
					"data" : "puser2"
				}, {
					"data" : "puser3"
				}, {
					"data" : "mobile"
				}, {
					"data" : "ip"
				}, {
					"data" : "country"
				}, {
					"data" : "area"
				}, {
					"data" : "province"
				}, {
					"data" : "city"
				}, {
					"data" : "county"
				}, {
					"data" : "isp"
				}, {
					render : function(data, type, row) {
						return new Date(parseInt(row.createTime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
					}
				} ],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});
		});
	</script> </main>
</body>
</html>
