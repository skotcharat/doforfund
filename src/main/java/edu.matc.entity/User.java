package edu.matc.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity(name = "User")
@Table(name = "user") // case sensitive!

@Getter
@Setter
@NoArgsConstructor
@Proxy(lazy=false)
@ToString
public class User {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;


    @Column(name = "password")
    private String password;

    @NotEmpty(message = "Please provide an email")
    @Column(name = "email")
    private String email;

    /**
     * Bidirectional @OneToMany
     * The bidirectional @OneToMany association also requires a @ManyToOne association on the child side.
     * Although the Domain Model exposes two sides to navigate this association, behind the scenes,
     * the relational database has only one foreign key for this relationship.
     * Every bidirectional association must have one owning side only (the child side),
     * the other one being referred to as the inverse (or the mappedBy) side.
     * Foreign key is on the child table (Order in this example)
     * Source: http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
     */
//mappedBy = "user" came from instance variable at UserRole class
     //private User user;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude @EqualsAndHashCode.Exclude  public Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude @EqualsAndHashCode.Exclude  public Set<Donation> donations = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude @EqualsAndHashCode.Exclude  public Set<Contact> contacts = new HashSet<>();

    public User(User retrievedUser) {
    }
    /**
     * Add a donations.
     *
     * @param donations the Donation to add
     */
    public void addDonation(Donation donation) {
        donations.add(donation);
        donation.setUser(this);
    }

    /**
     * Add a donations.
     *
     * @param donations the UserRole to add
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
        contact.setUser(this);
    }

    /**
     * The Events.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
    @JoinTable(

            name = "events_user",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "events_id") }
    )

    Set<Event> eventMany = new HashSet<>();

    public User(int user) {
    }



//    /**
//     * Add event.
//     *
//     * @param event the event
//     */
//    public void addEvent(Event event) {
//        eventMany.add(event);
//        event.getUserMany().add(this);
//    }
//
//    /**
//     * Remove event.
//     *
//     * @param event the event
//     */
//    public void removeEvent(Event event) {
//        eventMany.remove(event);
//        event.getUserMany().remove(this);
//    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

//    /**
//     * Remove event.
//     */
//    public void removeEvent() {
//        for (Event event : new HashSet<>(events)) {
//            removeEvent(event);
//        }
//    }

    /**
     * Add a UserRoles.
     *
     * @param userRole the UserRole to add
     */
    public void addUserRoles(UserRole userRole) {
        userRoles.add(userRole);
        userRole.setUser(this);
    }

    /**
     * Remove user roles.
     *
     * @param userRole the user role
     */
    public void removeUserRoles(UserRole userRole) {
        userRoles.remove( userRole );
        userRole.setUser( null );

    }

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param password the password
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param email     the email
     */
    public User(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;

    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param password  the password
     * @param email     the email
     */
    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;

    }






    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +

                '}';
    }



}