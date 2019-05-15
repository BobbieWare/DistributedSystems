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

        <jsp:useBean id="userBean" class="Beans.UserBean">
            <%
                ArrayList<String> usernames = userBean.getUsernames();

                for (String username : usernames)
                {
                    out.print(username);
                }
            %> 

        </jsp:useBean>
        
        <jsp:useBean id="counterBean" class="Beans.CounterBean">
        </jsp:useBean>

    </body>
</html>
