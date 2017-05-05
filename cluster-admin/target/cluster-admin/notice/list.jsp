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
	padding-top: 5px;
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
			<div class="row border-bottom ">

				<div class="col-xs-12 text-right padding-15-tb">
					<a href="add" class="btn btn-success" type="button"
						id="btn_addAccount">添加</a>
				</div>
			</div>
			<div class="row padding-15-tb">
				<div class="col-xs-12">
					<table id="datalist"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>标题</th>
								<th>发布时间</th>
								<th>过期时间</th>
								<th>更新时间</th>
								<th>发布人</th>
								
								<th width="63">操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {

				var table = $('#datalist')
						.dataTable(
								{
									"bAutoWidth" : false,
									"bPaginate" : true, //是否分页。
									"bServerSide" : true,
									"bProcessing" : true,
									"searching" : true,
									"bLengthChange" : true,
									"scrollCollapse" : true,
									"order" : [ [ 1, "desc" ] ],
									//"scrollY": "400px",
									"pagingType" : "full_numbers",
									"dom" : '<"toolbar">frtilp',
									// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
									"ajax" : {
										"url" : "${pageContext.request.contextPath}/notice/list_do",
										"data" : function(d) {
											d.start_date = $("#start").val();
											d.end_data = $("#end").val();
										},
										"dataType" : "json",
										"method" : "POST"
									},

									"columns" : [
											{
												"data" : "title"
											},
											{
												"data" : "createTime"
											},

											{
												"data" : "endTime"
											},
											{
												"data" : "updateTime"
											},
											{
												"data" : "operatorName"
											},
											
											{
												"render" : function(data, type,
														row) {
													return '<a type="button" class="btn btn-Info btn-xs" href="${pageContext.request.contextPath}/notice/edit?id='
															+ row.id
															+ '">编辑</a> '
															+ '<a type="button" class="btn btn-danger btn-xs" href="javascript:del(\''+ row.id +'\')">删除</a>';
												}
											}

									],
									"oLanguage" : {
										"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
									}
								});

				$("div.toolbar").html('<a href=\"add\">添加</a>');

			});
			function del(id) {
				$.ajax({
					type : "POST",
					url : '${pageContext.request.contextPath}/notice/del',
					data : {
						id : id
					},
					error : function(request) {
						console.inf('链接错误');

					},
					success : function(data) {
						var jsonObjectData = JSON.parse(data);
						if (jsonObjectData.status) {
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
								message : jsonObjectData.msg,
								callback : function(e) {
									
$('#datalist').dataTable().fnDraw();
								},
								title : "提示",
							});
						}

					}
				});
			}
		</script>
	</main>
</body>
</html>
