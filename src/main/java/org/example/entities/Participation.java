package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue
    @Column(name = "participation_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private StateType state;

    // COSTRUTTORI

    public Participation() {}

    public Participation(Person person, Event event) {
        this.person = person;
        this.event = event;
    }

    public Participation(Person person, Event event, StateType state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }
// GETTER E SETTER


    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", state=" + state +
                '}';
    }
}
