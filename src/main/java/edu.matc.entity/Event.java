package edu.matc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.transaction.Transactional;
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
@Proxy(lazy=false)
//@ToString
public class Event { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "eventName")
    @NotEmpty(message = "Please provide a eventName")
    private String eventName;

    @NotEmpty(message = "Please provide a eventPlace")
    @Column(name = "eventPlace")
    private String eventPlace;

    @Column(name = "eventDate")
    private LocalDate eventDate;

    @Column(name = "eventTime")
    private LocalTime eventTime;

    @NotEmpty(message = "Please provide description")
    @Column(name = "eventDescription")
    private String eventDescription;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "eventMany")

    public Set<User> userMany = new HashSet<>();

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



    public Event(int event) {
    }
}
