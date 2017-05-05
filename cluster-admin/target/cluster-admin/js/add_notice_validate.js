/**
 * 
 */
$(function(){
	$("#fileupload").fileupload({

	    url:"../upload/uploadfile",//文件上传地址，当然也可以直接写在input的data-url属性内

	    formData:{param1:"p1",param2:"p2"},//如果需要额外添加参数可以在这里添加

	    done:function(e,result){

	        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api

	        //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息

	        //返回的数据在result.result中，假设我们服务器返回了一个json对象

	        console.log(JSON.stringify(result.result));
	        $('#img').val(result.result);

	    }

	});
	$("#account_form").bootstrapValidator({
		framework: 'bootstrap',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			title:{
				validators : {
					notEmpty : {
						message : '标题不能为空'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('formValidation');
        $.ajax({
            type: "POST",
            url:$form.attr('action'),
            data:$form.serialize(),
            error: function(request) {
                console.info(request);
                alert("Connection error");
            },
            success: function(data) {
            	
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
           		            window.location="list"
           		        }
           		    },
           		    title: "提示",
           	    });
            }
        });
	});
});