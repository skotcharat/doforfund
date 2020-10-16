package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Order.
 */
@Entity(name = "Donation")  // type from class name
@Table(name = "donation") // table name, case sensitive!
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

    @Column(name = "user_id")
    private int user_id;

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
     * @param user_id     the user id
     * @param date        the date
     * @param user        the user
     */
    public Donation(int id, int amount, String howToDonate, int sumAmount, int user_id, String date, User user) {
        this.id = id;
        this.amount = amount;
        this.howToDonate = howToDonate;
        this.sumAmount = sumAmount;
        this.user_id = user_id;
        this.date = date;
        this.user = user;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets user id.
     *
     * @param user_id the user id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Gets how to donate.
     *
     * @return the how to donate
     */
    public String getHowToDonate() {
        return howToDonate;
    }

    /**
     * Sets how to donate.
     *
     * @param howToDonate the how to donate
     */
    public void setHowToDonate(String howToDonate) {
        this.howToDonate = howToDonate;
    }

    /**
     * Gets sum amount.
     *
     * @return the sum amount
     */
    public int getSumAmount() {
        return sumAmount;
    }

    /**
     * Sets sum amount.
     *
     * @param sumAmount the sum amount
     */
    public void setSumAmount(int sumAmount) {
        this.sumAmount = sumAmount + amount;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
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
