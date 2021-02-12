package com.memda;

import com.memda.object.Bike;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/bikes")
public class BikeResource {
    ArrayList<Bike> bikes = new ArrayList<>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bike> getAllBikes(){
        bikes.add(new Bike("VTT maître des montagnes 200",500.0,"AB-13-CD"));
        bikes.add(new Bike("Vélo ville",200.0,"AB-50-XZ"));
        return bikes;
    }
}
