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
					<li><a
						href="${pageContext.request.contextPath}/account/exception">账户异常</a></li>
					<li><a href="#" class="active">日志</a></li>
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
		<div class="row padding-top-15">
			<div class="col-xs-12 text-right">
				<button id="btn_addblack" type="button" class="btn btn-danger">加入黑名单</button>
				<button id="btn_deal" type="button" class="btn btn-primary">处理</button>
				<button id="btn_back" type="button" class="btn btn-default">返回</button>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>时间</th>
							<th>所在地</th>
							<th>用户名</th>
							<th>apple ID</th>
							<th>IDFA</th>
							<th>处理时间</th>
							<th>处理人员</th>
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
				"dom" : 'rt',
				"aLengthMenu" : [100, 500, 1000],
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/ExceptionAccount/getUserException",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
						d.mobile = "${mobile}";
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					"data" : "createTime"

				}, {
					"render" : function(data, type, row) {
						return row.province + ' - ' + row.city
					}
				}, {
					"data" : "moblie"
				}, {
					"data" : "appleId"
				}, {
					"data" : "idfa"
				}, {
					"data" : "processTime"
				}, {
					"data" : "operator"
				}

				],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

			$("#btn_back").on("click", function() {
				window.location.href = "${pageContext.request.contextPath}/account/exception";
			});
			$("#btn_deal").on("click", function() {
				$.ajax({
					url : "${pageContext.request.contextPath}/ExceptionAccount/processException",
					Type : "POST",
					data : {
						id : '${id}',
						mobile : '${mobile}'
					},
					success : function(data) {
						bootbox.alert({
							buttons : {
								list : {
									label : '返回列表',
									className : 'btn-myStyle'
								},
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.msg,
							callback : function(e) {
								if (e == "list") {
									window.location = "../exception"
								}
							},
							title : "提示",
						});
					}
				});
			});
			$('#btn_addblack').on('click', function() {
				$.ajax({
					url : "${pageContext.request.contextPath}/ExceptionAccount/saveToBlackUser",
					Type : "POST",
					data : {
						mobile : '${mobile}'
					},
					success : function(data) {
						bootbox.alert({
							buttons : {
								list : {
									label : '返回列表',
									className : 'btn-myStyle'
								},
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : data.msg,
							callback : function(e) {
								if (e == "list") {
									window.location = "../exception"
								}
							},
							title : "提示",
						});
					}
				});
			})
		});
	</script> </main>
</body>
</html>
