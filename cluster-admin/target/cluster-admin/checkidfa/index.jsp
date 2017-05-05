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

select.form-control {
	width: auto;
}

.p0 {
	padding: 0px;
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
					<li><a href="#">已发布任务</a></li>
					<li><a href="#" class="active">添加</a></li>
				</ol>
			</div>
			<div class="col-xs-9 text-right">
				<span class="btn btn-success fileinput-button" style="width: 100px;"> 
					<i class="glyphicon glyphicon-plus"></i> 
					<span>导入IDFA</span>
					<input id="importIdfa" type="file" name="importIdfafile" />
				</span>
			</div>
		</div>
		<div class="row padding-15-tb">
			<div class="col-xs-12">
				<form id="form_export" class="form-horizontal" method="post">
					<div class="form-group">
						<label for="name" class="col-xs-3 control-label">appid</label>
						<div class="col-xs-7">
							<input name="appid" type="text" class="form-control" id="appid"
								placeholder="appid" required="required">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">有效时间段</label>
						<div class="col-xs-3 s">
							<input type="text" class="form-control" name="startTime"
								id="startTime"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" />
						</div>
						<div class="col-xs-3 e">
							<input type="text" class="form-control" name="endTime"
								id="endTime"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" />
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<div class="row padding-15-tb">
			<div class="col-xs-12">
					<div class="form-group">
						<label for="inputEmail" class="col-xs-3 control-label">
							<button id="btn_import" type="button" class="btn btn-success">导入表</button>
						</label>
						<label for="inputEmail" class="col-xs-3 control-label">
							<button id="btn_total" type="button" class="btn btn-success">总表</button>
						</label>
						<label for="inputEmail" class="col-xs-3 control-label">
							<button id="btn_diff" type="button" class="btn btn-success">差异表</button>
						</label>
						<label for="inputEmail" class="col-xs-3 control-label">
							<button id="btn_join" type="button" class="btn btn-success">相同表</button>
						</label>
					</div>
			</div>
		</div>
	</div>
	</main>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#importIdfa').on('click', function(e) {
				$(this).fileupload({
				    url:"../upload/importIdfa",
				    formData:{appid:$('#appid').val()},
				    done:function(e,result){
				    	bootbox.dialog({  
			                message: eval("("+result.result+")").msg,  
			                title: "提示",  
			                buttons: {  
			                    OK: {  
			                        label: "OK",  
			                        className: "btn-primary",  
			                        callback: function () {
			                        	window.location.reload();
			                        }  
			                    }  
			                }  
			            }); 				    	
				    }
				});
			});
			
			// 导入表
			$('#btn_import').on('click', function(e) {
				$('#form_export').attr('action', 'export_import');
				$('#form_export').submit();
			});

			// 总部
			$('#btn_total').on('click', function(e) {
				$('#form_export').attr('action', 'export_total');
				$('#form_export').submit();
			});

			// 差异表
			$('#btn_diff').on('click', function(e) {
				$('#form_export').attr('action', 'export_diff');
				$('#form_export').submit();
			});

			// 相同表
			$('#btn_join').on('click', function(e) {
				$('#form_export').attr('action', 'export_join');
				$('#form_export').submit();
			});

		});
		</script>
			
</body>
</html>
