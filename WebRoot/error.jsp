<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/docs.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="padding-top: 100px;">
  	<div class="container-fluid">
	  	<div class="row">
		  <div class="col-md-4"></div>
		  <div class="col-md-4">
		  	<div class="bs-callout bs-callout-danger">
		  		<h4>登录出错！</h4>
		  		<p>sorry,你并不是本站用户哦~</p>
		  		<p>想加入？快联系sunray吧<a href="mailto:15010117758@163.com">15010117758@163.com</a></p>
		  		<div class="btn-group btn-group-xs">
		  			<button type="button" class="btn btn-danger" onclick="window.location.href='login.jsp'">return</button>
		  		</div>
		  	</div>
		  </div>
		  <div class="col-md-4"></div>
		</div>
	</div>
  </body>
  
</html>