<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jsonlist.jsp' starting page</title>
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    <input type="button" id="btn" value="查询" />
    <div id="info"></div>
    <script type="text/javascript">
    	$("#btn").click(function(){
    		$.ajax({
    			url:"stu/jsonlist",
    			dataType:"json",	//返回的数据格式类型
    			success:function(data){
    				var s = "";
    				$.each(data,function(i,d){
    					s += "<h1>"+d.grade.name + "--" + d.name+"--"+d.birthday+"</h1>";
    				})
    				$("#info").html(s);
    			}
    		})
    	})
    </script>
  </body>
</html>















