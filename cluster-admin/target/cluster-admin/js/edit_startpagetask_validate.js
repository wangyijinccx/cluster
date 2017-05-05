$(document).ready(function() {
	$('#editStartPageTaskForm').bootstrapValidator({
		// To use feedback icons, ensure that
		// you use Bootstrap v3.1.0 or later
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			price : {
				validators : {
					notEmpty : {
						message : '单价为必填项，不能为空'
					},
					between : {
						min : 0,
						max : 100000000,
						message : '超出了合理的数值范围'
					}
				}
			},
			adText : {
				validators : {
					notEmpty : {
						message : '广告语为必填项，不能为空'
					}
				}
			},
			url : {
				validators : {
					notEmpty : {
						message : '跳转地址为必填项，不能为空'
					}
				}
			}
		}
	});
});