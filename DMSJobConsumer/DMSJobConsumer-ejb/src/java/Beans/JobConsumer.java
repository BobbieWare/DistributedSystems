package Beans;

import Job.*;
import java.io.File;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.*;

/**
 * The stateless bean carrys out gettign a job object from its destination queue.
 * 
 * @author Bob
 */
@Stateless
@LocalBean
public class JobConsumer
{

    @Inject
    private JMSContext context;
    @Resource(lookup = "jms/jobQueue")
    private Queue queue;

    public Job getJob()
    {
        Job receivedJob = null;
        XMLJob xJob = new XMLJob(); // empty object to fill with an xml job
        try
        {
            JMSConsumer receiver = context.createConsumer(queue);
            xJob.job = receiver.receiveBody(File.class, 1000); // gives 1 second to return a job, else there isnt on on the queue

            if (xJob.job != null)
            {
                receivedJob = XMLtoJob.jobToXml(xJob.job);  // converts xml to a job object
            }
            else
            {
                return null;
            }
            receiver.close();
        } catch (Throwable t)
        {
            System.out.println("JobConsumer.getMessage: Exception: {0}");
        }

        return receivedJob;
    }
}
