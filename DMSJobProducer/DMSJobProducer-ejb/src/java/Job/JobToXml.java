/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Job;

import java.io.File;
import javax.xml.bind.*;

/**
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
