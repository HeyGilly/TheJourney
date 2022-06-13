package com.journey.journeybookshelf.repository;

import com.journey.journeybookshelf.models.Reviews;
import com.journey.journeybookshelf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
//    Reviews findReviewByBookId(Long allBookTable);
//    Reviews findReviewByReviewTitle(String reviewTitle);

    //referenced to
    List<Reviews> findAllByUser(User user);
}
