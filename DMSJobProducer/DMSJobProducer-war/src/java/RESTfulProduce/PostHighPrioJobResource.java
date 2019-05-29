/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTfulProduce;

import Beans.HighPriorityJobProducer;
import Beans.JobProducer;
import Job.Job;
import java.net.URI;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * REST Web Service
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
