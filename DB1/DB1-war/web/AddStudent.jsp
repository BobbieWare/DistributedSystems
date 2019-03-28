<%-- 
    Document   : addStudent
    Created on : 21/03/2019, 10:17:24 AM
    Author     : ktj2012
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body bgcolor="black">       
        <jsp:useBean id = "studentBean" class="Beans.StudentBean"></jsp:useBean>
        <%
            studentBean.addStudent(Integer.parseInt(request.getParameter("id")), request.getParameter("fName"), request.getParameter("lName"));
            %>
            <p>Student added to table</p>
        
        
    </body>
</html>
