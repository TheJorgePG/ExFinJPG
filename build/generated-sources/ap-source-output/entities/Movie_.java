package entities;

import entities.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-18T09:26:56")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> trama;
    public static volatile SingularAttribute<Movie, Date> fecha;
    public static volatile ListAttribute<Movie, Person> personList;
    public static volatile SingularAttribute<Movie, String> titulo;
    public static volatile SingularAttribute<Movie, Integer> id;
    public static volatile SingularAttribute<Movie, String> poster;

}