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

					<li><a href="#" class="active">黑名单</a></li>
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

		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>加入时间</th>
							<th>ID</th>
							<th>帐号</th>
							<th>姓名</th>
							<th>电话</th>
							<th>注册时间</th>
							<th>帐号余额</th>
							<th>IDFA变更次数</th>
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
				"dom" : 'rtilp',
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/ExceptionAccount/getBlackUserList",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.search = $("#keywords").val();
						d.userId = "${userId}";
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					render : function(data, type, row) {
						return new Date(parseInt(row.createTime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
					}
				}, {
					"data" : "userid"
				}, {
					"data" : "mobile"
				}, {
					"data" : "name"
				}, {
					"data" : "mobile"
				}, {
					"data" : "registerTime"
				}, {
					"data" : "award"
				}, {
					"data" : "exceptioncount"
				}, {
					render : function(data, type, row) {
						return '<a type="button" class="btn btn-success btn-xs" onclick=\"backuser(' + row.id + ')\">恢复</a>';
					}
				}

				],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

		});
		function backuser(id) {
			$.ajax({
				url : "${pageContext.request.contextPath}/ExceptionAccount/reNewBlackUser",
				Type : "POST",
				data : {
					id : id
				},
				success : function(data) {
					bootbox.alert({
						buttons : {
							list : {
								label : '确定',
								className : 'btn-myStyle'
							},
							ok : {
								label : '关闭',
								className : 'btn-myStyle'
							}
						},
						message : data.msg,
						callback : function(e) {
							$('#datalist').dataTable().fnDraw();
						},
						title : "提示",
					});
				}
			});
		}
	</script> </main>
</body>
</html>
