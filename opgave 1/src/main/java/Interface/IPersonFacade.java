package Interface;

import Entity.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author craci
 */
public interface IPersonFacade {
  public Person addPerson(Person p);  
  public Person deletePerson(int id);  
  public Person getPerson(int id);  
  public List<Person> getPersons();  
  public Person editPerson(Person p);  
}

