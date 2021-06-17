package resources;


import resources.pojos.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

    @Path("/vets/pet/visit/{visit_id}")

    public class VisitResource {

        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        public Response modify(@PathParam("visit_id") Integer visitid,  Visit vist) {
            return Response.ok()
                    .entity(vist)
                    .build();
        }
    
    }

