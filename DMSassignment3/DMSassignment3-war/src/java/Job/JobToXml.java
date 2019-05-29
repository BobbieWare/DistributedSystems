/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Job;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.*;

/**
 *
 * @author Bob
 */
public class JobToXml
{    
    public File jobToXml(Job job) throws JAXBException, FileNotFoundException
    {
        File xml = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(Job.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(job, xml);
        marshaller.marshal(job, System.out);
        
        return xml;
    }
}
