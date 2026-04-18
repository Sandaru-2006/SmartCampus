package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Path("/")
public class RootResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("version", "v1");

        Map<String, String> resources = new HashMap<>();
        resources.put("rooms", "/api/v1/rooms");
        resources.put("sensors", "/api/v1/sensors");

        response.put("resources", resources);
        return response;
    }
}