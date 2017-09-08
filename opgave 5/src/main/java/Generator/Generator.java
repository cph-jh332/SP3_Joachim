package Generator;

import Entity.Person;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author craci
 */
public class Generator {
    private Gson gs = new Gson();
    
    public String generate(int generateTo, int startFrom){ 
        List<String> firstnames = generateFirstnames();
        List<String> lastnames = generateLastnames();
        
        List<Person> persons = new ArrayList();
        for (int i = startFrom; i < generateTo+startFrom; i++) {
            int firstnameInd = (int) (Math.random()*firstnames.size());
            int lastnameInd = (int) (Math.random()*lastnames.size());
            int age = (int) (Math.random()*53)+17;
            Person p = new Person(i, firstnames.get(firstnameInd), lastnames.get(lastnameInd), age);
            persons.add(p);
        }
        return gs.toJson(persons);
    }
    
    private List<String> generateFirstnames(){
        List<String> firstnames = new ArrayList();
        firstnames.add("Janni");
        firstnames.add("Jannick");
        firstnames.add("Joachim");
        firstnames.add("Mikkel");
        firstnames.add("Christian");
        firstnames.add("Peter");
        firstnames.add("David");
        firstnames.add("Tjalfe");
        firstnames.add("Benjamin");
        
        return firstnames;
    }
    
    private List<String> generateLastnames(){
        List<String> lastnames = new ArrayList();
        lastnames.add("Hansen");
        lastnames.add("Carl");
        lastnames.add("Clausen");
        lastnames.add("Mikkelsen");
        lastnames.add("Christiansen");
        lastnames.add("Petersen");
        
        return lastnames;
    }
}
