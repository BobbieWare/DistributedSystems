/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTfulConsume;

import Beans.JobConsumer;
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
 * @author Bob
 */
@Path("/getJob")
public class getJobResource
{
    @EJB
    JobConsumer jobConsumer;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of getJobResource
     */
    public getJobResource()
    {
    }

    /**
     * Retrieves representation of an instance of GetJobResource.getJobResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getHtml()
    {
        Job job = jobConsumer.getJob();
        
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
