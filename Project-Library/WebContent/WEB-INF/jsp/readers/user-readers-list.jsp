<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<% if (session.getAttribute("userReader")==null) response.sendRedirect(basePath+"login.jsp");%>
   
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>读者管理:图书管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>


    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>

<div class="navbar navbar-default" role="navigation">

    <div class="navbar-inner">
        <button type="button" class="navbar-toggle pull-left animated flip">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="login.jsp"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
            <span>Library</span></a>


        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${userReader.readerName}</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
            	<li><a href="reader/findById3?id=${userReader.id}">修改密码</a></li>
                <li><a href="reader/logout">注销登录</a></li>
            </ul>
        </div>

    </div>
</div>

<div class="ch-container">
    <div class="row">


        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">功能</li>
							<li><a class="ajax-link" href="userlogin.jsp"><i class="glyphicon glyphicon-home"></i><span> &ensp;首&ensp;页</span></a></li>
							<li class="active"><a class="ajax-link" href="reader/getReadersById?id=${userReader.id}"><i class="glyphicon glyphicon-envelope"></i><span> &ensp;基&ensp;本&ensp;信&ensp;息</span></a></li>
							<li><a class="ajax-link" href="javascript:location.href='<%=basePath %>loanInfo/userloanInfoList?readername='+encodeURIComponent('${userReader.readerName }');"><i class="glyphicon glyphicon-list-alt"></i><span> &ensp;借&ensp;阅&ensp;信&ensp;息</span></a></li>                          
                    </ul>
                </div>
            </div>
        </div>


        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
 
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="userlogin.jsp">首页</a>
                    </li>
                    <li>
                        <a href="reader/getReadersById?id=${userReader.id}">基本信息</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-cog"></i> 读者信息</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">

                            <table class="table table-striped table-bordered bootstrap-datatable datatable responsive" id="tables">
                                <thead>
                                <button type="button" id="export" style="float:right" class="btn btn-primary" ><i class="glyphicon glyphicon-download-alt icon-white"></i>
                                	&ensp;数&ensp;据&ensp;导&ensp;出</button>
                                <br/>
                                <br/>
                                <tr>
                                    <th>序号</th>
                                    <th>读者编号</th>
                                    <th>读者类型</th>
                                    <th>姓名</th>
                                    <th>密码</th>
                                    <th>性别</th>
                                    <th>联系电话</th>
                                    <th>邮箱</th>
                                    <th>联系QQ</th>
                                    <th>读者地址</th>
                                    <th>基本操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>${reader.readerNo}</td>
                                        <td><c:forEach var="type" items="${userTypeLists}">
												<c:if test="${type.id==reader.readerType}">
												${type.userTypeName}
												</c:if>
										</c:forEach></td>
                                        <td>${reader.readerName}</td>
                                        <td>******</td>
                                        <td>${reader.sex}</td>
                                        <td>${reader.telephone}</td>
                                        <td>${reader.email}</td>
                                        <td>${reader.qq}</td>
                                        <td>${reader.address}</td>
                                        <td class="center">
                                            <a class="btn btn-info" href="reader/findById2?id=${reader.id}">
                                                <i class="glyphicon glyphicon-edit icon-white"></i>
                                                编&ensp;辑
                                            </a>
                                        </td>
                                    </tr>

                              
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                

            </div>


            
        </div>
    </div>


    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>确认？</h3>
                </div>
                <div class="modal-body">
                    <p>此条记录将被永久删除</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">取消</a>
                    <a class="btn btn-danger btn-ok">确认删除</a>
                </div>
            </div>
        </div>
    </div>

   

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src="js/jquery.dataTables.min.js"></script>
<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>
<script src="js/base64.js"></script>
<script src="js/tableExport.js"></script>
<script src="js/FileSaver.min.js"></script>
<script>
    $('#myModal').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
    });
    $("#export").click(function(){
        $("#tables").tableExport({
        	type:"excel",
        	fileName: new Date().getTime(),
        	escape:"false",
        	ignoreColumn:'[9]'
        	});
    });
</script>

</body>
</html>
