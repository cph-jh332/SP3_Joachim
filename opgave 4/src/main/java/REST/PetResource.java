package REST;

import Entity.Pet;
import Factory.Factory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author craci
 */
@Path("pet")
public class PetResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
    Factory f = new Factory(emf);
    Gson gs = new Gson();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
    }

    /**
     * Retrieves representation of an instance of REST.PetResource
     * @return an instance of java.lang.String
     */
    @Path("petCount")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Pet> pets = f.getAllPets();
        int count = 0;
        for (Pet pet : pets) {
            count++;
        }
        return gs.toJson(count);
    }
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        List<Pet> pets = f.getAllPets();
        JsonArray jaPets = new JsonArray();
        JsonObject joPets = new JsonObject();
        joPets.add("petsAll", jaPets);
        
        for (Pet pet : pets) {
            JsonObject joPet = new JsonObject();
            joPet.addProperty("id", pet.getId());
            joPet.addProperty("name", pet.getName());
            joPet.addProperty("birth", ""+pet.getBirth());
            joPet.addProperty("species", pet.getSpecies());
            joPet.addProperty("ownerFirstname", pet.getOwnerId().getFirstName());
            joPet.addProperty("ownerLastname", pet.getOwnerId().getLastName());
            
            jaPets.add(joPet);
        }
        return gs.toJson(joPets);
        
    }

    /**
     * PUT method for updating or creating an instance of PetResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
