<%-- 
    Document   : jsp5
    Created on : Apr 17, 2019, 2:24:34 PM
    Author     : Bob
--%>

<%@page import="Beans.UserBean"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
    </head>
    <body>
        <h1>News Feed</h1>

        <%
            if (session == null)
            {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <jsp:useBean id="userBean" class="Beans.UserBean">
            <jsp:useBean id="postBean" class="Beans.PostBean">
                <%
                    ResultSet posts = postBean.getPosts();
                    String output = displayPosts(posts, userBean, session);
                    out.print(output);
                %>
            </jsp:useBean>
        </jsp:useBean>

        <%!
            public String displayPosts(ResultSet posts, UserBean userBean, HttpSession session)
            {
                String output = "";
                try
                {
                    while (posts.next())
                    {
                        output += "<h2>" + posts.getString("title") + "</h2>";
                        output += "<p>" + posts.getString("content") + "</p>";
                        String likes = posts.getString("liked_by");
                        String[] users = likes.split(", ");
                        output += "<p>Liked by: ";
                        for (String user : users)
                        {
                            if (!(user == "0"))
                            {
                                output += " " + userBean.getUserName(Integer.parseInt(user));
                            }
                        }
                        output += "</p>";
                        for (String user : users)
                        {
                            if (user == session.getAttribute("user_id"))
                            {
                                output += "<form method = \"POST\" action = \"LikeService\">"
                                        + "    <input type = \"submit\" value = \"Unlike\" />"
                                        + "    <input type + \"hidden\" value = \"" + posts.getString("post_id") + "\" name = \"postId\" />"
                                        + "    <input type + \"hidden\" value = \"" + user + "\" name = \"postId\" />"
                                        + "</form> ";
                            }
                        }
                    }
                } catch (Exception e)
                {
                }
                return output;
            }
                                                        %>

        <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>
    </body>
</html>
