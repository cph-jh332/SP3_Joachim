package Entity;

import Entity.Event;
import Entity.Owner;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-07T15:23:13")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile CollectionAttribute<Pet, Event> eventCollection;
    public static volatile SingularAttribute<Pet, Date> death;
    public static volatile SingularAttribute<Pet, String> species;
    public static volatile SingularAttribute<Pet, String> name;
    public static volatile SingularAttribute<Pet, Date> birth;
    public static volatile SingularAttribute<Pet, Integer> id;
    public static volatile SingularAttribute<Pet, Owner> ownerId;

}