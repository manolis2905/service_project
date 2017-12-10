<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New User</title>
</head>
<body>
<h2>New User Information</h2>
<form name="createUserForm" method="post" action="saveNewUser">
Username : 
<input type="text" name="username"><br>
Password : 
<input type="password" name="password"><br>
Position : 
<input type="text" name="position"><br>
<input type="submit" value="Create User">
</form>
<button type="button"><a href="${pageContext.request.contextPath}/user/admin/administrator">Back</a></button>
<c:if test="${not empty message}">
<div style="color:green">${message}</div><br>
</c:if>
</body>
</html>