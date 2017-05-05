$(function() {
	$('#editUserForm').bootstrapValidator({
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			username : {
				validators : {
					notEmpty : {
						message : '用户名为必填项，不能为空'
					},
					stringLength : {
						min : 2,
						max : 30,
						message : '用户名长度为2到30'
					}
				}
			},
			password : {
				validators : {
					stringLength : {
						min : 6,
						max : 15,
						message : '密码长度为长度为6到15'
					},
					regexp : {
						regexp : /^[a-zA-Z0-9_]+$/,
						message : '密码只能使用大小写字母、数字和下划线'
					}
				}
			}
		}
	});
});