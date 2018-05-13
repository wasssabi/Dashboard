<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="css/login.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<div class="header">
  <a href="#default" class="logo">Register</a>
  <div class="header-right">
    <a class="active" href="/DashBoard/list">Home</a>
    <a href="/DashBoard/logout">Logout</a>
    
  </div>
</div>


 <form action="adduser" method="post">
 <br>
<br>
      Login :<input type="text" name="login"><br/>
Password :<input type="password" name="password"><br/>
<button>Registration</button>
</form>
</center>

<div class="footer">
  <p>Lykholat Nazariy</p>
</div>

</body>
</html>