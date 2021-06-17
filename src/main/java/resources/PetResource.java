package resources;


import resources.pojos.Owner;
import resources.pojos.Pet;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("Owner/pet/{pet_id}")
public class PetResource {
    private List<Pet> pets = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        pets.add(new Pet(1, "sf5d1fs", "Sasha", "Felino", "Criollo", "Pequeño", "Macho", "asd", null));
        pets.add(new Pet(2, "ert897tg", "Motas", "Canino", "pasrot aleman", "Mediano", "Macho", "dfg", null));
        pets.add(new Pet(3, "fd54gdf564", "Rex", "Canino", "bulldog", "Grande", "Hembra", "dgfbbv", null));

        return Response.ok()
                .entity(pets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pet pet) {

        pet.setPet_id(1);
        pet.setName("max");
        pets.add(pet);

        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("pet_id") Integer id, Pet pet) {
        return Response.ok()
                .entity(pet)
                .build();
    }



}
