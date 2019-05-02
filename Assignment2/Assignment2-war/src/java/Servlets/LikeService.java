/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.PostBean;
import java.io.IOException;
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
public class LikeService extends HttpServlet
{

    @EJB
    private PostBean postBean;

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
        String functionType = (String) request.getParameter("type");

        if (functionType.equalsIgnoreCase("Like"))
        {
            postBean.likePost((String) request.getParameter("postId"), (String) request.getParameter("userId"));
        }
        else if (functionType.equalsIgnoreCase("Unlike"))
        {
            postBean.unlikePost((String) request.getParameter("postId"), (String) request.getParameter("userId"));
        }
        
        RequestDispatcher view = request.getRequestDispatcher("newsFeed.jsp");

            view.forward(request, response);
    }

}
