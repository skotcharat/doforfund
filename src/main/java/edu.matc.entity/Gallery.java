package edu.matc.entity;


import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.websocket.Encoder;

/**
 * The type Order.
 */
@Entity(name = "Gallery")  // type from class name
@Table(name = "gallery") // table name, case sensitive!

@ToString
public class Gallery { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "category")
    private String category;

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
    public Gallery() {

    }


    /**
     * Instantiates a new Gallery.
     *
     * @param id       the id
     * @param category the category
     * @param picture  the picture
     * @param user     the user
     */
    public Gallery(int id, String category, Encoder.Binary picture, User user) {
        this.id = id;
        this.category = category;
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
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
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
