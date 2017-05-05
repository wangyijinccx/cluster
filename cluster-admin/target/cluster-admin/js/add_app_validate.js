$(document).ready(function() {
	$('#addAppForm').bootstrapValidator({
		// To use feedback icons, ensure that
		// you use Bootstrap v3.1.0 or later
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			applicationId : {
				validators : {
					notEmpty : {
						message : 'AppId为必填项，不能为空'
					}
				}
			},
			name : {
				validators : {
					notEmpty : {
						message : '应用名称为必填项，不能为空'
					}
				}
			},
			currency : {
				validators : {
					notEmpty : {
						message : '货币名称为必填项，不能为空'
					}
				}
			},
			proportion : {
				validators : {
					integer : {
						message : '兑换比例必须要为整数'
					},
					between : {
						min : 0,
						max : 100000000,
						message : '超出了合理的数值范围'
					}
				}
			}
		}
	});
});