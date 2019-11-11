package at.ihet.samples.microprofile.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/")
public class InternalResource {

    // Qualified injection of the type safe rest client
    @Inject
    @RestClient
    ExternalRestResource externalRestResource;

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return externalRestResource.get();
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String delete() {
        return externalRestResource.delete();
    }

    @Path("/patch")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    public String patch() {
        return externalRestResource.patch();
    }

    @Path("/post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String post() {
        return externalRestResource.post();
    }

    @Path("/invalid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String invalid() {
        try {
            return externalRestResource.invalid();
        } catch (RuntimeException e) {
            return String.format("Request of client failed with exception: %s", e.getMessage());
        }
    }
}
