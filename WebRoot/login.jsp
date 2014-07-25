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
  	<div class="container">
	  	<div class="row">
	  		<div class="col-xs-6"></div>
			<div class="col-xs-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
				    	<h3 class="panel-title">用户登录</h3>
					</div>
					<div class="panel-body">
						<form action="LoginAction.do" method="post">
						    <div class="form-group">
						    	<h4>username:</h4>
								<input type="text" name="userName" class="form-control" placeholder="username"><br/>
								<h4>password:</h4>
								<input type="password" name="password" class="form-control" placeholder="password">
								<button type="submit" class="btn btn-primary navbar-btn">Sign in</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
  
</html>