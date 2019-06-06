package Beans;

import Job.Job;
import Job.JobToXml;
import java.io.File;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 * Converts a job object into xml and posts it onto the queue. 
 * 
 * @author Bob
 */
@Stateless
@LocalBean
public class HighPriorityJobProducer
{

    @Resource(mappedName = "jms/highPriorityQueue")
    private Queue jobQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public void sendJMSMessageToJobQueue(Job job)
    {
        File xJob = JobToXml.jobToXml(job);

        ObjectMessage om = context.createObjectMessage(xJob);

        context.createProducer().send(jobQueue, om);
    }
}
