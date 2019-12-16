<%@page import="com.bean.Student"%>
<%@page import="com.bean.Page"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	*{margin: 0px; padding: 0px;}
	body{width:800px; margin: 0px auto;}
	form{text-align: center;height: 50px; line-height: 50px;}
	table{width:800px; margin: 0px auto; border-collapse: collapse; text-align: center;}
	tr{height:50px; cursor: pointer;}
	thead tr{background-color: #ccc;}
	tbody tr:nth-of-type(odd){background-color: #FF88C2;}
	tbody tr:nth-of-type(even){background-color: #cdf;}
	p{text-align: center;}
	</style>
  	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    <c:if test="${pageStudent==null}">
    	<c:redirect url="/stu/list/1"/>
    </c:if>
    
    <%
    Page<Student> p = (Page<Student>)request.getAttribute("pageStudent");
    String name = String.valueOf(request.getAttribute("name"));
    
    String prev = "", next = "";	//上一页   下一页
    int pageIndex = p.getPageIndex();	//第几页
    int totalPage = p.getTotalPage();	//共几页
    if(pageIndex > 1){
    	prev = "href='stu/list/"+(pageIndex-1)+"?name="+name+"'";
    }
    if(pageIndex < totalPage){
    	next = "href='stu/list/"+(pageIndex+1)+"?name="+name+"'";
    }
    %>
    <form action="stu/list/1" method="post">
    	姓名：<input name="name" value="${name}"/>
    	<input type="submit" value="查询" />
    </form>
    
    <table>
    	<thead>
    	<tr>
    		<td>编号</td>
    		<td>姓名</td>
    		<td>性别</td>
    		<td>生日</td>
    		<td>年级</td>
    		<td>成绩</td>
    		<td>操作</td>
    	</tr>
    	</thead>
    	<tbody>
    	<c:forEach items="${pageStudent.list}" var="s">
    	<tr onmouseover="c=this.style.backgroundColor;this.style.backgroundColor='#f00';"
    		onmouseout="this.style.backgroundColor=c;"
    	>
    		<td><a href="stu/up/${s.id}">${s.id}</a></td>
    		<td>${s.name}</td>
    		<td>${s.sex?"男":"女"}</td>
    		<td><fmt:formatDate value="${s.birthday}" pattern="yyyy-MM-dd"/></td>
    		<td>${s.grade.name}</td>
    		<td>${s.score}</td>
    		<td><a onclick="return confirm('是否删除?');" href="stu/del/${s.id}">删除</a></td>
    	</tr>
    	</c:forEach>
    	</tbody>
    </table>
    <input type="radio" name="type" value="aaaa" checked />男
    <input type="radio" name="type" value="bbbb"  />女
    <input type="checkbox" name="duo" value="cccc"  />选1
         <input type="checkbox" name="duo" value="dddd"  />选2
             <input type="checkbox" name="duo" value="eeee" checked />选3
             
             <button>sdfasdfsa </button>
    <p style="text-align: left;"><a href="add.jsp">新增</a></p>
    
    <p>
    	第<%=pageIndex%>页/共<%=totalPage%>页  
   	 <a <%=prev%> >上一页</a>
    <a  <%=next%> >下一页</a>
    </p>
    
    
    
    <c:if test="${info!=null}">
    	<p id="a">${info}</p>
    	<script>
    	function f1(){
    		$("#a").hide();
    	}
    	setTimeout(f1, 3000);
    	</script>
    </c:if>
    
    <script type="text/javascript">
    	
    	
    	$("button").click(function(){
    		alert($("input[name=type]:checked").val());
    		alert($("input[name=duo]:checked").val());
    	})
    </script>
  </body>
</html>

















