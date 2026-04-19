package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Path("/")
public class RootResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getInfo() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("name", "Smart Campus Sensor & Room Management API");
        response.put("version", "v1");

        Map<String, String> admin = new LinkedHashMap<>();
        admin.put("name", "Admin");
        admin.put("email", "admin@smartcampus.ac.uk");
        response.put("admin", admin);

        Map<String, String> resources = new LinkedHashMap<>();
        resources.put("rooms", "/api/v1/rooms");
        resources.put("sensors", "/api/v1/sensors");
        response.put("resources", resources);

        return response;
    }
}