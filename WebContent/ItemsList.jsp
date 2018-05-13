<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>

<%@include file="css/login.css"%>

</style>
<title>${user.login}'s DashBoard</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

    
  
</head>
<body>

<div class="header">

   <a href="/DashBoard/new">Add New Item</a>
            &nbsp;&nbsp;&nbsp;
          <a href="${pageContext.request.contextPath}/list">List All Items</a>
          
  <div class="header-right">
    <a class="active" href="/DashBoard/list">Home</a>
    <a href="/DashBoard/logout">Logout</a>
    
  </div>
</div>
    <center>
       
        <h2>
           
         
           
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
     
        	
        	 <caption><h3>Welcome ${user.login}</h3></caption>
            <caption><h2>List of Items</h2></caption>
            <tr>
               
                <th>Title</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="item" items="${listItems}">
                <tr>
                	
                    
                    <td><c:out value="${item.title}" /></td>
                    <td><c:out value="${item.description}" /></td>
                   	
                    <td>
                        <a href="/DashBoard/edit?id=<c:out value='${item.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/DashBoard/delete?id=<c:out value='${item.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    <div class="footer">
  <p>Lykholat Nazariy</p>
</div>
</body>
</html>