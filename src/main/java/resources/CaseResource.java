package resources;
import resources.pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Pet/{pet_id}/cases")
public class CaseResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer pet_id, Case cases) {

        cases.setCase_id(1);
        cases.setPet_id(pet_id);

        return Response.status(Response.Status.CREATED)
                .entity(cases)
                .build();
    }

}