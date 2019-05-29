/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

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
public class JobProducer
{

    @Resource(mappedName = "jms/jobQueue")
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
