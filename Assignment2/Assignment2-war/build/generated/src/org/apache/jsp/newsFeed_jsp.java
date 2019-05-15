package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.UserBean;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;

public final class newsFeed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            public String displayPosts(ResultSet posts, UserBean userBean)
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
                    }
                } catch (Exception e)
                {
                }
                return output;
            }

                                
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>News</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>News Feed</h1>\n");
      out.write("\n");
      out.write("        ");

            if (session == null)
            {
                response.sendRedirect("login.jsp");
                return;
            }
        
      out.write("\n");
      out.write("        ");
      Beans.UserBean userBean = null;
      synchronized (_jspx_page_context) {
        userBean = (Beans.UserBean) _jspx_page_context.getAttribute("userBean", PageContext.PAGE_SCOPE);
        if (userBean == null){
          userBean = new Beans.UserBean();
          _jspx_page_context.setAttribute("userBean", userBean, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("        ");
          Beans.PostBean postBean = null;
          synchronized (_jspx_page_context) {
            postBean = (Beans.PostBean) _jspx_page_context.getAttribute("postBean", PageContext.PAGE_SCOPE);
            if (postBean == null){
              postBean = new Beans.PostBean();
              _jspx_page_context.setAttribute("postBean", postBean, PageContext.PAGE_SCOPE);
              out.write("\n");
              out.write("            ");

                ResultSet posts = postBean.getPosts();
                String output = displayPosts(posts, userBean);
                out.print(output);
            
              out.write("\n");
              out.write("        ");
            }
          }
          out.write("\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <button onclick=\"location.href = 'userHomePage.jsp'\" type=\"button\">Return to Home Page</button>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
