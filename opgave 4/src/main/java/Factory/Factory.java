package Factory;

import Entity.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author craci
 */
public class Factory {
    EntityManagerFactory emf;
    
    public Factory(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public List<Pet> getAllPets(){
        EntityManager em = emf.createEntityManager();
        try {
            List<Pet> pets = em.createQuery("select p from Pet p").getResultList();
            return pets;
        } catch (Exception e) {
        }finally{
            em.close();
        }
        return null;
    }
}
