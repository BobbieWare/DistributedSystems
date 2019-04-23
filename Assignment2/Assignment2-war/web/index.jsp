<%@page import="java.text.SimpleDateFormat"%>
<%-- 
    Document   : jsb1
    Created on : Apr 17, 2019, 2:23:45 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Social Media App</h1>
        <%
            SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date n = new java.util.Date();
        %>
        <p>Date = <%= ff.format(n)%></p>

        <button onclick="location.href = 'login.jsp'" type="button">Enter the News Page</button>

        <p>Name: Bobbie Ware</p> 
        <p>Student ID: 17962233</p>
    </body>
</html>
