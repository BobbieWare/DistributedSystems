<%-- 
    Document   : displayJob
    Created on : May 23, 2019, 3:14:10 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Jobs</h1>
        
        <p>
            <% out.print(request.getParameter("title"));
                out.print(request.getParameter("message"));
                out.print(request.getParameter("id"));            
            %>
        </p>
            
            <a href="index.html">Back</a>
    </body>
</html>
