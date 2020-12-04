package edu.matc.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
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
//@ToString cannot use in this class because of the userRole effect
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
    public Set<UserRole> userRoles = new HashSet<>();

//    /**
//     * The Events.
//     */
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "events_user",
//            joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "events_id") }
//    )
//    Set<Event> events;
//
//
//    /**
//     * Add event.
//     *
//     * @param event the event
//     */
//    public void addEvent(Event event) {
//        this.events.add(event);
//        event.getUsers().add(this);
//    }
//
//    /**
//     * Remove event.
//     *
//     * @param event the event
//     */
//    public void removeEvent(Event event) {
//        this.getEvents().remove(event);
//        event.getUsers().remove(this);
//    }
//
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