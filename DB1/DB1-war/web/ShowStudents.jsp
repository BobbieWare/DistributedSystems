<%-- 
    Document   : ShowStudents
    Created on : Mar 21, 2019, 3:17:02 PM
    Author     : Bob
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:useBean id = "studentBean" class="Beans.StudentBean"></jsp:useBean>

            <%
                ResultSet rs = studentBean.showStudent(request.getParameter("id"));
            
                out.print(rs.getString(firstName) + rs.getString(lastName));
            %>
    </body>
</html>
