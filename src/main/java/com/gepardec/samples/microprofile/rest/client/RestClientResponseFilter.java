package com.gepardec.samples.microprofile.rest.client;

import org.jboss.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

/**
 * A response filter as you know them from the server side.
 */
public class RestClientResponseFilter implements ClientResponseFilter {

    private Logger log = Logger.getLogger(RestClientResponseFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        log.infof("Called response filter");
    }
}
