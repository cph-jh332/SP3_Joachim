package Tests;

import Entity.Person;
import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author craci
 */
public class PersonFacadeTest {
    
    static EntityManagerFactory emf;
    static PersonFacade pf;
    
    public PersonFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("jpaPu");
        pf = new PersonFacade(emf);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAddPerson(){
        Person p = new Person("Lars", "Larsen", 22232425);
        Person test = pf.addPerson(p);
        assertEquals(p, test);
    }
    
    @Test
    public void testEditPerson(){
        Person p = new Person(1, "Lassi", "Larsen", 2222);
        Person p1 = pf.editPerson(p);
        assertEquals(p.getFirstname(), p1.getFirstname());
    }
    
    @Test
    public void testDeletePerson(){
        Person p = pf.deletePerson(2);
        int expected = 2;
        assertEquals(expected, p.getId());
    }

}
