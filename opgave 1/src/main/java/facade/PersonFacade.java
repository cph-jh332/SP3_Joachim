package facade;

import Entity.Person;
import Interface.IPersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author craci
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf;
    
    public PersonFacade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    @Override
    public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }finally{
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }finally{
            em.close();
        }
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            Person p = em.find(Person.class, id);
            return p;
        }catch(Exception e){
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("select p from Person p").getResultList();
        }finally{
            em.close();
        }
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Person p1 = em.find(Person.class, p.getId());
            p1.setFirstname(p.getFirstname());
            p1.setLastname(p.getLastname());
            p1.setPhone(p.getPhone());
            em.getTransaction().commit();
            return p1;
        }finally{
            em.close();
        }
    }
    
}
