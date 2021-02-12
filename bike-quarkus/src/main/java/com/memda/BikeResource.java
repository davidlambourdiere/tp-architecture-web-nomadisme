package com.memda;

import com.memda.object.Bike;
import io.quarkus.grpc.runtime.annotations.GrpcService;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/bikes")
public class BikeResource {
    @Inject
    @GrpcService("owner")
    OwnerGrpc.OwnerBlockingStub ownerGrpcService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bike> getAllBikes(){
        ArrayList<Bike> bikes = new ArrayList<>();
        // BIKE 1
        String ownerName= ownerGrpcService.getOwnerName(
                OwnerNameRequest.newBuilder()
                        .setId("AB-13-CD")
                        .build()
        ).getName();
        bikes.add(new Bike("VTT maître des montagnes 200",500.0,"AB-13-CD",ownerName));

        //BIKE 2
        ownerName= ownerGrpcService.getOwnerName(
                OwnerNameRequest.newBuilder()
                        .setId("AB-50-XZ")
                        .build()
        ).getName();
        bikes.add(new Bike("Vélo ville",200.0,"AB-50-XZ",ownerName));
        return bikes;
    }

}
