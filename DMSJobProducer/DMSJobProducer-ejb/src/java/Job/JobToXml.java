package Job;

import java.io.File;
import javax.xml.bind.*;

/**
 * This class carries out the marshalling of a an xml job representation.
 * 
 * @author Bob
 */
public class JobToXml
{   
    public static File jobToXml(Job job)
    {
        File xml = new File("job.xml");
        try {
        JAXBContext jaxbContext = JAXBContext.newInstance(Job.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
       
        marshaller.marshal(job, xml);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return xml;
    }
}
