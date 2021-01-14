<%-- 
    Document   : displayJob
    Created on : May 23, 2019, 3:14:10 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <h1>Mega Corp Processing Plant</h1>
            </div>
            <div class="content">
                <h2>Jobs</h2>
            </div>
            <div class="content"><p>
                    <% out.println("<p>Job Title: " + request.getParameter("title")+ "</p>");
                        out.println("<p>Job description: " + request.getParameter("message")+ "</p>");
                        out.println("<p>Given by id: " + request.getParameter("id")+ "</p>");
                    %>
                </p>

                <a href="index.html">Back</a>
            </div>
            <footer class="foot">
                <p>This app was developed by Bobbie Ware id:17962233</p>
                <p>for Comp713 assignment 3. </p>
            </footer>
        </div>
    </body>
</html>
