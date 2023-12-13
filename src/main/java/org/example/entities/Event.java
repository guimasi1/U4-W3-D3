package org.example.entities;

import org.hibernate.hql.internal.ast.ParameterTranslationsImpl;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EventType type;
    @Column(name = "maxNumberOfParticipants")
    private int maxNumberOfParticipants;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "event")
    private List<Participation> participations;

    // COSTRUTTORI

    public Event() {}

    public Event(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.type = type;
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    public Event(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.type = type;
        this.maxNumberOfParticipants = maxNumberOfParticipants;
        this.location = location;
    }

    public Event(String title, LocalDate date, String description, EventType type, int maxNumberOfParticipants, Location location, List<Participation> participations) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.type = type;
        this.maxNumberOfParticipants = maxNumberOfParticipants;
        this.location = location;
        this.participations = participations;
    }

    // GETTER

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public EventType getType() {
        return type;
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }


    //SETTER


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Participation> getParticipationList() {
        return participations;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participations = participationList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", maxNumberOfParticipants=" + maxNumberOfParticipants +
                ", location=" + location +
                '}';
    }
}
