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
					<li><a href="#">查询</a></li>
					<li><a href="#" class="active">成员查询</a></li>


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

			<div class="col-xs-12 text-right ">
				<div class="form-inline " role="form">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">从</div>
							<input id="start" name="start" class="form-control" type="text"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:search,oncleared:search})" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">到</div>
							<input id="end" name="end" class="form-control" type="text"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:search,oncleared:search})" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th rowspan="2">日期</th>
							<th colspan="4">线下用户</th>
							<th colspan="3">线上用户</th>
							<th rowspan="2">操作</th>
						</tr>
						<tr>
							<th>A类完成次数/收益金币</th>
							<th>B类完成次数/收益金币</th>
							<th>C类完成次数/收益金币</th>
							<th>普通完成次数/收益金币</th>
							<th>B类完成次数/收益金币</th>
							<th>C类完成次数/收益金币</th>
							<th>普通完成次数/收益金币</th>

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
					"url" : "${pageContext.request.contextPath}/search/data_member_list",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_date = $("#end").val();
						d.search = $("#keywords").val();
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "day"
				}, {
					"render" : function(data, type, row) {
						return row.offline_a_time + '/' + row.offline_a_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return row.offline_b_time + '/' + row.offline_b_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return row.offline_c_time + '/' + row.offline_c_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return row.offline_d_time + '/' + row.offline_d_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return row.online_b_time + '/' + row.online_b_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return row.online_c_time + '/' + row.online_c_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return row.online_d_time + '/' + row.online_d_earnings
					}
				}, {
					"render" : function(data, type, row) {
						return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/search/member_day_task">查看</a>';
					}
				} ],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

		});
		function search() {
			$('#datalist').dataTable().fnDraw();
		}
	</script> </main>
</body>
</html>
