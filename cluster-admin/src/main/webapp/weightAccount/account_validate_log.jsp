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
					<li><a href="#" class="active">vip账号</a></li>
				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>下载时间</th>
							<th>手机</th>
							<th>应用名</th>
							<th>应用ID</th>
							<th>检测前排名</th>
							<th>3小时45分后排名</th>
							<th>6小时40分后排名</th>
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
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/WeightAccount/getUserValidateList",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
						d.mobile = "${param.mobile}";
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					render : function(data, type, row) {
						return new Date(parseInt(row.downloadTime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
					}
				}, {
					"data" : "mobile"
				}, {
					"data" : "appname"
				}, {
					render : function(data, type, row) {
						return '<a href="'+ row.downloadUrl +'" target="_blank">' + row.appId + '</a>' ;
					}
				}, {
					"data" : "rank"
				}, {
					render : function(data, type, row) {
						console.log(row);
						if(null == row.rankLater || "" == row.rankLater) {
							return "暂无,未检测";
						} else {
							return row.rankLater;
						}
					}
				},{
					render : function(data, type, row) {
						console.log(row);
						if(null == row.rankLaterSecond || "" == row.rankLaterSecond) {
							return "暂无,未检测";
						} else {
							return row.rankLaterSecond;
						}
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
