<!-- 引入JQuery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<!-- 引入Bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap/js/bootstrap.min.js"></script>
<!-- 引入自定义样式 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />

<!-- 引入Jquery File Upload -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/jquery-file-upload/css/jquery.fileupload.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/jquery-file-upload/js/jquery.iframe-transport.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/jquery-file-upload/js/jquery.fileupload.js"></script>
</head>
<!-- 引入Bootstrap验证框架 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/bootstrapvalidator/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrapvalidator/js/bootstrapValidator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrapvalidator/js/language/zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_app_validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_pushtask_validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/edit_pushtask_validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/add_user_validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/edit_user_validate.js"></script>
<!-- 引入Bootstrap Switch -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-switch/css/bootstrap-switch.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-switch/js/bootstrap-switch.js"></script>
<!-- 引入Bootstrap DateTime Picker控件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- 引入Bootstrap Date Picker控件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datepicker/css/datepicker.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootstrap-datepicker/js/moment.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/css/dataTables.bootstrap.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/bootbox/bootbox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/thirdpart_framework/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn_search").on("click", function() {
			var url = "${pageContext.request.contextPath}/account/search?key=" + encodeURIComponent(encodeURIComponent($('#keywords').val()));
			window.location.href = url;
		});
	});
</script>