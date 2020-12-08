package edu.matc.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * The type Order.
 */
@Entity(name = "Contact")  // type from class name
@Table(name = "contact") // table name, case sensitive!

@Getter
@Setter
@ToString
@NoArgsConstructor
@Proxy(lazy=false)
public class Contact { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Contact.
     *  @param firstname the firstname
     * @param lastname  the lastname
     * @param email     the email
     * @param subject   the subject
     * @param user   the user
     */
    public Contact(String firstname, String lastname, String email, String subject, String message, String userName, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.userName = userName;
        this.user = user;

    }

    /**
     * Instantiates a new Contact.
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param email     the email
     * @param subject   the subject
     */
    public Contact(String firstname, String lastname, String email, String subject, String message) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.subject = subject;
        this.message = message;

    }
}

