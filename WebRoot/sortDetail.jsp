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
	<c:if test="${!empty user}">
		<nav class="navbar" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<span class="navbar-brand">Hi,大蕊！</span>
				</div>
			
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			        <ul class="nav navbar-nav">
						<li class="active"><a href="GoBackToLogin.do">主页</a></li>
			        </ul>
			        <c:if test="${!empty user}">
				        <ul class="nav navbar-nav navbar-right">
		       				<li><a href="publishedArticlesForword.do">发表文章</a></li>
		       			</ul>
	       			</c:if>
		        </div>
		    </div>
		</nav>
	</c:if>
	
	<c:if test="${empty user}">
		<nav class="navbar" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<span class="navbar-brand">Hi,大蕊！</span>
				</div>
			
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			        <ul class="nav navbar-nav">
						<li class="active"><a href="index.in">主页</a></li>
			        </ul>
		        </div>
		    </div>
		</nav>
	</c:if>
	
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
							  	<a href="SortDetail.login?articleSortId=${articleSortMap.value.articleSortId}" class="list-group-item"><span class="badge">${articleSortMap.value.articleCount}</span>${articleSortMap.value.articleSortName}</a>
							  </c:forEach>
						  </c:if>
					</div>
					
				</div>
			</div>
			<div class="col-xs-12 col-md-8">
				<c:if test="${!empty articleList}">
					<table class="table">
						<thead>
							<tr>
								<th colspan="2">${thisSortName}</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${articleList}" var="articleList">
								<tr>
									<td>
										<h4><a href="ArticleDetail.login?articleId=${articleList.articleId}">${articleList.title}</a></h4>
									</td>
									<td align="right">
										<h6>${articleList.time}</h6>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
