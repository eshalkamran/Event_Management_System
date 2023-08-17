package Eshal_Personal_Project.Event_Management_System.service;
import Eshal_Personal_Project.Event_Management_System.model.Review;
import Eshal_Personal_Project.Event_Management_System.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review addReview(Review newReview) {
        return reviewRepository.save(newReview);
    }
}
