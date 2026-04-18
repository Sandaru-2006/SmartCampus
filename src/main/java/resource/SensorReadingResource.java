package resource;

import model.*;
import service.DataStore;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    @GET
    public List<SensorReading> getAll(@PathParam("sensorId") String id) {
        return DataStore.readings.getOrDefault(id, new ArrayList<>());
    }

    @POST
    public Response add(@PathParam("sensorId") String id, SensorReading reading) {
        Sensor sensor = DataStore.sensors.get(id);

        if (sensor == null) {
            throw new RuntimeException("Sensor not found");
        }

        List<SensorReading> list = DataStore.readings.computeIfAbsent(id, k -> new ArrayList<>());
        list.add(reading);

        sensor.setCurrentValue(reading.getValue());

        return Response.status(201).build();
    }
}