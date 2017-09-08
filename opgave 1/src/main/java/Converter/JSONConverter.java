package Converter;

import Entity.Person;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author craci
 */
public class JSONConverter {

    Gson gs = new Gson();

    public Person getPersonFromJson(String js) {
        return gs.fromJson(js, Person.class);
    }

    public String getJSONFromPerson(Person p) {
        return gs.toJson(p);
    }

    public String getJSONFromPerson(List<Person> persons) {
        return gs.toJson(persons);
    }
}
