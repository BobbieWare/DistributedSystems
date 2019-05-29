package Beans;

import Job.XMLtoJob;
import Job.XMLJob;
import Job.*;
import java.io.File;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.*;

/**
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
            System.out.println("ReceiverBean.getMessage: Exception: {0}");
        }

        return receivedJob;
    }
}
