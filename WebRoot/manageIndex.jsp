<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.sunray.util.SystemConstant"%>
<%@page import="java.util.List"%>
<%@page import="com.sunray.entity.Article"%>
<%
	List<Article> articleList = (List<Article>) request.getAttribute("articleList");
%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>my first web</title>

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
		        <ul class="nav navbar-nav navbar-right">
       				<li><a href="publishedArticlesForword.do">发表文章</a></li>
       			</ul>
	        </div>
	        
	    </div>
	</nav>
	
	<div class="jumbotron">
  		<div class="container">
		  <h1>Hello, sunray!</h1>
		  <p>this is my first blog</p>
	  	</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-4">
				<div class="panel panel-primary">
				<div class="panel-heading">title</div>
				
				<!-- List group -->
				    <div class="list-group">
						  <a href="#" class="list-group-item"><span class="badge">14</span>
						    Cras justo odio
						  </a>
						  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
						  <a href="#" class="list-group-item">Morbi leo risus</a>
						  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
						  <a href="#" class="list-group-item">Vestibulum at eros</a>
					</div>
					
				</div>
				
				<p>博客访问量：<%= request.getAttribute(SystemConstant.WEB_VISIT_COUNT) %></p>
			</div>
			<div class="col-xs-12 col-md-8">
				<% for(Article article : articleList){ %>
				
					<h3><%= article.getTitle() %><!-- <span class="label label-default">New</span> --></h3>
					<p><%= article.getContent() %></p>
					<h4><small><a href="#">modify</a> | <a href="#">delete</a></small></h4>
				
				<% } %>
				
				<ul class="pagination">
				  <li class="disabled"><a href="#">&laquo;</a></li>
				  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				  <li><a href="#">2</a></li>
				  <li><a href="#">3</a></li>
				  <li><a href="#">4</a></li>
				  <li><a href="#">5</a></li>
				  <li><a href="#">&raquo;</a></li>
				</ul>
			
			</div>
		</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
