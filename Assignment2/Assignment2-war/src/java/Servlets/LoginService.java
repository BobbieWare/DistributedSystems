package Servlets;

import Beans.CounterBean;
import Beans.UserBean;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bob
 */
public class LoginService extends HttpServlet
{

    @EJB
    private CounterBean counterBean;
    private UserBean userBean;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");

        // If the username does not match the required format, return to login page and display an error
        if (!username.matches("[a-zA-Z0-9]*"))
        {
            request.setAttribute("error", "<p style=\"color : red;\">Invalid Username, Please Try Again</p>");
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");

            view.forward(request, response);
        }
        else
        {
            ArrayList<String> usernames = userBean.getUsernames();
            
            if (!usernames.contains(username) || usernames.contains("No one"))
            {
                userBean.addUser(username);
                counterBean.incUserCount();
                request.setAttribute("newMember", "<p style=\"color : blue;\">Welcome to this Social Media Website</p>");
            }
            
            RequestDispatcher view = request.getRequestDispatcher("userHomePage.jsp");

            view.forward(request, response);
        }
        
    }

}
