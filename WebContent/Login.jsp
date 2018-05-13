
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>

<html>
<head>
<style><%@include file="css/login.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<div class="header">
  <a href="#default" class="logo">Dashboard</a>
  <div class="header-right">
    <a class="active" href="/DashBoard/list">Home</a>
    <a href="/DashBoard/logout">Logout</a>
    
  </div>
</div>




<form action="ControllerServlet" method="POST">

<div class="container">
<br>
<br>
 <label for="login"><b>Login</b></label>
 <input type="text" placeholder="Enter Login" name="login" required>

 <label for="password"><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="password" required>	

<button type="submit">Login</button>




</div>

</form>
<form action="/DashBoard/newacc">
<button>Registration</button>
  
</form>

<div class="footer">
  <p>Lykholat Nazariy</p>
</div>




</body>
</html>