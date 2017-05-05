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
					<li><a href="#" class="active">成员信息</a></li>

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
		<div class="row border-bottom padding-top-15 ">
			<div class="col-xs-11">
				<form class="form-inline" role="form">

					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">区域</div>
							<select class="form-control">
								<option value="0">全部</option>
								<option value="1">北京</option>
								<option value="2">河北</option>
								<option value="3">上海</option>
								<option value="4">南京</option>
							</select>
						</div>
					</div>


				</form>
			</div>
			<div class="col-xs-1">
				<a href="create" class="btn btn-success" type="button"
					id="btn_addAccount">添加</a>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>注册时间</th>
							<th>ID</th>
							<th>帐号</th>
							<th>身份</th>
							<th>姓名</th>
							<th>电话</th>
							<th>地址</th>
							<th width="63"></th>
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
				"aLengthMenu" : [100, 500, 1000 ],
				//"scrollY": "400px",
				"pagingType" : "full_numbers",
				// "dom": '<"toolbar">frtip',
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/account/search?keyword=" + encodeURIComponent("${keyword}"),
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "createTime"
				}, {
					"data" : "id"
				}, {
					"data" : "username"
				}, {
					"render" : function(data, type, row) {
						return '普通用户';
					}
				}, {
					"data" : "nickname"
				}, {
					"data" : "mobile"
				}, {
					"render" : function(data, type, row) {
						return row.provinceName + ' ' + row.cityName + ' ' + row.areaName + ' ' + row.address
					}
				}, {
					"render" : function(data, type, row) {
						return ' <a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/account/UserDetail?id=' + row.id + '">查看</a>';
					}
				}],
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
