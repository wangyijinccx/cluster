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
			<div class="col-xs-9 text-right">
				<div class="form-group form-inline">
					<input id="keywords" class="form-control input-lg" type="text"
						placeholder="用户ID/用户名/IDFA" />
					<button id="btn_search" type="button"
						class="btn btn-primary btn-lg">搜索</button>
				</div>
			</div>
			<security:authorize ifAnyGranted="R_ADMIN">
				<div class="text-right">
					<div class="form-inline" role="form">
						<form id="export_from" method="POST">
							<button id="btn_weight_account_export" type="button"
								class="btn btn-primary">汇总</button>
							<button id="btn_weight_account_export_info" type="button"
								class="btn btn-primary">明细</button>
						</form>
					</div>
				</div>
			</security:authorize>
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
							<th>省份</th>
							<th>城市</th>
							<th width="6%">微信昵称</th>
							<th>注册时间</th>
							<th>最后一次下载时间</th>
							<th>账号级别</th>
							<th>检测次数</th>
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
		$('#btn_weight_account_export').on('click', function(e) {
			$('#export_from').attr('action', '${pageContext.request.contextPath}/WeightAccount/export_weight_account');
			$('#export_from').submit();
		});
		$('#btn_weight_account_export_info').on('click', function(e) {
			$('#export_from').attr('action', '${pageContext.request.contextPath}/WeightAccount/export_weight_account_info');
			$('#export_from').submit();
		});
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
												"dom" : 'rtilp',
												"aLengthMenu" : [ 50, 100, 500 ],
												// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
												"ajax" : {
													"url" : "${pageContext.request.contextPath}/WeightAccount/getWeightAccountList",
													"data" : function(d) {
														d.start_date = $("#start").val();
														d.end_data = $("#end").val();
														d.search = $("#keywords").val();
														d.userId = "${userId}";
													},
													"dataType" : "json",
													"method" : "POST"
												},
												"columns" : [
														{
															"data" : "puser1"
														},
														{
															"data" : "puser2"
														},
														{
															"data" : "puser3"
														},
														{
															"data" : "mobile"
														},
														{
															"data" : "provinceName"
														},
														{
															"data" : "cityName"
														},
														{
															"data" : "nickname"
														}, 
														{
															render : function(data, type, row) {
																if ('' === row.createTime)
																	return '';
																else
																	return new Date(parseInt(row.createTime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
															}
														},
														{
															render : function(data, type, row) {
																if ('' === row.lastDownloadTime)
																	return '';
																else
																	return new Date(parseInt(row.lastDownloadTime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
															}
														},
														{
															render : function(data, type, row) {
																if (1 == row.weightFlag) {
																	return '<span class="label label-default">已下载未检测</span>';
																} else if (2 == row.weightFlag) {
																	return '<span class="label label-danger">vip账号</span>';
																} else if (3 == row.weightFlag) {
																	return '<span class="label label-info">普通用户</span>';
																} else{
																	return '<span class="label label-info">普通用户</span>';
																}
															}
														},
														{
															"data" : "weightCount"
														},
														{
															render : function(data, type, row) {
																var operation = '<a type="button" class="btn btn-success btn-xs" href=\"${pageContext.request.contextPath}/weightAccount/account_validate_log.jsp?mobile='
																		+ row.mobile + '\">查看明细</a>&nbsp;';
																var level = ${user_session_key.level};
																if (4 != level) {
																	if (2 == row.weightFlag) {
																		operation += '<a type="button" class="btn btn-info btn-xs" href=\"${pageContext.request.contextPath}/WeightAccount/updateUserWeightFlag?userId='
																				+ row.id + '&weightFlag=3\">设为普通用户</a>';
																	} else {
																		operation += '<a type="button" class="btn btn-danger btn-xs" href=\"${pageContext.request.contextPath}/WeightAccount/updateUserWeightFlag?userId='
																				+ row.id + '&weightFlag=2\">设为vip账号</a>';
																	}
																}
																return operation;
															}
														} ],
												"oLanguage" : {
													"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
												}
											});
						});
	</script></main>
</body>
</html>
