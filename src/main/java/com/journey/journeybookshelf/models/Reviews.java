package com.journey.journeybookshelf.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 6)
    private int ratings;

    @Column(nullable = true, length = 100)
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
    public Reviews() {
    }
    //----- Constructor
    public Reviews(Long id, int ratings, String reviewTitle, String reviewBody, AllBookTable allBookTable, User user) {
        this.id = id;
        this.ratings = ratings;
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

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
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
