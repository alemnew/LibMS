package org.mk.rc.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-30T16:58:45")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, Long> id;
    public static volatile SingularAttribute<Reservation, Long> pubId;
    public static volatile SingularAttribute<Reservation, Long> userId;
    public static volatile SingularAttribute<Reservation, String> expectedDate;
    public static volatile SingularAttribute<Reservation, String> resDate;

}