<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<% if (session.getAttribute("admin")==null) response.sendRedirect(basePath+"login.jsp");%>
    
    <base href="<%=basePath %>">
    <meta charset="utf-8">
    <title>添加:图书管理系统</title>
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
    <link href='css/fileinput.min.css' rel='stylesheet'>
    
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
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${admin.username}</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                	<li><a href="user/findById?id=${admin.id}">修改密码</a></li>
                    <li><a href="user/logout">注销登录</a></li>
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
                    	    <li><a class="ajax-link" href="main.jsp"><i class="glyphicon glyphicon-home"></i><span> &ensp;首&ensp;页</span></a></li>
							<li><a class="ajax-link" href="books/bookList"><i class="glyphicon glyphicon-envelope"></i><span> &ensp;图&ensp;书&ensp;管&ensp;理</span></a></li>
							<li><a class="ajax-link" href="bookTypes/bookTypeList"><i class="glyphicon glyphicon-envelope"></i><span> &ensp;图&ensp;书&ensp;类&ensp;型</span></a></li>
							<li><a class="ajax-link" href="reader/readerList"><i class="glyphicon glyphicon-user"></i><span> &ensp;读&ensp;者&ensp;管&ensp;理</span></a></li>
							<li class="active"><a class="ajax-link" href="userType/userTypeList"><i class="glyphicon glyphicon-user"></i><span> &ensp;用&ensp;户&ensp;管&ensp;理</span></a></li>
							<li><a class="ajax-link" href="loanInfo/loanInfoList"><i class="glyphicon glyphicon-list-alt"></i><span> &ensp;借&ensp;阅&ensp;信&ensp;息</span></a></li>
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
            <a href="main.jsp">首页</a>
        </li>
        <li>
            <a href="userType/userTypeList">用户类型</a>
        </li>
        <li>
            <a href="#">添加</a>
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
                <form action="userType/userTypeAdd" method="post" data-toggle="validator">					
					<div class="form-group">
						<div class="input-group col-md-3">
							<label class="control-label" for="tel">用户类型*</label>
							<input type="text" class="form-control" name="userTypeName" required/>
							<span class="help-block with-errors"></span>
						</div>
					</div>
					
					<div class="form-group">
						<div class="input-group col-md-3">
							<label class="control-label" for="tel">权限管理*</label>
							<input type="text" class="form-control" name="power" required/>
							<span class="help-block with-errors"></span>
						</div>
					</div>
					
                    
                    <input type="submit" class="btn btn-info" value="保存" >
                    <input type="reset" class="btn btn-info" value="重置" >
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
<script src="js/fileinput.min.js"></script>
<script src="js/zh.js"></script>
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
   
	//初始化上传控件的样式
    $('#imgEmdImg').fileinput({
  	  language: 'zh',
  	    uploadUrl: "<%=basePath %>Photo/load",
  	  	uploadAsync : true, //默认异步上传
  	    showCaption: true,//是否显示被选文件的简介
  	    showUpload: true,//是否显示上传按钮
  	    showRemove: true,//是否显示删除按钮
  	    showClose: true,//是否显示关闭按钮
  	    //allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
     	//allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
      	allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
  	    enctype: 'multipart/form-data',
  	    layoutTemplates: {
  	      actionUpload: ''//就是让文件上传中的文件去除上传按钮
//  	      actionDelete: '',//去除删除按钮
  	    },
  	    browseClass: 'btn btn-primary',
  	    maxFileCount: 1,
  	  })
  	  //异步上传返回结果处理
      $('#imgEmdImg').on('fileerror', function(event, data, msg) {
          console.log("fileerror");
          console.log(data);
          alert("上传失败");
      });
      //异步上传返回结果处理
      $("#imgEmdImg").on("fileuploaded", function(event, data, previewId, index) {
    	  console.log("fileuploaded");
          console.log(data);
          var ref = $(this).attr("data-ref");
          $("input[name='" + ref + "']").val(data.response.saveFileName);
          alert("上传成功");

      });

      //同步上传错误处理
      $('#imgEmdImg').on('filebatchuploaderror', function(event, data, msg) {
          console.log("filebatchuploaderror");
          console.log(data);
      });

      //同步上传返回结果处理
      $("#imgEmdImg").on("filebatchuploadsuccess",
              function(event, data, previewId, index) {
                  console.log("filebatchuploadsuccess");
                  console.log(data);
                  alert("上传成功");
              });
	
</script>

</body>
</html>

</html>