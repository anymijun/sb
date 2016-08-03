<%@page import="demo.entity.demo.DemoEntity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jsp2</title>
<script type="text/javascript">

</script>
</head>
<body>
	<table border="1">
		<tr>
			<td>用户：</td>
			<%
				DemoEntity demo = (DemoEntity)request.getAttribute("demo");
			%>
			<td><%=demo.getUserName() %></td>
			<td>密码：</td>
			<td><%=demo.getPassword() %></td>
		</tr>
		<tr>
			<td>提示：</td>
			<td colspan="3"><%=request.getAttribute("str") %></td>
		</tr>
		<tr>
			<%
				DemoEntity demo1 = (DemoEntity)request.getAttribute("demo1");
			%>
			<td>用户1：</td>
			<td><%=demo1.getUserName() %></td>
			<td>密码1：</td>
			<td><%=demo1.getPassword() %></td>
		</tr>
		<tr>
			<td>session：</td>
			<td colspan="3"><%=session.getAttribute("sessionTest") %></td>
		</tr>
	</table>
</body>
</html>