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
					<div class="form-group form-inline">
						<select class="form-control" name="province" id="province"></select>
						<select class="form-control" name="city" id="city">
							<option value="">请选择</option>
						</select> <select class="form-control" name="area" id="area">
							<option value="">请选择</option>
						</select>
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
							<th>帐号</th>
							<th>身份</th>
							<th>姓名</th>
							<th>电话</th>
							<th>昵称</th>
							<th>地址</th>
							<th>完成快速任务</th>
							<th>完成常规任务</th>
							<th>竞品数量</th>
							<th width="63"></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<input type="hidden" id="uid" value="${uid}" /> <script
		type="text/javascript">
		$(function() {
			function findAreaByParent(pid, target) {
				$.ajax({
					type : "POST",
					url : '${pageContext.request.contextPath}/Area/findAreaByParent',
					data : {
						pid : pid
					},
					error : function(request) {
						console.inf('获取数据错误');

					},
					success : function(data) {
						var jsonObjectData = JSON.parse(data);

						var target_select = $(target);
						target_select.empty();
						target_select.append('<option value="">请选择</option>');
						$.each(jsonObjectData, function(i) {
							var item = jsonObjectData[i];
							target_select.append('<option value="'+ item.id +'">' + item.areaName + '</option>')
						})
					}
				});
			}
			findAreaByParent(0, province);
			$('#province').on('change', function() {
				if (this.value != "") {
					findAreaByParent(this.value, city);
				} else {
					$('#city').empty().append('<option value="">请选择</option>');
				}

				$('#area').empty().append('<option value="">请选择</option>');
				search();

			});
			$('#city').on('change', function() {
				if (this.value != "") {
					findAreaByParent(this.value, area);
				} else {
					$('#area').empty().append('<option value="">请选择</option>')
				}
				search();
			});
			$('#area').on('change', search);
			var table = $('#datalist').dataTable({
				"bAutoWidth" : false,
				"bPaginate" : true, //是否分页。
				"bServerSide" : true,
				"bProcessing" : true,
				"searching" : true,
				"bLengthChange" : true,
				"scrollCollapse" : true,
				//"scrollY": "400px",
				"pagingType" : "full_numbers",
				"dom" : '<"toolbar">frtilp',
				"aLengthMenu" : [ 100, 500, 1000 ],
				// "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/account/Load_MemberUserList",
					"data" : function(d) {
						d.start_date = $("#start").val();
						d.end_data = $("#end").val();
						d.province = $('#province').val();
						d.city = $('#city').val();
						d.area = $('#area').val();
						d.pid = '${pid}';
					},
					"dataType" : "json",
					"method" : "POST"
				},
				"columns" : [ {
					render : function(data, type, row) {
						return new Date(parseInt(row.createTime)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
					}
				}, {
					"data" : "username"
				}, {
					"render" : function(data, type, row) {
						return '成员';
					}
				}, {
					"data" : "name"
				}, {
					"data" : "mobile"
				}, {
					"data" : "nickname"
				}, {
					"render" : function(data, type, row) {
						return row.provinceName + ' ' + row.cityName + ' ' + row.areaName + ' ' + row.address
					}
				}, {
					"data" : "taskfast"
				}, {
					"data" : "taskads"
				}, {
					"data" : "competitorNum"
				}, {
					"render" : function(data, type, row) {
						var tc = '<a type="button" class="btn btn-danger btn-xs" onclick=\"kickOut(' + row.id + ')\">踢出</a>'
						if ($('#uid').val() != row.p_user) {
							tc = '';
						}
						return tc + ' <a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/account/UserDetail?id=' + row.id + '">查看</a>';
					}
				}

				],
				"oLanguage" : {
					"sUrl" : "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
				}
			});

		});
		function kickOut(id) {
			$.ajax({
				type : "POST",
				url : '${pageContext.request.contextPath}/account/kickout',
				data : {
					id : id
				},
				error : function(request) {
					console.info(request);
					alert("Connection error");
				},
				success : function(data) {
					bootbox.alert({
						buttons : {
							ok : {
								label : '确定',
								className : 'btn-myStyle'
							},
							list : {
								label : '关闭',
								className : 'btn-myStyle'
							}
						},
						message : JSON.parse(data).msg,
						callback : function(e) {

						},
						title : "提示",
					});
				}
			});
		}
		function search() {
			$('#datalist').dataTable().fnDraw();
		}
	</script> </main>
</body>
</html>
