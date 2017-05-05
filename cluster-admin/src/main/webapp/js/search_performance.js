/**
 * 查询_业绩查询
 */
var SearchPerformance = function() {
	"use strict";// 使用严格模式，必须放在执行体第一行才有效

	var initTable = function() {
		$('#dataTable').dataTable({
			"bAutoWidth" : false,
			"bPaginate" : true, // 是否分页。
			"bServerSide" : true,
			"bProcessing" : true,
			"searching" : false,
			"bLengthChange" : true,
			"scrollCollapse" : true,
			// "scrollY": "400px",
			"pagingType" : "full_numbers",
			"dom" : '<"toolbar">frtilp',
			"aLengthMenu" : [100, 500, 1000],
			// "sAjaxSource":
			// "Handler.ashx?actionname=getdatalist2",
			"ajax" : {
				"url" : "load_performance",
				"data" : function(d) {
					d.start_date = $("#startDate").val();
					d.end_data = $("#endDate").val();
					d.user_id = $("#user_id").val();
				},
				"dataType" : "json",
				"method" : "POST"
			},
			"columns" : [ {
				"title" : "一级推广员",
				"data" : "user_level_1",
			}, {
				"title" : "二级推广员",
				"data" : "user_level_2"
			}, {
				"title" : "三级推广员",
				"data" : "user_level_3"
			}, {
				"title" : "下载金额",
				"data" : "download_money"
			}, {
				"title" : "坏账",
				"data" : "bad_debt"
			}, {
				"title" : "提现金额",
				"data" : "withdraw_deposit"
			} ],
			"oLanguage" : {
				"sUrl" : "../thirdpart_framework/jquery-datatable/language/zh_CN.json"
			}
		});

		/* 根据用户级别，隐藏相应列 */
		var api = $('#dataTable').DataTable();
		if ($("#user_level").val() != -1 && $("#user_level").val() != 0) {
			api.column(5).visible(false);
		}
	};

	$('#btn_search2').on('click', function() {
		$('#datalist').dataTable().fnDraw();
	});

	/*
	 * 初始化时间范围选项
	 */
	var initDatePickers = function() {
		//$('#startDate').val(moment().subtract('days', 1).format('YYYY-MM-DD'));
		//$('#endDate').val(moment().subtract('days', 1).format('YYYY-MM-DD'));
		$('#startDate').val(moment().format('YYYY-MM-DD'));
		$('#endDate').val(moment().format('YYYY-MM-DD'));

		$('#date-picker').datepicker({
			format : "yyyy-mm-dd",
			language : "zh-CN",
			endDate : moment().format('YYYY-MM-DD'),
			orientation : "top left",
			autoclose : true
		});
	};

	/*
	 * 初始化表单
	 */
	var initForm = function() {
		initDatePickers();

		// 查询
		$('#btn_per_search').on('click', function(e) {
			$('#dataTable').DataTable().draw();
		});

		// 提现汇总导出
		$('#btn_collect_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance');
			$('#export_from').submit();
		});

		// 提现明细导出
		$('#btn_billItem_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance_billItem');
			$('#export_from').submit();
		});

		// 任务明细导出
		$('#btn_item_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance_item');
			$('#export_from').submit();
		});

		// 提现明细导出
		$('#btn_moneyItem_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance_moneyItem');
			$('#export_from').submit();
		});
		
		// 广告主明细导出
		$('#btn_channelItem_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance_channelItem');
			$('#export_from').submit();
		});

		// 渠道明细导出
		$('#btn_channel_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance_channel');
			$('#export_from').submit();
		});
		
		// 渠道点击导出
		$('#btn_channel_click_export').on('click', function(e) {
			$('#export_from').attr('action', 'export_performance_channel_click');
			$('#export_from').submit();
		});
	};

	return {
		// 初始化页面，注意加载顺序
		init : function() {
			initForm();
			initTable();
		}
	};

}();