<%-- 
    Document   : jsp5
    Created on : Apr 17, 2019, 2:24:34 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
    </head>
    <body>
        <h1>News Feed</h1>

        <%
            if (session == null)
            {
                response.sendRedirect("login.jsp");
                return;
            }
        %>


        <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>
    </body>
</html>
