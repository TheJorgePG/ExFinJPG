package entities;

import entities.Person;
import entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-18T09:26:56")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, Short> idrating;
    public static volatile SingularAttribute<Rating, Short> puntos;
    public static volatile SingularAttribute<Rating, Person> idperson;
    public static volatile SingularAttribute<Rating, Usuario> dni;

}