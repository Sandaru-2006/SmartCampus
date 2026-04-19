package filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
public class LoggingRequestFilter implements ContainerRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(LoggingRequestFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getRequestUri().toString();

        LOGGER.info("[REQUEST] " + method + " " + path);
    }
}
