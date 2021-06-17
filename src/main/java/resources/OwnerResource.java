package resources;
import resources.pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("/owners/{username}")
public class OwnerResource {

        private List<Owner> owners = new ArrayList<>();
        private List<String> usaquen = new ArrayList<>();
        private List<String> suba = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String Username) {
        owners.add(new Owner("Juan54321", "Juan", "Jpablo@unbos.edu.co", "suba", 12345));
        owners.add(new Owner("Sergio1234", "sergio", "Sdagomez@unbos.edu.co", "usaquen", 1234));


        for (Owner value : owners) {
            if (value.getNeighborhood().equals("suba")) {
                suba.add(value.getNeighborhood());
            }
            if (value.getNeighborhood().equals("Usaquen")) {
                usaquen.add(value.getNeighborhood());
            }

        }

        return Response.ok()
                .entity(owners)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{username}")
    public Response create(@PathParam("username") String userName, Owner owner) {

        owner.setUserName(userName);

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }

        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        public Response modify(@PathParam("username") String username, Owner owner) {

            return Response.ok()
                    .entity(owner)
                    .build();
        }


    }

