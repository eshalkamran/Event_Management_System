package Eshal_Personal_Project.Event_Management_System.model;
import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private String content;

    //Constructor()
    public Review(String content, int rating) {
        this.rating = rating;
        this.content = content;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public String getContent() {
        return content;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setContent(String content) {
        this.content = content;
    }
}