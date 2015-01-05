package io.github.avadhutp.webapprecipe.generic.controllers;

import io.github.avadhutp.webapprecipe.generic.di.ResteasyWiring;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Sample API using RestEASY. Note, the actual URL for these calls will be
 * "sample-api/hello/*". Check {@link ResteasyWiring}, line #24.
 * 
 * @author aphatarpekar
 */
@Path("/hello/")
public class SampleApi {

    @Path("{name}")
    @GET
    public Response hello(@PathParam("name") String name) {
        return Response.status(Status.OK).entity("Hello: " + name).build();
    }
}
