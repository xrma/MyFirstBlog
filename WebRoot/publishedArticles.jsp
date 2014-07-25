<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>my first web</title>
	<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script> 
	<!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  
  <body>
<%--    <textarea id="editor1" class="ckeditor">Sample Text</textarea> --%>

		<nav class="navbar" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Brand</a>
				</div>
			
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			        <ul class="nav navbar-nav">
						<li class="active"><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
			        </ul>
		        </div>
		        
		    </div>
		</nav>
		
		<div class="container">
			<form action="publishedArticles.do" method="post">
	  			<table>
	  				<tr>
	  					<td>
	  						<h5>
	  							文章标题：<input name="title"/>
	  						</h5>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<h5>
	  							发布时间：${currentTime}
	  						</h5>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<h5>文章正文：</h5>
	  						<textarea id="content" class="ckeditor" name="content" style="width: 800px;"></textarea>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<h4><button type="submit" class="btn btn-primary btn-sm">发表文章</button></h4>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<h5>
	  							分类：
	  							<select></select>
	  							<div class="btn-group">
								  <a href="#">增加分类</a>
								</div>
	  						</h5>
	  					</td>
	  				</tr>
	  			</table>
  			</form>
		</div>
  </body>
</html>
