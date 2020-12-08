package edu.matc.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Event_User")
@Table(name = "events_user") // case sensitive!

@Getter
@Setter
@NoArgsConstructor
public class Event_User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "events_id")
    private int events_id;

    @Column(name = "user_id")
    private int user_id;

    public Event_User(int events_id, int user_id) {
        this.events_id = events_id;
        this.user_id = user_id;
    }
}
