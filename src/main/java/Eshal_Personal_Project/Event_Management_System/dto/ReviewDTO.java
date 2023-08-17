package Eshal_Personal_Project.Event_Management_System.dto;

import Eshal_Personal_Project.Event_Management_System.model.Review;

public class ReviewDTO {
    private Long id;
    private int rating;
    private String comment;
    private UserDTO user;
    private EventDTO event;

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

    public UserDTO getUser() {
        return user;
    }

    public EventDTO getEvent() {
        return event;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public static ReviewDTO fromModel(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setUser(UserDTO.fromModel(review.getUser())); // Assuming you have fromModel in UserDTO
        dto.setEvent(EventDTO.fromModel(review.getEvent())); // Assuming you have fromModel in EventDTO
        return dto;
    }

    public Review toModel() {
        Review review = new Review("Great Event!", 5);
        review.setId(this.getId());
        review.setRating(this.getRating());
        review.setComment(this.getComment());
        review.setUser(this.user.toModel());  // Assuming you have toModel in UserDTO
        review.setEvent(this.event.toModel());  // Assuming you have toModel in EventDTO
        return review;
    }
}
