<%-- 
    Document   : New Post Page
    Created on : Apr 17, 2019, 2:24:26 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>    
    <head>
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <title>New Post</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <h1>New Post</h1>
            <div class="content">
                <%
                    if (session.getAttribute("username") == null)
                    {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                %>

                <form name="postStatus" action="PostService" method="POST">
                    <label>Title: </label><br>
                    <input type="text" name="title" size="20" /><br>

                    <label>Content: </label> <br>
                    <textarea rows="4" cols="50" name="content" maxlength="200" placeholder="Text"></textarea> <br>

                    <input type="submit" value="Post" name="post" />  <input type="reset" value="Reset" name="reset" /><br>

                </form>

                <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>
            </div>
            <div class="content">
                <jsp:useBean id="counterBean" class="Beans.CounterBean">
                    <%                
                        counterBean.incHitCount();
                    %>

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