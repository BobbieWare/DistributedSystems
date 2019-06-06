package RESTfulProduce;

import Beans.HighPriorityJobProducer;
import Job.Job;
import java.net.URI;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * REST Web Service
 *
 * A RESTful interface to post a high priority job to a JMS queue
 * 
 * @author Bob
 */
@Path("/postHighPrioJob")
public class PostHighPrioJobResource
{

    @EJB
    HighPriorityJobProducer jobProducer;

    public PostHighPrioJobResource()
    {
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getHtml(@FormParam("jobTitle") String jobTitle, @FormParam("jobMessage") String message, @FormParam("jobGivenById") int id)
    {
        Job job = new Job(jobTitle, message, id);
        jobProducer.sendJMSMessageToJobQueue(job);
        URI uri = UriBuilder.fromPath("../jobSent.jsp").build();
        return Response.seeOther(uri).build();
    }
}
