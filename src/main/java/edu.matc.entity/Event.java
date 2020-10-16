package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.websocket.Encoder;

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

    @Column(name = "eventTime")
    private String eventTime;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "picture")
    private Encoder.Binary picture;



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
     * @param id         the id
     * @param eventName  the event name
     * @param eventPlace the event place
     * @param eventTime  the event time
     * @param user_id    the user id
     * @param picture    the picture
     * @param user       the user
     */
    public Event(int id, String eventName, String eventPlace, String eventTime, String user_id, Encoder.Binary picture, User user) {
        this.id = id;
        this.eventName = eventName;
        this.eventPlace = eventPlace;
        this.eventTime = eventTime;
        this.user_id = user_id;
        this.picture = picture;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets event time.
     *
     * @return the event time
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * Sets event time.
     *
     * @param eventTime the event time
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Sets user id.
     *
     * @param user_id the user id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets picture.
     *
     * @return the picture
     */
    public Encoder.Binary getPicture() {
        return picture;
    }

    /**
     * Sets picture.
     *
     * @param picture the picture
     */
    public void setPicture(Encoder.Binary picture) {
        this.picture = picture;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
