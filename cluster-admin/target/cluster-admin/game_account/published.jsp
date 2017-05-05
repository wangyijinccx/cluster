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

<script type="text/javascript">
$(function(){
	$("#fileupload").fileupload({

	    url:"./uploadfile",//文件上传地址，当然也可以直接写在input的data-url属性内

	    formData:{gameId: $("#game_id").val()},//如果需要额外添加参数可以在这里添加

	    done:function(e,result){

	        //done方法就是传完毕的上回调函数，其他回调函数可以自行查看api

	        //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息

	        //返回的数据在result.result中，假设我们服务器返回了一个json对象
	        var re =  eval("(" + result.result + ")");
	        alert(re.status);
	    	window.location = "${pageContext.request.contextPath}/game/account/published?id="+$("#game_id").val();

	    }

	});
});
</script>

</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	<div class="container-fluid">
		<div class="row border-bottom padding-top-15 ">
			<div class="col-xs-2 text-left">
				<ol class="breadcrumb">
					<li><a href="#">游戏账号</a></li>
					<li><a href="#" class="active">游戏账号列表</a></li>
				</ol>
			</div>
		</div>

		<div class="row border-bottom padding-15-tb">
			<div class="col-xs-12 text-right">
				<form id="export_from" method="POST">
					<input type="hidden" name="game_id" id="game_id" value="${game_id}" />
					<div class="form-inline " role="form">
						<button id="btn_collect_button_begin" type="button"
									onclick="allbegin()" class="btn btn-success">开始脚本</button>
						<button id="btn_collect_button_end" type="button"
								onclick="allend()" class="btn btn-success">结束脚本</button>
						<span class="btn btn-success fileinput-button"
							style="width: 70px;"> <i class="glyphicon glyphicon-plus"></i>
							<span>新增</span> <input id="fileupload" type="file" name="file" />
						</span>
						<button id="btn_collect_export" type="button"
							class="btn btn-success">导出</button>
					</div>
				</form>
			</div>
		</div>


		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<table id="datalist"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
						    <th class="">
					          <input type="checkbox" value="" title="" id="selectall" />
					        </th>
							<th>用户名</th>
							<th>密码</th>
							<th>所在服务器</th>
							<th>脚本运行时长(分钟)</th>
							<th>管理操作</th>
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
								"bPaginate" : true, //是否分页。
								"bServerSide" : true,
								"bProcessing" : true,
								"searching" : false,
								"bLengthChange" : true,
								"bSort" : false,
								"scrollCollapse" : true,
								"order" : [ [ 0, "desc" ] ],
								//"scrollY": "400px",
								"pagingType" : "full_numbers",
								"aLengthMenu" : [ 20, 50, 100 ],
								// "dom": '<"toolbar">frtip',
								// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
								"fnDrawCallback": function() {
										$("#selectall").prop("checked", false);
						             },
								"ajax" : {
									"url" : "${pageContext.request.contextPath}/game/account/data_publish",
									"data" : function(d) {
										d.game_id = $("#game_id").val();
									},
									"dataType" : "json",
									"method" : "POST"
								},
								"columns" : [
										{
											"render" : function(data, type, row) {
												if (row.status == 1 || row.status == 3) {
													return '<input type="checkbox" value="'+row.id+'"  name ="case" onclick="checkClick()" />';
												}else{
													return '<input type="checkbox" value=""   disabled="disabled"/>';
												}
												
											}
										},    
										{
											"data" : "account"
										},
										{
											"data" : "passwd"
										},{
											"data" : "gameServer"
										},
										{
											"data" : "runTime"
										},{
											"render" : function(data, type, row) {
												return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/game/account/update?game_id=' + row.gameId + '&id=' + row.id + '">编辑</a>';
											}
										}
										,{
											"render" : function(data, type, row) {
												if (row.status == 1) {
													//return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/game/account/begain?id=' + row.id + '">执行</a>';
													return '<a type="button" class="btn btn-primary btn-xs" href="javascript:begin(\''+ row.id +'\')">执行</a>';
												}
												else if(row.status == 2){
													return '<a type="button" class="btn btn-primary btn-xs" href="javascript:perform()">执行中</a>'
													+'<a type="button" class="btn btn-primary btn-xs" href="javascript:pause(\''+ row.id +'\')">暂停</a>'
													+'<a type="button" class="btn btn-primary btn-xs" href="javascript:stop(\''+ row.id +'\')">停止</a>';
													//+'<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/game/account/stop?id=' + row.id + '">停止</a>';
												}else if(row.status == 3){
													return '<a type="button" class="btn btn-primary btn-xs" href="javascript:begin(\''+ row.id +'\')">异常</a>';
												}else if(row.status == 4){
													return '<a type="button" class="btn btn-primary btn-xs" href="javascript:resume(\''+ row.id +'\')">继续</a>'
													+'<a type="button" class="btn btn-primary btn-xs" href="javascript:stop(\''+ row.id +'\')">停止</a>';
												}else if(row.status == 5){
													return '<a type="button" class="btn btn-primary btn-xs" href="javascript:distribution()">分配中</a>';
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
		
		function perform(){
			alert("执行中请等待");
		}
		
		function distribution(){
			alert("分配中，请稍后刷新重试");
		}
		
		$('#btn_collect_export').on('click', function(e) {
			$('#export_from').attr('action', 'export');
			$('#export_from').submit();
		});
		
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
		
		 $("#selectall").click(function () {
		    	$("input[name='case']").prop("checked", this.checked);
		    });
		 
		 
		 function allbegin() {
				var uwcids = null;
				$('input[name="case"]:checked').each(function(){ 
				  if(null == uwcids){
					  uwcids = $(this).val();
				  }else{
					  uwcids = uwcids + ":" + $(this).val();
				  }
				}); 
				if(null == uwcids){
					alert("请选择脚本");
					return;
				}
			    var url = "${pageContext.request.contextPath}/game/account/allbegain";
				if (confirm('确定执行此操作吗？')) {
					$.post(url, {
						uwcids : uwcids
					}, function(data) {
						if (1001 == data) {
							alert('开始所有脚本成功');
							$('#datalist').dataTable().fnDraw();
						} else {
							alert('开始所有脚本失败');
						}
					});
				}
			}
		 function allend() {
		    var url = "${pageContext.request.contextPath}/game/account/allstop";
		    if (confirm('确定执行此操作吗？')) {
				$.post(url, {
				}, function(data) {
					if (1001 == data) {
						alert('停止所有脚本成功');
						$('#datalist').dataTable().fnDraw();
					} else {
						alert('停止所有脚本失败');
					}
				});
			}
		 }
	</script> </main>
</body>
</html>
