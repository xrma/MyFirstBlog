<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <script type="text/javascript">
    	var articleSortListStr = eval("${articleSortListStr}");
    	
    	function getArticleSort(){
    		$.each(articleSortListStr, function(index, articleSort){
			    $("#articleSortId")[0].add(new Option(articleSort[1],articleSort[0]));
			});
    	}
    	
    	function addSort(){
    		$("#addSortTr").show();
    	}
    	
    	function cancelAddSort(){
    		$("#addSortTr").hide();
    		$("#newSort").val("");
    	}
    	
    	$(document).ready(function(){
		  $("#addSort").click(function(){
			  $.ajax({
				url : "addArticleSort.do",
				data : {
					newArticleSortName : $("#newSort").val()
				},
				async : false,
				type : 'post',
				cache : false,
				dataType : 'json',
				success : function(data) {
					var flag = data.flag;
					if(flag){
						articleSortListStr = eval(data.articleSortListStr);
						$("#articleSortId").find("option").remove();
						getArticleSort();
						$("#addSortTr").hide();
						$("#newSort").val("");
						alert("添加成功！");
					}else{
						$("#addError").html("<h5>" + data.errorMsg + "</h5>");
					}
				},
				error : function(data) {
					$("#addError").html("<h5>添加失败</h5>");
				}
			  });
			});
		 });
    </script>

  </head>
  
  <body onload="getArticleSort();">
<%--    <textarea id="editor1" class="ckeditor">Sample Text</textarea> --%>

		<jsp:include page="common/manageHead.jsp"></jsp:include>
		
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
	  							<input type="hidden" name="time" value="${currentTime}"/>
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
	  						<h5>
	  							文章分类：
	  							<select id="articleSortId" name="articleSortId"></select>
	  							<div class="btn-group" >
								  <a href="javascript: addSort();">增加分类</a>
								</div>
	  						</h5>
	  					</td>
	  				</tr>
	  				<tr id="addSortTr" style="display: none;">
	  					<td>
	  						<h5>
	  							分类名称：<input type="text" id="newSort"/>
	  							<button type="button" name="addSort" id="addSort" class="btn btn-primary btn-xs">确定</button>
	  							<a href="javascript: cancelAddSort();">取消</a>
	  						</h5>
	  						<div class="bs-callout bs-callout-danger" id="addError">
	  						</div>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<h5>
	  							文章标签：<input name="tags"/>标签用“空格”隔开。
	  						</h5>
	  					</td>
	  				</tr>
	  				<tr>
	  					<td>
	  						<h4><button type="submit" class="btn btn-primary btn-sm">发表文章</button></h4>
	  					</td>
	  				</tr>
	  			</table>
  			</form>
		</div>
  </body>
</html>
