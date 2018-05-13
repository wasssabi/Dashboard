<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>

<%@include file="css/login.css"%>

</style>
<title>${user.login}'s DashBoard</title>
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






    <div align="center">
    
        <c:if test="${item != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${item == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${item != null}">
                        Edit Item
                    </c:if>
                    <c:if test="${item == null}">
                        Add New Item
                    </c:if>
                </h2>
            </caption>
            
           
            
                    
                   
                       
            <tr>
                <th>Title: </th>
                <td>
                	<input type="hidden" name="id" size="9" value="<c:out value='${item.id}' />" />
                    <input type="text" name="title" size="45"
                            value="<c:out value='${item.title}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                    <input type="text" name="description" size="45"
                            value="<c:out value='${item.description}' />"
                    />
                     <input type="hidden" name="userlogin"
                            value="<c:out value='${user.login}' />"
                        />
                </td>
            </tr>
           
                
              
               
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
    
    <div class="footer">
  <p>Lykholat Nazariy</p>
</div>
</body>
</html>