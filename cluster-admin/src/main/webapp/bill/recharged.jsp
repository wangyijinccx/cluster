<%@ page language="java" pageEncoding="UTF-8"
	import="java.text.SimpleDateFormat,java.util.Date"
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
			<div class="col-xs-2 text-left">
				<ol class="breadcrumb">
					<li><a href="#">兑换</a></li>
					<li><a href="#" class="active">充值订单</a></li>

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
		<div class="row border-bottom padding-15-tb">
			<div class="col-xs-5 text-left line-height-34 ">话费累计充值成功：${totalphonebill }
				元&nbsp;&nbsp;&nbsp;&nbsp;支付宝累计充值成功：${totalalipaybill } 元</div>
			<div class="col-xs-7 text-right ">
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
				</div>
			</div>
		</div>
		<div class="row padding-top-15">
			<div class="col-xs-12 text-right">
				<button id="btn_search" type="button" class="btn btn-primary">导出Excel</button>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>充值日期</th>
							<th>充值金额(元)</th>
							<th>话费充值成功/失败(元)</th>
							<th>支付宝提现成功/失败(元)</th>
							<th>充值次数</th>
							<th>成功次数</th>
							<th>失败次数</th>
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
		function search() {
			$('#datalist').dataTable().fnDraw();
		}

		$(document).ready(function() {
			var table = $('#datalist').dataTable({
				"bAutoWidth" : false,
				"bPaginate" : true, //是否分页。
				"bServerSide" : true,
				"bProcessing" : true,
				"searching" : false,
				"bLengthChange" : true, //改变每页显示数据数量
				//"bFilter": true, //过滤功能
				"aoColumnDefs" : [ {
					"bSortable" : false,
					"aTargets" : [ 1, 2, 3, 4, 5, 6, 7 ]
				} ], // 屏蔽不许排序的列
				//"bSort" : true, //排序功能
				"aaSorting" : [ [ 0, "desc" ] ],
				//"bStateSave": false, //保存当前页面信息为cookie，默认关闭
				"scrollCollapse" : true,
				//"scrollY": "400px",
				"pagingType" : "full_numbers",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/bill/recharged/data_load",
					"data" : function(d) {
						// alert(d);
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"render" : function(data, type, row) {
						var date = new Date();
						date.setTime(row.day);
						var reg = new RegExp("\\/", "g");
						return date.toLocaleDateString().replace(reg, '-');
					}
				}, {
					"render" : function(data, type, row) {
						return row.amount / 100;
					}
				}, {
					"render" : function(data, type, row) {
						return row.rechargeAmountSuccess / 100 + '/' + row.rechargeAmountFail / 100;
					}
				}, {
					"render" : function(data, type, row) {
						return row.cashAmountSuccess / 100 + '/' + row.cashAmountFail / 100;
					}
				}, {
					"data" : "times"
				}, {
					"data" : "successtimes"
				}, {
					"data" : "failtimes"
				}, {
					"render" : function(data, type, row) {
						var date = new Date();
						date.setTime(row.day);
						var reg = new RegExp("\\/", "g");
						var day = date.toLocaleDateString().replace(reg, '-');
						return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/bill/recharged/daylist?day=' + day + '">查看</a>';
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