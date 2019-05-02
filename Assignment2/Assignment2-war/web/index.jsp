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
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <h1 class="heading">Social Media App</h1>
            <div class="content">
                <%
                    SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date n = new java.util.Date();
                %>
                <p>Date = <%= ff.format(n)%></p>

                <button onclick="location.href = 'login.jsp'" type="button">Enter the News Page</button>

                <p>Name: Bobbie Ware</p> 
                <p>Student ID: 17962233</p>
            </div>
            <div class="content">
                <jsp:useBean id="counterBean" class="Beans.CounterBean">
                    <%                counterBean.incHitCount();
                    %>

                    <h1 class="heading">App Tracker</h1>
                    <%
                        out.print("<p>Hits on all pages: " + counterBean.getHitCount() + "</p>");
                        out.print("<p>User Count: " + counterBean.getUserCount() + "</p>");
                        out.print("<p>Page Count: " + counterBean.getPostCount() + "</p>");

                    %>
                </jsp:useBean>
            </div>
        </div>
    </body>
</html>
