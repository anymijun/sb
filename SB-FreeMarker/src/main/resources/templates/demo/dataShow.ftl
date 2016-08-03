<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ftl2</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>用户：</td>
			<td>${demo.userName}</td>
			<td>密码：</td>
			<td>${demo.password}</td>
		</tr>
		<tr>
			<td>提示：</td>
			<td colspan="3">${str}</td>
		</tr>
		<tr>
			<td>用户1：</td>
			<td>${demo1.userName}</td>
			<td>密码1：</td>
			<td>${demo1.password}</td>
		</tr>
		<tr>
			<td>session：</td>
			<td colspan="3">${Session["sessionTest"]}</td>
		</tr>
	</table>
</body>
</html>