<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/common/meta.jsp"%>
 <script type="text/javascript" charset="utf-8" src="../thirdpart_framework/ueditor1_4_3-utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../thirdpart_framework/ueditor1_4_3-utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="../thirdpart_framework/ueditor1_4_3-utf8-jsp/lang/zh-cn/zh-cn.js"></script>
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
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_notice_validate.js"></script>
</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
		<div class="container-fluid">
			<div class="row border-bottom padding-top-15 ">
				<div class="col-xs-2 text-left">
					<ol class="breadcrumb">
						<li><a href="#">公告</a></li>
						<li><a href="#" class="active">添加公告</a></li>

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
			<div class="row padding-15-tb">
				<div class="col-xs-12">
					<form id="account_form" class="form-horizontal" role="form"
						action="${pageContext.request.contextPath}/notice/add_do">
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">标题</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="title"
									name="title" placeholder="请输入标题">
							</div>
						</div>
						<div class="form-group">
							<label for="endDateTime" class="col-sm-2 control-label">截至日期</label>
							<div class="col-sm-4">
							<input type="text" name="tempenddate" class="form-control"  value="<fmt:formatDate value="${noticeRecord.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword"
								class="col-xs-2  control-label">图片</label>
							<div class="col-xs-4">
								<div>
									<div class="col-sm-10 p0" style=" padding-left: 0px; ">
										<input class="form-control " type="text" name="img" id="img" />
									</div>
									<div class="col-sm-2 text-right p0"
										style="padding-right:0px;padding-left:0px;">
										<span class="btn btn-success fileinput-button"
											style="width:70px;"> <i
											class="glyphicon glyphicon-plus"></i> <span>选择</span> <!-- The file input field used as target for the file upload widget -->
											<input id="fileupload" type="file" name="file" />
										</span>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<div class="form-group">
							<label for="inputPassword"
								class="col-xs-2  control-label">摘要</label>
							<div class="col-xs-4">
								<textarea rows="50" cols="100" name="summary" id="summary" maxlength="200" style="width: 488px; height: 126px"></textarea>

							</div>
						</div>
						<div class="form-group">
							<label for="endTime2" class="col-sm-2 control-label">截止日</label>
							<div class="col-sm-3 col-xm-3">
								
									
							</div>
						</div>
						<div class="form-group">
							<label for="confirmpassword" class="col-sm-2 control-label">内容</label>
							<div class="col-sm-4">
								  <script id="content" name="content" type="text/plain" style="width:1024px;height:500px;"></script>
							</div>
						</div>
						
						
					
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-6 text-center">
								<button type="submit" class="btn btn-primary">创建</button>
								<button type="reset" class="btn btn-default">重置</button>
								<a href="list" type="reset" class="btn btn-default">返回</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</main>
	<script type="text/javascript">
		$(function() {
			var ue = UE.getEditor('content');
		});
	</script>
</body>
</html>
