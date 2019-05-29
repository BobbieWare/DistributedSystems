package Beans;

import java.util.ArrayList;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Bob
 */
@MessageDriven(activationConfig =
{
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "jms/NewsTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Topic")
})
public class NewsSubscriber implements MessageListener
{
    private ArrayList<String> messages;
    

    public NewsSubscriber()
    {
        messages = new ArrayList<String>();
    }

    @Override
    public void onMessage(Message message)
    {
        try
        {
            if (message instanceof TextMessage)
            {
                messages.add(((TextMessage) message).getText());
            }
            else
            {
                messages.add("Wrong type of message");
            }
        } catch (JMSException e)
        {
            System.out.println("SimpleMessageBean.onMessage: JMSException: {0}" +
                    e.toString());
        }
    }

}
