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
public class NewsPublisher implements MessageProducerLocal
{

    @Resource(mappedName = "jms/NewsTopic")
    private Topic newsTopic;

    @Inject
    @JMSConnectionFactory("jms/WebTopicFactory")
    private JMSContext context;

    public void sendJMSMessageToWebTopic(String messageData)
    {
            context.createProducer().send(newsTopic, messageData);
    }
}
