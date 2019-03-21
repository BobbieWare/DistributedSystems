<%-- 
    Document   : addStudent
    Created on : 21/03/2019, 10:17:24 AM
    Author     : ktj2012
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body bgcolor="black">       
        <jsp:useBean id = "studentBean" class="Bean.StudentBean"></jsp:useBean>
        <jsp:setProperty name="studentBean" property="id" value='<%= request.getParameter(id) %>' />
        <jsp:setProperty name="studentBean" property="fName" value='<%= request.getParameter(fName) %>' />
        <jsp:setProperty name="studentBean" property="lName" value='<%= request.getParameter(lName) %>' />
        
        
    </body>
</html>
