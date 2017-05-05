<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/common/meta.jsp"%>
<style type="text/css">
        .logo_top_left {
            background-color: #428bca;
            width: 46px;
            height: 46px;
            margin: 0 5px;
            border-radius: 3px;
            float: left;
            box-sizing: border-box;
            display: block;
            line-height: 46px;
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
        .font-large {
            font-size:20px;
        }
    </style>
</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	 
    <div class="container-fluid">
        <div class="row border-bottom padding-top-15 ">
            <div class="col-xs-4 text-left">
                <ol class="breadcrumb">
                    <li><a href="#">查询</a></li>
                    
                    <li><a href=" ${pageContext.request.contextPath}/search/quick_task" class="active">快速任务</a></li>
                    <li><a href="${pageContext.request.contextPath}/search/quick_task_list" class="active">快速详情</a></li>
                     <li><a href="#" class="active">任务详情</a></li>
                </ol>
            </div>
            <div class="col-xs-8 text-right">

                <div class="form-group form-inline">
                    <input id="keywords" class="form-control input-lg" type="text" placeholder="用户ID/用户名/IDFA" />
                    <button id="btn_search" type="button" class="btn btn-primary btn-lg">搜索</button>
                </div>


            </div>
        </div>
        <div class="row border-bottom padding-15-tb">
            <div class="col-xs-6 line-height-34 "><strong class="font-large">任务名称：${taskName} &nbsp;&nbsp;&nbsp;&nbsp; 完成度${comp}%</strong></div>
            <div class="col-xs-6 text-right ">
                <div class="form-inline " role="form">
                    <a  class="btn btn-primary"  href="${pageContext.request.contextPath}/search/export_task_list?taskid=${taskid}&day=${day}&taskname=${taskName}">导出Excel</a>
                </div>
            </div>
        </div>
        <div class="row padding-15-tb">
            <div class="col-xs-12">
                <table id="datalist" class="table table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>完成时间</th>
                            <th>ID</th>
                            <th>用户类型</th>
                            <th>IDFA</th>
                            <th>姓名</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            var table = $('#datalist').dataTable({
                "bAutoWidth": false,
                "bPaginate": true,  //是否分页。
                "bServerSide": true,
                "bProcessing": true,
                "searching": false,
                "bLengthChange": true,
                "scrollCollapse": true,
                //"scrollY": "400px",
                "pagingType": "full_numbers",
                // "dom": '<"toolbar">frtip',
                // "sAjaxSource": "Handler.ashx?actionname=getdatalist2",
                "ajax": {
                    "url": "${pageContext.request.contextPath}/search/quick_task_list_detail",
                    "data": function (d) {
                        d.search = $("#keywords").val();
                        d.taskid=${taskid};
                        d.day='${day}';
                    },
                    "dataType": "json",
                    "method": "POST"
                },
                "columns": [
                    { "data": "createTime" },
                    { "data": "userid" },
                    {  
                       "render": function (data, type, row) {
                       var rs="";
                       if(row.fromTo=='online'){
                           rs+='线上';
                       }else if(row.fromTo=='offline'){
                           rs+='线下'
                       }
                       
                       if(row.type='D'|| row.type=='d'){
                          rs+='普通';
                       }else {
                       rs+=row.type+'类'
                       }
                       
                             return rs;
                         }
                    },
                    { "data": "idfa" },
                    { "data": "name" },
                    { "data": "mobile" },
                    { "render": function (data, type, row) {
                             return row.provinceName+' '+row.cityName+' '+row.area+ ' '+row.address;
                         }},
                     {
                         "render": function (data, type, row) {
                             return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/account/UserDetail?id='+ row.id +'">更多</a>';
                         }
                     }
                ],
                "oLanguage": {
                    "sUrl": "${pageContext.request.contextPath}/thirdpart_framework/jquery-datatable/language/zh_CN.json"
                }
            });

            

        });
    </script>

	</main>
</body>