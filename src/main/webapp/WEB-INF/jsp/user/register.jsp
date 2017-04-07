<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="forms" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
</head>
<body>
	<form method="post" action="<c:url value="/user.html"/>">
		<forms:errors path="*" />
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" />${result.allErrors.size}</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><forms:errors path="userName" cssClass="errorClass"/><input type="text" name="realName" /></td>
			</tr>
			<tr>
			<tr>
				<td>邮箱:</td>
				<td><forms:errors path="email" cssClass="errorClass"/><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>验证码:</td>
				<td><img alt="" src="<c:url value="/user/handle42"/>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>