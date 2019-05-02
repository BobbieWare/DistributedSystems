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
        <link rel="stylesheet" type="text/css" href=" style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
    </head>
    <body>
        <div class="container">
            <h1>News Feed</h1>
            <div class="content">
                <%
                    if (session.getAttribute("username") == null)
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
                                String userID = posts.getString("user_id");
                                String userForPost = userBean.getUserName(Integer.parseInt(userID));
                                output += "<p>Posted by: " + userForPost + "</p>";
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
                                boolean found = false;
                                String buttonLabel;

                                for (String user : users)
                                {
                                    if (user.equals(session.getAttribute("userId") + ""))
                                    {
                                        found = true;
                                    }
                                }
                                if (found)
                                {
                                    buttonLabel = "Unlike";
                                }
                                else
                                {
                                    buttonLabel = "Like";
                                }

                                output += "<form method = \"POST\" action = \"LikeService\">"
                                        + "    <input type = \"submit\" value = \"" + buttonLabel + "\" />"
                                        + "    <input type = \"hidden\" value = \"" + posts.getString("post_id") + "\" name = \"postId\" />"
                                        + "    <input type = \"hidden\" value = \"" + session.getAttribute("userId") + "\" name = \"userId\" />"
                                        + "    <input type = \"hidden\" value = \"" + buttonLabel + "\" name = \"type\" />"
                                        + "</form> ";
                            }
                        } catch (Exception e)
                        {
                        }
                        return output;
                    }
                                                                                                                                                                    %>

                <button onclick="location.href = 'userHomePage.jsp'" type="button">Return to Home Page</button>
            </div>
            <div class="content">
                <jsp:useBean id="counterBean" class="Beans.CounterBean">
                    <%                counterBean.incHitCount();
                    %>

                    <h1 class="heading">App Tracker</h1>
                    <%
                        out.print("<p>Hits on all pages: " + counterBean.getHitCount() + "</p>");
                        out.print("<p>User Count: " + counterBean.getUserCount() + "</p>");
                        out.print("<p>Page Count: " + counterBean.getPostCount() + "</p>");

                    %>
                </jsp:useBean>
            </div>
        </div>
    </body>
</html>
