package Beans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 *
 * @author Bob
 */
@Stateless
@LocalBean
public class AlertPublisher implements NewSessionBeanLocal
{

    @Resource(mappedName = "jms/AlertTopic")
    private Topic alertTopic;

    @Inject
    @JMSConnectionFactory("jms/WebTopicFactory")
    private JMSContext context;

    public void sendJMSMessageToWebTopic(String messageData)
    {
        context.createProducer().send(alertTopic, messageData);
    }
}
