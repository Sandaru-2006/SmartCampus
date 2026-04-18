package resource;

import model.Room;
import service.DataStore;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    @GET
    public Collection<Room> getAll() {
        return DataStore.rooms.values();
    }

    @POST
    public Response create(Room room) {
        DataStore.rooms.put(room.getId(), room);
        return Response.status(201).entity(room).build();
    }

    @GET
    @Path("/{id}")
    public Room getOne(@PathParam("id") String id) {
        return DataStore.rooms.get(id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        Room room = DataStore.rooms.get(id);

        if (!room.getSensorIds().isEmpty()) {
            throw new RuntimeException("Room has sensors"); // temp (we fix later)
        }

        DataStore.rooms.remove(id);
        return Response.ok().build();
    }
}