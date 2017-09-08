package main;

import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author craci
 */
public class mymain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
        PersonFacade pf = new PersonFacade(emf);
        
        System.out.println(pf.getPerson(1).getFirstname());
    }
}
