/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Job.Job;
import Job.XMLJob;
import Job.XMLtoJob;
import java.io.File;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Bob
 */
@Stateless
@LocalBean
public class HighPriorityJobConsumer
{

    @Inject
    private JMSContext context;
    @Resource(lookup = "jms/highPriorityJobQueue")
    private Queue queue;

    public Job getJob()
    {
        Job receivedJob = null;
        XMLJob xJob = new XMLJob();
        try
        {
            JMSConsumer receiver = context.createConsumer(queue);
            xJob.job = receiver.receiveBody(File.class, 1000);

            if (xJob.job != null)
            {
                receivedJob = XMLtoJob.jobToXml(xJob.job);
            }
            else
            {
                return null;
            }
            receiver.close();
        } catch (Throwable t)
        {
            System.out.println("HighPriorityJobConsumer.getMessage: Exception: {0}");
        }

        return receivedJob;
    }
}
