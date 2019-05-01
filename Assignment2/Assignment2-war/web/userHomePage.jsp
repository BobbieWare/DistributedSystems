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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Users</h1>

        <%
            if (session == null)
            {
                response.sendRedirect("login.jsp");
                return;
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

        <br>

        <button onclick="location.href = 'newPost.jsp'" type="button">Make a new Post</button><br>

        <button onclick="location.href = 'newsFeed.jsp'" type="button">Show Feed</button><br>

        <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>

        <jsp:useBean id="counterBean" class="Beans.CounterBean">
            <%                counterBean.incHitCount();
            %>

            <h1>App Tracker</h1>
            <%
                out.print("<p>Hits on all pages: " + counterBean.getHitCount() + "</p>");
                out.print("<p>User Count: " + counterBean.getUserCount() + "</p>");
                out.print("<p>Page Count: " + counterBean.getPostCount() + "</p>");

            %>
        </jsp:useBean>

    </body>
</html>
