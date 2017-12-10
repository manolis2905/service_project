<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
  <ul>
    <li><strong>Home</strong></li>
    <li><a href="${pageContext.request.contextPath}/user/admin/createUser">Create new User</a></li>
    <li><a href="${pageContext.request.contextPath}/user/admin/modifyUser">Modify User</a></li>
    <li><a href="${pageContext.request.contextPath}/user/admin/deleteUser">Delete User</a></li>
    <li><a href="contact.html">Log out</a></li>
  </ul>
</body>
</html>