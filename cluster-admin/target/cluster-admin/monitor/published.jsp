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
					<li><a href="#">运行状态检测</a></li>
				</ol>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
						    <th>PC编号</th>
							<th>模拟器编号</th>
							<th>模拟器状态</th>
							<th>模拟器操作</th>
							<th>运行的游戏</th>
							<th>脚本编号</th>
							<th>脚本状态</th>
							<th>脚本控制</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					var table = $('#datalist').dataTable(
							{
								"bAutoWidth" : false,
								"bPaginate" : false, //是否分页。
								"bServerSide" : true,
								"bProcessing" : true,
								"searching" : false,
								"bLengthChange" : true,
								"scrollCollapse" : true,
								"bInfo" : false,
								"bSort" : false,
								//"order" : [ [ 0, "desc" ] ],
								//"scrollY": "400px",
								"pagingType" : "full_numbers",
								//"aLengthMenu" : [ 20, 50, 100 ],
								// "dom": '<"toolbar">frtip',
								// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
								"ajax" : {
									"url" : "${pageContext.request.contextPath}/cserver/getDevices",
									"dataType" : "json",
									"method" : "POST"
								},
								"columns" : [
										{
											"data" : "hostIp"
										},
										{
											"data" : "udid"
										},
										{
											"render" : function(data, type, row) {
												var status = row.state;
												return status == "OFFLINE" ? "宕机" :status == "BUSY" ? "占用" :
													status == "FREE" ? "空闲" : "启动中" ;
											}
										},
										{
											"render" : function(data, type, row) {
												return '<a type="button" class="btn btn-primary btn-xs" href="javascript:reboot(\''+ row.udid +'\')">重启</a>'	;	
											}
										},
										{
											//"data" : "gameName"
											"render" : function(data, type, row) {
												var state =  row.state;
												return state == "BUSY" ? row.gameName : "";
											}
										},
										{
											//"data" : "script"
											"render" : function(data, type, row) {
												var state =  row.state;
												return state == "BUSY" ? row.scriptId : "";
											}
										},
										{
											"render" : function(data, type, row) {
												var state =  row.state;
												if(state == "BUSY"){
													var status = row.scriptState;
													return status == "DONE" ? "已完成" :status == "RUNNING" ? "运行" : status == "ERROR" ?"异常" : status == "PAUSE" ?"暂停":停止;
												}else{
													return "";
												}
												
											}
										},
										{
											"render" : function(data, type, row) {
												var state =  row.state;
												if(state == "BUSY"){
													if (row.scrStatus == 1) {
														//return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/game/account/begain?id=' + row.id + '">执行</a>';
														return '<a type="button" class="btn btn-primary btn-xs" href="javascript:begin(\''+ row.id +'\')">执行</a>';
													}
													else if(row.scrStatus == 2){
														return '<a type="button" class="btn btn-primary btn-xs" href="javascript:perform()">执行中</a>'
														+'<a type="button" class="btn btn-primary btn-xs" href="javascript:pause(\''+ row.id +'\')">暂停</a>'
														+'<a type="button" class="btn btn-primary btn-xs" href="javascript:stop(\''+ row.id +'\')">停止</a>';
														//+'<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/game/account/stop?id=' + row.id + '">停止</a>';
													}else if(row.scrStatus == 3){
														return '<a type="button" class="btn btn-primary btn-xs" href="javascript:begin(\''+ row.id +'\')">异常</a>';
													}else if(row.scrStatus == 4){
														return '<a type="button" class="btn btn-primary btn-xs" href="javascript:resume(\''+ row.id +'\')">继续</a>'
														+'<a type="button" class="btn btn-primary btn-xs" href="javascript:stop(\''+ row.id +'\')">停止</a>';
													}
												}else{
													return "";
												}
											}
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
		
		function myrefresh() 
		{ 
		    window.location.reload(); 
		} 
		
		setTimeout('myrefresh()',30000); //指定30秒刷新一次 
		
		function perform(){
			alert("执行中请等待");
		}
		
		function reboot(id) {
			if (confirm('确定执行此操作吗？')) {
				$.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/cserver/reboot',
					data : {
						id : id
					},
					error : function(request) {
						console.inf('链接错误');
	
					},
					success : function(data) {
						if (1001 == data) {
							alert('重启成功');
							$('#datalist').dataTable().fnDraw();
						} else {
							alert('重启失败');
						}
					}
				});
			}
		}
		
		
		function begin(id) {
			if (confirm('确定执行此操作吗？')) {
				$.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/game/account/begain',
					data : {
						id : id
					},
					error : function(request) {
						console.inf('链接错误');
	
					},
					success : function(data) {
						if (1001 == data) {
							alert('脚本开始执行');
							$('#datalist').dataTable().fnDraw();
						} else {
							alert('脚本开始执行失败');
						}
					}
				});
			}
		}
		
		function stop(id) {
			if (confirm('确定执行此操作吗？')) {
				$.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/game/account/stop',
					data : {
						id : id
					},
					error : function(request) {
						console.inf('链接错误');
	
					},
					success : function(data) {
						if (1001 == data) {
							alert('脚本已停止');
							$('#datalist').dataTable().fnDraw();
						} else {
							alert('脚本停止失败');
						}
					}
				});
			}
		}
		
		function pause(id) {
			if (confirm('确定执行此操作吗？')) {
				$.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/game/account/pause',
					data : {
						id : id
					},
					error : function(request) {
						console.inf('链接错误');
	
					},
					success : function(data) {
						if (1001 == data) {
							alert('脚本暂停执行');
							$('#datalist').dataTable().fnDraw();
						} else {
							alert('脚本暂停执行失败');
						}
					}
				});
			}
		}
		
		function resume(id) {
			if (confirm('确定执行此操作吗？')) {
				$.ajax({
					type : "GET",
					url : '${pageContext.request.contextPath}/game/account/resume',
					data : {
						id : id
					},
					error : function(request) {
						console.inf('链接错误');
	
					},
					success : function(data) {
						if (1001 == data) {
							alert('脚本继续执行');
							$('#datalist').dataTable().fnDraw();
						} else {
							alert('脚本继续执行失败');
						}
					}
				});
			}
		}
	</script> </main>
</body>
</html>
