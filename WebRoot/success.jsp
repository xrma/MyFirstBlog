<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%--<table>
    	<tr>
    		<td>文章标题：${title}</td>
    	</tr>
    	<tr>
    		<td>发表时间：${time}</td>
    	</tr>
    	<tr>
    		<td>作者：${author}</td>
    	</tr>
    	<tr>
    		<td>内容：${content}</td>
    	</tr>
    	<tr>
    		<td>分类：${articleSortName}</td>
    	</tr>
    	<tr>
    		<td>标签：
    			<c:if test="${!empty articleTagsNameList}">
	    			<c:forEach items="${articleTagsNameList}" var="articleTagsName">
	    				${articleTagsName}
	    			</c:forEach>
    			</c:if>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<button type="button" class="btn btn-primary btn-sm" onclick="javascript:window.location.href = 'GoBackToLogin.do'">返回</button>
    		</td>
    	</tr>
    </table>
  --%>
  	success!
  	<button type="button" class="btn btn-primary btn-sm" onclick="javascript:window.location.href = 'GoBackToLogin.do'">返回</button>
  </body>
</html>
