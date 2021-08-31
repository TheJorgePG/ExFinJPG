package entities;

import entities.Movie;
import entities.Rating;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-18T09:26:56")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> foto;
    public static volatile ListAttribute<Person, Rating> ratingList;
    public static volatile SingularAttribute<Person, BigDecimal> popularidad;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile ListAttribute<Person, Movie> movieList;
    public static volatile SingularAttribute<Person, String> nombre;

}