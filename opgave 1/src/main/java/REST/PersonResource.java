package REST;

import Converter.JSONConverter;
import Entity.Person;
import com.google.gson.Gson;
import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author craci
 */
@Path("person")
public class PersonResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
    PersonFacade pf = new PersonFacade(emf);
    JSONConverter jc = new JSONConverter();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of REST.PersonResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") String id) {
        return jc.getJSONFromPerson(pf.getPerson(Integer.parseInt(id)));
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        Person p = jc.getPersonFromJson(content);
        pf.addPerson(p);
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteJson(@PathParam("id") int id) {
        pf.deletePerson(id);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateJson(String content) {
        Person p = jc.getPersonFromJson(content);
        System.out.println(p.getPhone());
        pf.editPerson(p);
    }
}
