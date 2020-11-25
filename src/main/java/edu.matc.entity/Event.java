package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.websocket.Encoder;
import java.sql.Time;
import java.util.Date;

/**
 * The type Order.
 */
@Entity(name = "Event")  // type from class name
@Table(name = "events") // table name, case sensitive!
public class Event { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "eventPlace")
    private String eventPlace;

    @Column(name = "eventDate")
    private Date eventDate;

    @Column(name = "eventTime")
    private Time eventTime;

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

    /**
     * Instantiates a new Order.
     */
    public Event() {

    }

    /**
     * Instantiates a new Event.
     *
     * @param eventName  the event name
     * @param eventPlace the event place
     * @param eventDate  the event Date
     * @param eventTime  the event time
     * @param eventDescription  the event Description
     */
    public Event(String eventName, String eventPlace, Date eventDate, Time eventTime, String eventDescription) {
        this.eventName = eventName;
        this.eventPlace = eventPlace;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;

    }

    /**
     * Gets event description.
     *
     * @return the event description
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * Sets event description.
     *
     * @param eventDescription the event description
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * Gets event name.
     *
     * @return the event name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets event name.
     *
     * @param eventName the event name
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets event place.
     *
     * @return the event place
     */
    public String getEventPlace() {
        return eventPlace;
    }

    /**
     * Sets event place.
     *
     * @param eventPlace the event place
     */
    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    /**
     * Gets event date.
     *
     * @return the event date
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * Sets event date.
     *
     * @param eventDate the event date
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets event time.
     *
     * @return the event time
     */
    public Time getEventTime() {
        return eventTime;
    }

    /**
     * Sets event time.
     *
     * @param eventTime the event time
     */
    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }
}
