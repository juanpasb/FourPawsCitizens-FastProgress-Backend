package resources;

import resources.pojos.Case;
import resources.pojos.CasesT;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/cases")
public class CasesTResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTotalCasesByType() {
        List<Case> caseByType = new ArrayList<>();


        caseByType.add(new Case("Perdida", 85));
        caseByType.add(new Case("Robo", 22));
        caseByType.add(new Case("Fallecimiento", 37));

        CasesT casesT = new CasesT(144, caseByType);

        return Response.ok()
                .entity(casesT)
                .build();
    }
}