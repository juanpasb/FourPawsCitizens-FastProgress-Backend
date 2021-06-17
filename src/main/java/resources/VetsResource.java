package resources;

import resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/user/{user_id}/Vet")
public class VetsResource {
    List<Vet> vets = new ArrayList<Vet>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {


        vets.add(new Vet("Juaniquilador", "Juan", "Calle 1", "Usaquen"));
        vets.add(new Vet("Danielxd123", "Daniel", "Calle 2", "Suba"));

        return Response.ok()
                .entity(vets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("user_id") String user_id,Vet vet) {
        vet.setUserName(user_id);
        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("user_id") String user_id, Vet vet) {
        vet.setUserName(user_id);
        return Response.ok()
                .entity(vet)
                .build();

    }





}