<%-- 
    Document   : newPostPage
    Created on : Apr 17, 2019, 2:24:26 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>    
    <head>
        <title>New Post</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>New Post</h1>
        
        <%
            if (session == null)
            {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        
        <form name="postStatus" action="PostService" method="POST">
            <label>Title: </label><br>
            <input type="text" name="title" size="20" /><br>

            <label>Content: </label> <br>
            <textarea rows="4" cols="50" name="content" form="postStatus" maxlength="200"></textarea> <br>

            <input type="submit" value="Post" name="post" />  <input type="reset" value="Reset" name="reset" /><br>

        </form>
        
        <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>
    </body>
</html>