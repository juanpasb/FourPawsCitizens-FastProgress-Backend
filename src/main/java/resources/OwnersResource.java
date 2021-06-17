package resources;

import resources.pojos.Owner;
import resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/owners/{username}")
public class OwnersResource {
    ArrayList<Owner> owners = new ArrayList<>();
    ArrayList<Pet> pets = new ArrayList<>();
    List<Owner> filtro = new ArrayList<Owner>();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String Username, Owner owner) {

        owner.setPerson_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username) {

        owners.add(new Owner("Sasha656", "Juan", "Calle 1", "Usaquen", 12345));
        owners.add(new Owner("Motas2121", "Daniel", "Calle 2", "Suba", 123456));

        pets.add(new Pet(12345, "d1fs2d1", "Sasha", "Canino", "Bulldog", "grande", "Macho", null, "Nipemo"));
        pets.add(new Pet(123456, "dfs21df2", "Motas", "Felino", "Criollo", "Mediano", "Hembra", null, "SilenceCam"));



        for (Integer i = 0; i < owners.size(); i++) {
        if (owners.get(i).getUserName().equals(username)) {
           filtro.add(owners.get(i));
            for (Integer j = 0; j < pets.size(); j++) {
                if (pets.get(j).getOwner_id().equals(owners.get(i).getUserName())){
                    filtro.get(i).addPet(pets.get(j));
                }

            }
        }
        }

        return Response.ok()
                .entity(filtro)
                .build();
    }



}