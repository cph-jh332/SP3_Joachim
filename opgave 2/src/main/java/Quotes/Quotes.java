package Quotes;

import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author craci
 */
public class Quotes {

    private static int key = 3;
    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

    /**
     * @return the quotes
     */
    public static Map<Integer, String> getQuotes() {
        return quotes;
    }

    /**
     * @param aQuotes the quotes to set
     * @return 
     */
    public static JsonObject setQuotes(String aQuotes) {
        key++;
        quotes.put(key, aQuotes);
        JsonObject myObj = new JsonObject();
        myObj.addProperty("id", key);
        myObj.addProperty("quote", aQuotes);
        return myObj;
    }
    
    public static JsonObject deleteQuote(int key){
        JsonObject myObj = new JsonObject();
        myObj.addProperty("quote", quotes.get(key));
        quotes.remove(key);
        return myObj;
    }

}
