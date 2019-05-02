/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.CounterBean;
import Beans.PostBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bob
 */
public class PostService extends HttpServlet
{

    @EJB
    private PostBean postBean;
    @EJB
    private CounterBean counterBean;

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
        HttpSession session = request.getSession();
        String userId = "" + session.getAttribute("userId");
        
        String title = (String) request.getParameter("title");
        String content = (String) request.getParameter("content");

        if (title.length() > 20 || title.length() == 0 || content.length() > 200 || content.length() == 0)
        {
            request.setAttribute("message", "Invalid post, please try again");
            request.setAttribute("showMessage", "true");
        }
        else
        {
            request.setAttribute("message", "Post submitted, thank you");
            request.setAttribute("showMessage", "true");
            postBean.addPost(title, content, userId);
            counterBean.incPostCount();
        }

        RequestDispatcher view = request.getRequestDispatcher("userHomePage.jsp");
        view.forward(request, response);
    }
}
