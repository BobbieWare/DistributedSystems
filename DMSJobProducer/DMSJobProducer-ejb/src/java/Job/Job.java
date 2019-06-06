package Job;

import javax.xml.bind.annotation.*;

/**
 * This class is a representation of a job object, containing the required information for a job.
 * It also has the relevant xml tags for marshalling and unmarshalling.
 * 
 * @author Bob
 */
@XmlRootElement(name="job")
public class Job
{
    @XmlAttribute(name = "title")
    public String title;
    
    @XmlAttribute(name = "message")
    public String message;
    
    @XmlAttribute(name = "givenById")
    public int givenById;

    public Job(String title, String message, int givenById)
    {
        this.title = title;
        this.message = message;
        this.givenById = givenById;
    }
    
    public Job()
    {
    }
    
}
