/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.AlertPublisher;
import Beans.NewsPublisher;
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
public class MessagePublishService extends HttpServlet
{

    @EJB
    NewsPublisher newsPublisher;

    @EJB
    AlertPublisher alertPublisher;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getParameter("topic") == "news")
        {
            newsPublisher.sendJMSMessageToWebTopic(request.getParameter("message"));
        }
        else
        {
            alertPublisher.sendJMSMessageToWebTopic(request.getParameter("message"));
        }

        RequestDispatcher view = request.getRequestDispatcher("messagePublish.jsp");

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

}
