package edu.matc.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Order.
 */
@Entity(name = "Donation")  // type from class name
@Table(name = "donation") // table name, case sensitive!

@Getter
@Setter
@ToString
@NoArgsConstructor
@Proxy(lazy=false)
public class Donation { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotEmpty(message = "Please provide amount")
    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "subject")
    private String subject;

    @Column(name = "user_name")
    private String userName;

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
     *
     * @param amount  the amount
     * @param date    the date
     * @param subject the subject
     * @param userName the userName
     * @param user    the user
     */
    public Donation(int amount, LocalDate date, String subject, String userName, User user) {
        this.amount = amount;
        this.subject = subject;
        this.date = date;
        this.userName = userName;
        this.user = user;
    }

    /**
     * Instantiates a new Donation.
     *
     * @param amount  the amount
     * @param date    the date
     * @param subject the subject
     */
    public Donation(int amount, LocalDate date, String subject) {
        this.amount = amount;
        this.subject = subject;
        this.date = date;
    }

    /**
     * Instantiates a new Donation.
     *
     * @param amount the amount
     */
    public Donation(int amount) {
        this.amount = amount;
    }




}
