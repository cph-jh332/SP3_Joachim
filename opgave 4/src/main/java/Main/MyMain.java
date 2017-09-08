package Main;

import Entity.Pet;
import Factory.Factory;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author craci
 */
public class MyMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
        Factory f = new Factory(emf);
        List<Pet> pet = f.getAllPets();
        System.out.println(pet);
        for (Pet pet1 : pet) {
            System.out.println(pet1);
            System.out.println(pet1.getName());
        }
    }
}
