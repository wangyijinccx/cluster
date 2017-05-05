$(function(){
	$('#form_task').bootstrapValidator({
		 framework: 'bootstrap',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
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
           		            window.location="../adsource/list"
           		        }
           			    
           		    },
           		    title: "提示",
           	    });
            }
        });
        
    });
});