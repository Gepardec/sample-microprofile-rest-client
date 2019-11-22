package com.gepardec.samples.microprofile.rest.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterProviders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// Makes the rest client available via CDI and register a config key,
// so we can avoid to use fully qualified class names as config key prefixes.
@RegisterRestClient(configKey = "rest.client")
// Register custom header handlers
@RegisterClientHeaders(RestClientHeaderHandler.class)
// Registers the exception handler as a provider
@RegisterProviders({
        @RegisterProvider(RestClientExceptionMapper.class),
        @RegisterProvider(RestClientRequestFilter.class),
        @RegisterProvider(RestClientResponseFilter.class)
})
@Path("/")
public interface ExternalRestResource {

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String get();

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    String delete();

    @Path("/patch")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    String patch();

    @Path("/post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    String post();

    @Path("/invalid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    String invalid();
}
