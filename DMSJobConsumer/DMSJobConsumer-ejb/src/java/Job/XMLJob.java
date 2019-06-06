package Job;

import java.io.File;
import java.io.Serializable;

/**
 * This class contains a file object that will be filled with an xml representation of a job.
 * 
 * @author Bob
 */
public class XMLJob implements Serializable
{
    public File job;

    public XMLJob(File job)
    {
        this.job = job;
    }

    public XMLJob()
    {
       this.job = null; 
    }
}
