<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	        </div>
	    </div>
	</nav>
	
	<div class="jumbotron">
  		<div class="container">
		  <h1>Hello, Sunray!</h1>
		  <p>This is my first blog</p>
	  	</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-4">
				<div class="panel panel-primary">
				<div class="panel-heading">文章分类</div>
				
				<!-- List group -->
				    <div class="list-group">
						  <%--<a href="#" class="list-group-item"><span class="badge">14</span>
						    Cras justo odio
						  </a>--%>
						  <c:if test="${!empty articleSortMap}">
							  <c:forEach items="${articleSortMap}" var="articleSortMap">
							  	<a href="#" class="list-group-item"><span class="badge">${articleSortMap.value.articleCount}</span>${articleSortMap.value.articleSortName}</a>
							  </c:forEach>
						  </c:if>
					</div>
					
				</div>
				
				<p>博客访问量：${visitCount}</p>
			</div>
			<div class="col-xs-12 col-md-8">
				<c:if test="${!empty articleList}">
					<c:forEach items="${articleList}" var="articleList">
						<h3>${articleList.title}<!-- <span class="label label-default">New</span> --></h3>
						<p>${articleList.content}</p>
					</c:forEach>
				</c:if>
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
