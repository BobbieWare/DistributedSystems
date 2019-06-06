package RESTfulConsume;

import Beans.HighPriorityJobConsumer;
import Job.Job;
import java.net.URI;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * REST Web Service
 *
 * RESTful interface for getting a high priority job.
 * 
 * @author Bob
 */
@Path("/getHighPrioJob")
public class getHighPriorityJobResource
{
    
    @EJB
    HighPriorityJobConsumer highPriorityJobConsumer;      

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of getHighPriorityJobResource
     */
    public getHighPriorityJobResource()
    {
    }

    /**
     * Produces the response from the EJB, either displays the high priority job or says that it cannot find one.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getHtml()
    {
        Job job = highPriorityJobConsumer.getJob();
        
        if (job != null)
        {
           UriBuilder uriBuilder = UriBuilder.fromUri("../displayJob.jsp").queryParam("title", job.title);
           uriBuilder.queryParam("message", job.message);
           uriBuilder.queryParam("id", job.givenById);
        return Response.seeOther(uriBuilder.build()).build();
        }
        else {
            URI uri = UriBuilder.fromUri("../jobNotFound.html").build();
        return Response.seeOther(uri).build();
        }
    }
}
