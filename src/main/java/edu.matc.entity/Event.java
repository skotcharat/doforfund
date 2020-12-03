package edu.matc.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Order.
 */
@Entity(name = "Event")  // type from class name
@Table(name = "events") // table name, case sensitive!

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Event { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "eventName")
    //@NotNull(message = "Please provide a eventName")
    private String eventName;

    @Column(name = "eventPlace")
    private String eventPlace;

    @Column(name = "eventDate")
    private LocalDate eventDate;

    @Column(name = "eventTime")
    private LocalTime eventTime;

    @Column(name = "eventDescription")
    private String eventDescription;




    /**
     * Bidirectional @OneToMany

     The bidirectional @OneToMany association also requires a @ManyToOne association on the child side.
     Although the Domain Model exposes two sides to navigate this association, behind the scenes,
     the relational database has only one foreign key for this relationship.

     Every bidirectional association must have one owning side only (the child side),
     the other one being referred to as the inverse (or the mappedBy) side.

     Foreign key is on the child table (Order in this example)

     By default, the @ManyToOne association assumes that the parent-side entity identifier is to be used to join
     with the client-side entity Foreign Key column.

     However, when using a non-Primary Key association,
     the column description and foreign key should be used to instruct Hibernate
     which column should be used on the parent side to establish the many-to-one database relationship.

     Source: http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
     */
    @ManyToOne
    private User user;

//    @ManyToMany(mappedBy = "eventsJoin")
//    private Set<User> userEvent = new HashSet<>();

    /**
     * Instantiates a new Event.
     *
     * @param eventName  the event name
     * @param eventPlace the event place
     * @param eventDate  the event Date
     * @param eventTime  the event time
     * @param eventDescription  the event Description
     */
    public Event(String eventName, String eventPlace, LocalDate eventDate, LocalTime eventTime, String eventDescription) {
        this.eventName = eventName;
        this.eventPlace = eventPlace;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;

    }



}
