package org.hoge;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/status")
@ApplicationScoped
public class StatusResource {

    @GET
    @Path("/{code}")
    public Response hello(@PathParam("code") String code) {
        int httpStatusCode = 404;
        if (code.matches("^[1-5][0-9]{2}$")) {
            try {
                httpStatusCode = Integer.parseInt(code);
            }
            catch (NumberFormatException ex) {}
        }
        ResponseBuilder rb = Response.status(httpStatusCode);
        return rb.build();
    }
}
