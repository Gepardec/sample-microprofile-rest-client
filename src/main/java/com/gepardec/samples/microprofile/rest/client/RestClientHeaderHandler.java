package com.gepardec.samples.microprofile.rest.client;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.jboss.logging.Logger;

import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Collections;

public class RestClientHeaderHandler implements ClientHeadersFactory {

    private Logger log = Logger.getLogger(RestClientHeaderHandler.class);

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
                                                 MultivaluedMap<String, String> clientOutgoingHeaders) {
        log.infof("Incoming Headers: %s", toJson(incomingHeaders));
        log.infof("Outgoing Headers: %s", toJson(clientOutgoingHeaders));

        // Will be merged with outgoing headers
        return new MultivaluedHashMap<>() {{
            put("X-Test", Collections.singletonList("test header"));
        }};
    }

    private String toJson(final Object obj) {
        if (obj != null) {
            return JsonbBuilder.create().toJson(obj);
        } else {
            return "null";
        }
    }
}
