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
            if (Boolean.valueOf(request.getAttribute("ifNew").toString()))
            {
                out.println(request.getAttribute("newMember"));
            }

            out.println("Welcome " + request.getAttribute("username"));
        %>



        <jsp:useBean id="counterBean" class="Beans.CounterBean">
            <%
                counterBean.incHitCount();
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
