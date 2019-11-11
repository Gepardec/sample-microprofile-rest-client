package at.ihet.samples.microprofile.rest.client;

import org.jboss.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

/**
 * A request filter as you know them from the server side.
 */
public class RestClientRequestFilter implements ClientRequestFilter {

    private Logger log = Logger.getLogger(RestClientRequestFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        log.infof("Called request filter");
    }
}
