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
            width: auto;
            height: 46px;
            margin: 0 5px;
            border-radius: 3px;
            float: left;
            box-sizing: border-box;
            display: block;
            padding-left:5px;
            padding-right:5px;
           
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
       
    </style>
</head>

<body>
	<c:set var="currentNav" value="search"></c:set>
	<%@ include file="/common/nav.jsp"%>
	<main>
	     <div class="container-fluid">
        <div class="row border-bottom padding-top-15 ">
            <div class="col-xs-3 text-left">
                <ol class="breadcrumb">
  <li><a href="#">查询</a></li>
<li><a href="${pageContext.request.contextPath}/search/member_list">成员查询</a></li>
 <li><a href="#" class="active">单日任务</a></li>
</ol>
            </div>
            <div class="col-xs-9 text-right">

                <div class="form-group form-inline">
                    <input id="keywords" class="form-control input-lg" type="text" placeholder="用户ID/用户名/IDFA" />
                    <button id="btn_search" type="button" class="btn btn-primary btn-lg">搜索</button>
                </div>


            </div>
        </div>
        <div class="row border-bottom padding-15-tb">
            <div class="col-xs-12">2014/11/25  日活跃： 2100 人</div>
           
        </div>
        <div class="row padding-15-tb">
            <div class="col-xs-12">
                <table id="datalist" class="table table-striped table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>用户类型</th>
                            <th>快速任务完成次数</th>
                            <th>收益（金币）</th>
                            <th>常规任务完成次数</th>
                            <th>收益（金币）</th>
                            <th>总收益(金币)</th>
                            <th>登陆活跃(人)</th>
                            <th>下载活跃(人)</th>
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
                    "url": "${pageContext.request.contextPath}/search/data_member_day_task",
                    "data": function (d) {
                        d.start_date = $("#start").val();
                        d.end_data = $("#end").val();
                        d.search = $("#keywords").val();
                    },
                    "dataType": "json",
                    "method": "POST"
                },
                "columns": [
                    { "data": "rq" },
                    { "data": "ksrwwccs" },
                    { "data": "cyrs" },
                    { "data": "xsyh" },
                    { "data": "xssy" },
                    { "data": "xxyh" },
                    { "data": "xxsy" },
                    { "data": "drzsy" },
                    {
                        "render": function (data, type, row) {
                            return '<a type="button" class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/search/member_earnings">查看</a>';
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
</html>
