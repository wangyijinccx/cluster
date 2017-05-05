$(document).ready(function() {
	$('#editPushTaskForm').bootstrapValidator({
		// To use feedback icons, ensure that
		// you use Bootstrap v3.1.0 or later
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			amount : {
				validators : {
					notEmpty : {
						message : '发送数量为必填项，不能为空'
					},
					integer : {
						message : '发送数量必须要为整数'
					},
					between : {
						min : 0,
						max : 100000000,
						message : '超出了合理的数值范围'
					}
				}
			},
			beginTime : {
				validators : {
					notEmpty : {
						message : '开始时间为必填项，不能为空'
					}
				}
			},
			sendDuration : {
				validators : {
					notEmpty : {
						message : '发送时长为必填项，不能为空'
					},
					integer : {
						message : '发送时长必须要为整数'
					},
					between : {
						min : 0,
						max : 10000,
						message : '超出了合理的数值范围'
					}
				}
			},
			rmb : {
				validators : {
					notEmpty : {
						message : '发送时长为必填项，不能为空'
					},
					integer : {
						message : '兑换比例必须要为整数'
					},
					between : {
						min : 0,
						max : 10000,
						message : '超出了合理的数值范围'
					}
				}
			}
		}
	});
});