package filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
public class LoggingResponseFilter implements ContainerResponseFilter {

    private static final Logger LOGGER = Logger.getLogger(LoggingResponseFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getRequestUri().toString();
        int status = responseContext.getStatus();

        LOGGER.info("[RESPONSE] " + method + " " + path + " -> " + status);
    }
}
