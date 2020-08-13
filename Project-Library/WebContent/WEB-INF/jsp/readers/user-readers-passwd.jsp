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
    <meta charset="utf-8">
    <title>编辑:图书管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

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
							<li><a class="ajax-link" href="reader/getReadersById?id=${userReader.id}"><i class="glyphicon glyphicon-envelope"></i><span> &ensp;基&ensp;本&ensp;信&ensp;息</span></a></li>
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
        <li>
            <a href="#">编辑</a>
        </li>
    </ul>
</div>

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 编辑</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
			<div class="box-content">
                <form action="reader/userUpdatepaw" method="post" data-toggle="validator">
					
					<div class="form-group">
						<div class="input-group col-md-3">
							<label class="control-label">密码*</label>
							<input type="password" class="form-control" name="readerPaw" id="Password1" pattern="^[a-z0-9_]{6,18}$" data-error="密码格式错误" required>
							<span class="help-block with-errors">密码由字母 数字或下划线组成，6位以上</span>
						</div> 
						<div class="input-group col-md-3">
							<label class="control-label">确认密码*</label>
							<input type="password" class="form-control" id="Password2" data-match="#Password1" data-error="密码不一致" required>
							<span class="help-block with-errors"></span>
						</div> 
					</div>			
					<input type="hidden" name="readerNo" value="${reader.readerNo}">
					<input type="hidden" name="readerName" value="${reader.readerName}">
					<input type="hidden" name="sex" value="${reader.sex}">
					<input type="hidden" name="telephone" value="${reader.telephone}">
					<input type="hidden" name="email" value="${reader.email}">
					<input type="hidden" name="qq" value="${reader.qq}">
					<input type="hidden" name="address" value="${reader.address}">
					<input type="hidden" name="readerType"  value="${reader.readerType}">
					<input type="hidden" name="id"  value="${reader.id}">
                    <input type="submit" class="btn btn-info" value="保存" >
                    <input type="button" class="btn btn-info"  value="返回" onclick="javascript:history.go(-1);"/>
                </form>

            </div>
		</div>
	</div>
</div>



    </div>
</div>
    

</div>

<!-- external javascript -->
<script src="js/validator.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

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
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	
	if("${reader.sex}"=="男"){
		document.getElementById("male").checked="checked";
	}
	if("${reader.sex}"=="女"){
		document.getElementById("female").checked="checked";
	}
</script>

</body>
</html>

</html>