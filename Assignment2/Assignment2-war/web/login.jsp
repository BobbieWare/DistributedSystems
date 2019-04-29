<%-- 
    Document   : jsp2
    Created on : Apr 17, 2019, 2:23:59 PM
    Author     : Bob
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>

        
        <%
            if (!(request.getAttribute("error") == null))
                {
                     out.print(request.getAttribute("error"));
                }           
            %>

        <p>Please enter your username: </p>

        <form method="POST" action="LoginService">
            <input type="text" name="username" value="" size="8" /> (Max 8 characters, only letters or numbers) <br><br>
            <input type="submit" value="Login" />
        </form>
        
        <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>
    </body>
</html>
