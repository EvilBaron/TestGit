<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'json.jsp' starting page</title>
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  	<style type="text/css">
  		
  	</style>
  </head>
  
  <body>
  	用户名：<input id="name" />
    <span id="spName"></span>
    <script type="text/javascript">
    	$("#name").keyup(function(){
    		$.ajax({
    			url:"stu/json",
    			type:"post",
    			data:{"name":this.value},
    			success:function(data){
    				if(data=="true"){
    					$("#spName").text("该用户名可用！")
    						.css("color","#0f0");
    				}else{
    					$("#spName").text("该用户名已被占用！")
    						.css("color","#f00");
    				}
    			}
    		})
    	})
    </script>
  </body>
</html>


















