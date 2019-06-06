package Job;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * This class carries out the unmarshalling of a an xml job representation.
 * 
 * @author Bob
 */
public class XMLtoJob
{

    public static Job jobToXml(File file)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Job.class);
            Unmarshaller m = context.createUnmarshaller();
            return (Job) m.unmarshal(file);
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
