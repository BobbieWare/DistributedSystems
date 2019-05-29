/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.JobProducer;
import Job.Job;
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
public class ProduceJobService extends HttpServlet
{

    @EJB
    JobProducer jobProducer;

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
        String jobTitle = request.getParameter("jobTitle");
        String jobMessage = request.getParameter("jobMessage");
        int givenById = Integer.parseInt(request.getParameter("jobGivenById"));

        Job job = new Job(jobTitle, jobMessage, givenById);
        jobProducer.sendJMSMessageToJobQueue(job);

        RequestDispatcher view = request.getRequestDispatcher("jobSent.jsp");

        view.forward(request, response);
    }

}
