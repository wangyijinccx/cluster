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
						<li><a href="#">查询</a></li>
						<li><a href="#" class="active">用户概览</a></li>

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
				<div class="col-xs-4 line-height-34 ">累计注册用户： 210000 人</div>
				<div class="col-xs-8 text-right ">
					<div class="form-inline " role="form">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">从</div>
								<input id="start" name="start" class="form-control " placeholder="请选择开始日期" type="text" onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,onpicked:search,oncleared:search})"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">到</div>
								<input id="end" name="end" class="form-control" type="text" placeholder="请选择结束日期" onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,onpicked:search,oncleared:search})"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row border-bottom padding-15-tb">
				<div class="col-xs-1">
					<span class="label label-primary">线下：</span>
				</div>
				<div class="col-xs-2">A类用户：${userInfo.offlineAUsers}</div>
				<div class="col-xs-2">B类用户：${userInfo.offlineBUsers}</div>
				<div class="col-xs-2">C类用户：${userInfo.offlineCUsers}</div>
				<div class="col-xs-2">普通用户：${userInfo.offlineUsers}</div>
			</div>
			<div class="row border-bottom padding-15-tb">
				<div class="col-xs-1">
					<span class="label label-primary">线上：</span>
				</div>
				<div class="col-xs-2"></div>
				<div class="col-xs-2">B类用户：${userInfo.onlineBUsers}</div>
				<div class="col-xs-2">C类用户：${userInfo.onlineCUsers}</div>
				<div class="col-xs-2">普通用户：${userInfo.onlineUsers}</div>
				<div class="col-xs-3 text-right"></div>
			</div>
			<div class="row padding-top-15">
				<div class="col-xs-12 text-right">
				 <a  class="btn btn-primary"  href="${pageContext.request.contextPath}/search/export_user_list?start_date=${start}&end_date=${end}">导出Excel</a>
				</div>
			</div>
			<div class="row padding-15-tb">
				<div class="col-xs-12">
					<table id="datalist"
						class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>日期</th>
								<th>新增用户（人）</th>
								<th>游客（人）</th>
								<th>注册用户(人)</th>
								<th>游客转注册(人)</th>
								<th>转化率</th>
								<th>普通转高级(人)</th>
								<th>转化率</th>
								<th>登陆活跃(人)</th>
								<th>下载活跃(人)</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
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
													// "dom": '<"toolbar">frtip',
													// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
													"ajax" : {
														"url" : "${pageContext.request.contextPath}/search/load_users_page",
														"data" : function(d) {
															d.start_date = $(
																	"#start")
																	.val();
															d.end_date = $(
																	"#end")
																	.val();
															d.search = $(
																	"#keywords")
																	.val();
														},
														"dataType" : "json",
														"method" : "POST"
													},
													"columns" : [
															{
																"data" : "date"
															},
															{
																"data" : "newuser"
															},
															{
																"data" : "visitor"
															},
															{
																"data" : "alluser"
															},
															{
															    "data" : "visitortouser"
															},
															{
																
																"render": function (data, type, row) {
                                                                        return row.pecent+"%"
                                                                  }
															},
															{
																"data" : "ptzgj"
															},
															{
																"data" : "ptzgjpecent"
															},
															{
																"data" : "loginactive"
															},
															{
																"data" : "downloadactive"
															}

													],
													"oLanguage" : {
														"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
													}
												});
								
							});
							function search() {
								  $('#datalist').dataTable().fnDraw();
								}
		</script>
	</main>
</body>
</html>
