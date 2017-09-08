package REST;

import Converter.JSONConverter;
import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author craci
 */
@Path("persons")
public class PersonsResource {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
    PersonFacade pf = new PersonFacade(emf);
    JSONConverter jc = new JSONConverter();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonsResource
     */
    public PersonsResource() {
    }

    /**
     * Retrieves representation of an instance of REST.PersonsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return jc.getJSONFromPerson(pf.getPersons());
    }

    /**
     * PUT method for updating or creating an instance of PersonsResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
