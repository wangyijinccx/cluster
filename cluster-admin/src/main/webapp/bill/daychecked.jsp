<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
					<li><a href="#">兑换</a></li>
					<li><a href="${pageContext.request.contextPath}/bill/checked/list">审核订单</a></li>
					<li><a href="#" class="active">订单明细</a></li>
				</ol>
			</div>
			<div class="col-xs-9 text-right">
				<div class="form-group form-inline">
					<input type="hidden" class="form-control input-lg" id="day"
						value="${day }" /> <input id="keywords"
						class="form-control input-lg" type="text"
						placeholder="用户ID/用户名/IDFA" />
					<button id="btn_search" type="button"
						class="btn btn-primary btn-lg">搜索</button>
				</div>


			</div>
		</div>
		<div class="row border-bottom padding-15-tb">
			<div class="col-xs-2 text-left ">${day }日提交</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="text-center">提交时间</th>
							<th class="text-center">ID</th>
							<th class="text-center">账号</th>
							<th class="text-center">邀请码</th>
							<th class="text-center">省份</th>
							<th class="text-center">城市</th>
							<th class="text-center">用户类型</th>
							<th class="text-center">交易类型</th>
							<th class="text-center">充值手机</th>
							<th class="text-center">支付宝账号</th>
							<th class="text-center">兑换金额(元)</th>
							<th class="text-center">兑换指数</th>
							<th class="text-center">状态</th>
							<th class="text-center" width="20"></th>
						</tr>
					</thead>
					<tbody class="text-center">
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
				"bLengthChange" : true, //改变每页显示数据数量
				//"bFilter": true, //过滤功能
				"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,2,3,4,5,6,7,8,9,10 ] }] , // 屏蔽不需排序的列
				"bSort" : true, //排序功能
				"aaSorting" : [ [ 0, "desc" ] ],
				//"bStateSave": false, //保存当前页面信息为cookie，默认关闭
				"scrollCollapse" : true,
				//"scrollY": "400px",
				"pagingType" : "full_numbers",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/bill/checked/data_load_day",
					"data" : function(d) {
						d.day = $("#day").val();
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "day"
				}, {
					"data" : "id"
				}, {
					"data" : "mobile"
				}, {
					"data" : "inviteCode"
				}, {
					"data" : "province"
				}, {
					"data" : "city"
				}, {
					"data" : "type"
				}, {
					"data" : "exchangetype"
				}, {
					"data" : "phone"
				}, {
					"data" : "alipayaccount"
				}, {
					"data" : "amount"
				}, {
					"data" : "exchangeindex"
				}, {
					"data" : "status"
				}, {
					"render" : function(data, type, row) {
						return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/bill/checked/checking?mobile=' + row.mobile + '&id='+row.id+'">查看</a>';
					}
				} ],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

			$("#search").on("click", function() {
				table.fnDraw();
			});
		});
	</script> </main>
</body>
</html>