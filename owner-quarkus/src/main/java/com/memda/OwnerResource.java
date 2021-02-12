package com.memda;

import com.memda.object.Owner;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/owners")
public class OwnerResource {

    private HashMap<String, String> ownersHashMap = new HashMap<>();

    @PostConstruct
    public void init(){
        ownersHashMap.put("AB-13-CD","Patrick");
        ownersHashMap.put("AB-50-XZ","Mohamed");
    }

    @PUT
    @Path("/{identification}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBikeOwner(@PathParam String identification, Owner owner){
        ownersHashMap.put(identification,owner.getOwner());

    }
    public HashMap<String, String> getOwnersHashMap() {
        return ownersHashMap;
    }
}
