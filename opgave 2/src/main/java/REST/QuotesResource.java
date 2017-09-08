package REST;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author craci
 */
@Path("quote")
public class QuotesResource {

    Gson gs = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuotesResource
     */
    public QuotesResource() {
    }

    /**
     * Retrieves representation of an instance of REST.QuotesResource
     *
     * @return an instance of java.lang.String
     */
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id) {
        String quote = Quotes.Quotes.getQuotes().get(id);
        JsonObject myObj = new JsonObject();
        myObj.addProperty("quote", quote);
        return gs.toJson(myObj);
    }

    @Path("random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandom(@PathParam("id") int id) {
        Map<Integer, String> quotes = Quotes.Quotes.getQuotes();
        String quote = getQuote(quotes);
        JsonObject myObj = new JsonObject();
        myObj.addProperty("quote", quote);
        return gs.toJson(myObj);
    }

    /**
     * PUT method for updating or creating an instance of QuotesResource
     *
     * @param content representation for the resource
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        String newCont = content.replace("\"", "");
        JsonObject myObj = Quotes.Quotes.setQuotes(newCont);
        return gs.toJson(myObj);
    }
    
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteQuote(@PathParam("id") int id){
        return gs.toJson(Quotes.Quotes.deleteQuote(id));
    }

    private String getQuote(Map<Integer, String> quotes) {
        int key = (int) (Math.random() * quotes.size()) + 1;
        String quote = quotes.get(key);
        System.out.println(quote);
        while(quote == null){
            key = (int) (Math.random() * quotes.size())+ 1;
            quote = quotes.get(key);
        }
        return quote;
    }
}
