package resources;

import resources.pojos.Pet;
import resources.pojos.ImagePet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/{pet_id}/image")
public class PetsResource {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createImage(@PathParam("pet_id") Integer pet_id, ImagePet imagePet) {
        imagePet.setPet_id(pet_id);
        Pet pet = new Pet(pet_id, "dfds1fds1", "Motas", "Canino", "Pastor Aleman", "Mediano", "Macho", "xlr", "asfdfd");

        return Response
                .status(Response.Status.CREATED)
                .entity(imagePet)
                .build();
    }

}