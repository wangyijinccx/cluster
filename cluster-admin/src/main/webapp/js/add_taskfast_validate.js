$(function(){
	
//	$("#taskSource").change(function(){
//		var taskSource = $('#taskSource').val();
//		if('XINGZHETIANXIA' === taskSource || 'ZHIMENG' === taskSource || 'KEJINXINXI' === taskSource || 'LANGYIXUNLIAN' === taskSource || 'HUAI' === taskSource || 'YOUMI' === taskSource){
//			$('#ad').attr('style','display:block');
//		}else{
//			$('#ad').attr('style','display:none');
//		}
//	});
	
	$("input[name='taskType']").change(function(){
		var taskType = parseInt($("input[name='taskType']:checked").val());
		if(taskType > 100){
			$('#channel').attr('style','display:block');
		}else{
			$('#channel').attr('style','display:none');
		}
	});
	
	$("#fileupload").fileupload({

		    url:"../../upload/uploadfile",//文件上传地址，当然也可以直接写在input的data-url属性内

		    formData:{param1:"p1",param2:"p2"},//如果需要额外添加参数可以在这里添加

		    done:function(e,result){

		        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api

		        //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息

		        //返回的数据在result.result中，假设我们服务器返回了一个json对象

		        console.log(JSON.stringify(result.result));
		        $('#img').val(result.result);

		    }

		});

	$('#form_task').bootstrapValidator({
		 framework: 'bootstrap',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			appid:{
				validators : {
					notEmpty : {
						message : 'appid不能为空'
					}
				}
			},
			taskname:{
				validators : {
					notEmpty : {
						message : '任务名称不能为空'
					}
				}
			},
			description:{
				validators : {
					notEmpty : {
						message : '任务描述不能为空'
					}
				}
			},
			appDescription:{
				validators : {
					notEmpty : {
						message : '应用描述不能为空'
					}
				}
			},
			downloadUrl:{
				validators : {
					notEmpty : {
						message : '下载地址不能为空'
					}
				}
			},
			award:{
				validators : {
					notEmpty : {
						message : '任务奖励不能为空'
					}
				}
			},
			startTime:{
				row: '.s',
				validators:{
					notEmpty:{
						message:'有效期开始时间不能为空'
					}
				}
			},
			endTime:{
				row: '.e',
				validators:{
					notEmpty:{
						message:'有效期结束时间不能为空'
					}
				}
			},
			numorder:{
				validators:{
					notEmpty:{
						message:'有效期排序不能为空'
					},
					integer:{
						message:'请输入有效的数字'
					},
					between : {
						min : 0,
						max : 100000000,
						message : '超出了合理的数值范围'
					}
				}
			},
			showStartTime:{
				validators:{
				notEmpty:{
					message:'展示期结束时间不能为空'
				}
			}},
			showEndTime:{
				validators:{
					notEmpty:{
						message:'展示期结束时间不能为空'
					}
				}
			},
			showNumorder:{
				validators:{
					notEmpty:{
						message:'展示期排序不能为空'
					},
					integer:{
						message:'请输入有效的数字'
					},
					between : {
						min : 0,
						max : 100000000,
						message : '超出了合理的数值范围'
					}
				}
			},
			total:{
				validators:{
					notEmpty:{
						message:'发布总份额不能为空'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the FormValidation instance
        var bv = $form.data('formValidation');

        // Use Ajax to submit form data
        $.ajax({
            type: "POST",
            url:$form.attr('action'),
            data:$form.serialize(),
            error: function(request) {
                console.info(request);
                alert("Connection error");
            },
            success: function(data) {
            	 $('#btn_add').removeAttr('disabled');
            	   bootbox.alert({
           	        buttons: {
           	            list: {
           	                label: '返回列表',
           	                className: 'btn-myStyle'
           	            },
           			   ok: {
           				    label: '继续添加',
           				    className: 'btn-myStyle'
           			   }
           			  

           		    },
           		    message: JSON.parse(data).msg,
           		    callback: function (e) {
           		        if (e == "list") {
           		            window.location="../published"
           		        }
           			    
           		    },
           		    title: "提示",
           	    });
            }
        });
        
    });
});