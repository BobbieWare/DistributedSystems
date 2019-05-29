/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Job;

import javax.xml.bind.annotation.*;

/**
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
