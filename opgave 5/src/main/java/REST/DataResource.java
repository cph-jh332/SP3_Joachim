package REST;

import Generator.Generator;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author craci
 */
@Path("data")
public class DataResource {
    Generator gn = new Generator();
    Gson gs = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DataResource
     */
    public DataResource() {
    }

    /**
     * Retrieves representation of an instance of REST.DataResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{amountOfPeople}/{idStart}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("amountOfPeople") int amountOfPeople, @PathParam("idStart") int idStart) {
        return gn.generate(amountOfPeople, idStart);
    }

    /**
     * PUT method for updating or creating an instance of DataResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
