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
 * The stateless bean carrys out getting a high priority job object from its destination queue.
 * 
 * @author Bob
 */
@Stateless
@LocalBean
public class HighPriorityJobConsumer
{

    @Inject
    private JMSContext context;
    @Resource(lookup = "jms/highPriorityQueue")
    private Queue queue;

    public Job getJob()
    {
        Job receivedJob = null;
        XMLJob xJob = new XMLJob(); // empty object to fill with an xml job
        try
        {
            JMSConsumer receiver = context.createConsumer(queue);
            xJob.job = receiver.receiveBody(File.class, 1000);  // gives 1 second to return a job, else there isnt on on the queue

            if (xJob.job != null)
            {
                receivedJob = XMLtoJob.jobToXml(xJob.job);  // converts xml to a high priority job object
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
