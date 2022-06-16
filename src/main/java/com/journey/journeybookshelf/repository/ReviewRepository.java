package com.journey.journeybookshelf.repository;

import com.journey.journeybookshelf.models.Review;
import com.journey.journeybookshelf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//    Reviews findReviewByBookId(Long allBookTable);
//    Reviews findReviewByReviewTitle(String reviewTitle);

    //referenced to
    List<Review> findAllByUser(User user);

    Review findById(long id);
}
