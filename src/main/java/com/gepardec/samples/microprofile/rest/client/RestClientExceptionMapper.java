package com.gepardec.samples.microprofile.rest.client;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.jboss.logging.Logger;

import javax.json.bind.JsonbException;
import javax.ws.rs.core.Response;

/**
 * Maps an error response of the rest client code to a RuntimeException which can be handled in your source code.
 */
public class RestClientExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    private Logger log = Logger.getLogger(RestClientHeaderHandler.class);

    @Override
    public RuntimeException toThrowable(Response response) {
        log.infof("Mapping error response to RuntimeException. code: %d", response.getStatus());
        return new RuntimeException(readEntity(response));
    }


    private String readEntity(final Response response) {
        try {
            return response.readEntity(String.class);
        } catch (JsonbException e) {
            return "could not deserialize entity";
        }
    }
}
