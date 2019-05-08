<%-- 
    Document   : Users Home Page
    Created on : Apr 17, 2019, 2:24:18 PM
    Author     : Bob
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Users</h1>
            <div class="content">
                
                <h1>Action</h1>
                <%
                    if (session.getAttribute("username") == null)
                    {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                %>

                <%
                    if (request.getAttribute("showMessage") == "true")
                    {
                        out.println(request.getAttribute("message"));
                    }
                %>

                <%
                    if (session.getAttribute("new") == "true")
                    {
                        if (Boolean.valueOf(request.getAttribute("ifNew").toString()))
                        {
                            out.println(request.getAttribute("newMember"));
                        }

                        out.println("Welcome " + session.getAttribute("username"));
                        session.setAttribute("new", "false");
                    }

                %>

                <button onclick="location.href = 'newPost.jsp'" type="button">Make a new Post</button><br>

                <button onclick="location.href = 'newsFeed.jsp'" type="button">Show Feed</button><br>

                <button onclick="location.href = 'LogoutService'" type="button">Logout</button>


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
