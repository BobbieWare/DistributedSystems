<%-- 
    Document   : Login Page
    Created on : Apr 17, 2019, 2:23:59 PM
    Author     : Bob
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <h1 class="heading">Login</h1>
            <div class="content">
                <%
                    if (!(request.getAttribute("error") == null))
                    {
                        out.print(request.getAttribute("error"));
                    }
                %>

                <p>Please enter your username: </p>

                <form method="POST" action="LoginService">
                    <input type="text" name="username" value="" size="8" /> (Max 8 characters, Min 3, only letters or numbers) <br><br>
                    <input type="submit" value="Login" />
                </form>

                <button onclick="location.href = 'index.jsp'" type="button">Return to Index</button>
            </div>
            <div class="content">
                <jsp:useBean id="counterBean" class="Beans.CounterBean">
                    <%                
                        counterBean.incHitCount();
                    %>

                    <%--This tracks the hit, post, and user count for the app--%>
                    <h1 class="heading">App Tracker</h1>
                    <%
                        out.print("<p>Hits on all pages: " + counterBean.getHitCount() + "</p>");
                        out.print("<p>User Count: " + counterBean.getUserCount() + "</p>");
                        out.print("<p>Post Count: " + counterBean.getPostCount() + "</p>");

                    %>
                </jsp:useBean>
            </div>
        </div>
    </body>
</html>
