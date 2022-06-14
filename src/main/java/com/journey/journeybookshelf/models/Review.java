package com.journey.journeybookshelf.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long rating;

    @Column(nullable = false, length = 100)
    private String reviewTitle;

    @Column(nullable = true, length = 2500)
    private String reviewBody;

    @ManyToOne
    @JoinColumn (name = "booklist_id")
    private AllBookTable allBookTable;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    //----- Constructor Empty
    public Review() {
    }
    //----- Constructor
    public Review(Long id, long rating, String reviewTitle, String reviewBody, AllBookTable allBookTable, User user) {
        this.id = id;
        this.rating = rating;
        this.reviewTitle = reviewTitle;
        this.reviewBody = reviewBody;
        this.allBookTable = allBookTable;
        this.user = user;
    }

    public Review(long rating, String reviewTitle, String reviewBody, AllBookTable allBookTable, User user) {
        this.rating = rating;
        this.reviewTitle = reviewTitle;
        this.reviewBody = reviewBody;
        this.allBookTable = allBookTable;
        this.user = user;
    }


    //----- GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public AllBookTable getAllBookTable() {
        return allBookTable;
    }

    public void setAllBookTable(AllBookTable allBookTable) {
        this.allBookTable = allBookTable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
