package Tests;

import Converter.JSONConverter;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author craci
 */
public class JSONConverterTest {
    
    JSONConverter jc = new JSONConverter();
    public JSONConverterTest() {
    }
    
    @Test
    public void getJsonFromPerson(){
        Person p = new Person(1, "joachim", "Hansen", 28105308);
        String json = jc.getJSONFromPerson(p);
        String expected = "{\"id\":1,\"firstname\":\"joachim\",\"lastname\":\"Hansen\",\"phone\":28105308}";
        assertEquals(expected, json);
    }
    
    @Test
    public void getJsonFromPersonList(){
        List<Person> pl = new ArrayList<Person>();
        Person p = new Person(1, "joachim", "Hansen", 28105308);
        pl.add(p);
        p = new Person(2, "lulu", "lala", 28105308);
        pl.add(p);
        String json = jc.getJSONFromPerson(pl);
        String expected = "[{\"id\":1,\"firstname\":\"joachim\",\"lastname\":\"Hansen\",\"phone\":28105308},{\"id\":2,\"firstname\":\"lulu\",\"lastname\":\"lala\",\"phone\":28105308}]";
        assertEquals(expected, json);
    }
    
    @Test
    public void getPersonFromJson(){
        Person p = jc.getPersonFromJson("{\"id\":1,\"firstname\":\"joachim\",\"lastname\":\"Hansen\",\"phone\":28105308}");
        Person expected = new Person(1, "joachim", "Hansen", 28105308);
        assertEquals(expected.getId(), p.getId());
    }
}
