package edu.matc.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Order.
 */
@Entity(name = "Donation")  // type from class name
@Table(name = "donation") // table name, case sensitive!

@Getter
@Setter
@ToString

public class Donation { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "howToDonate")
    private String howToDonate;

    @Column(name = "sumAmount")
    private int sumAmount;

    @Column(name = "date")
    private String date;

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
     * Instantiates a new Donation.
     */
    public Donation() {

    }

    /**
     * Instantiates a new Donation.
     *
     * @param id          the id
     * @param amount      the amount
     * @param howToDonate the how to donate
     * @param sumAmount   the sum amount
     * @param date        the date
     * @param user        the user
     */
    public Donation(int id, int amount, String howToDonate, int sumAmount, String date, User user) {
        this.id = id;
        this.amount = amount;
        this.howToDonate = howToDonate;
        this.sumAmount += amount;
        this.date = date;
        this.user = user;
    }

    /**
     * Instantiates a new Donation.
     * @param amount the amount
     */
    public Donation(int amount) {
        this.amount = amount;
    }






}
