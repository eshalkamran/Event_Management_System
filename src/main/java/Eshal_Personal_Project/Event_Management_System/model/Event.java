package Eshal_Personal_Project.Event_Management_System.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String location;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;

    @ManyToMany
    @JoinTable(
            name = "event_attendees",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> attendees;

    // Constructor
    public Event(String name, String description, Date date, String location, User organizer, List<User> attendees) {
        this.name = name;
        this.description = description;
        this.date = new Date(date.getTime()); // Safe copy
        this.location = location;
        this.organizer = organizer;
        this.attendees = attendees;
    }

    // Default constructor
    public Event() {
        // This is left intentionally blank. If you want to initialize default values, you can do it here.
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return new Date(date.getTime()); // Return a safe copy
    }

    public String getLocation() {
        return location;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime()); // Safe set
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}
