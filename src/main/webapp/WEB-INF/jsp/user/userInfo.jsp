<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>用户id:</td><td>${user.userId}</td>
		</tr>
		<tr>
			<td>用户名:</td><td>${user.userName}</td>
		</tr>
		<tr>
			<td>积分:</td><td>${user.credits}</td>
		</tr>
		<tr>
			<td>上次登录:</td><td>${user.lastIp}</td>
			<!-- user.lastVisit -->
		</tr>
		<tr>
			<td>上次登录:</td><td>${user.lastVisit}</td>
			<!-- user.lastVisit -->
		</tr>
	</table>
</body>
</html>