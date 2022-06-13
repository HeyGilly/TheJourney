package com.journey.journeybookshelf.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BookList")
public class AllBookTable {

    @Id
    @Column(name="BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="ISBN",nullable = false, length = 50)
    private String isbn;

    @Column(name="BOOK_TITLE",nullable = false, length = 100)
    private String title;

    @Column(name="AUTHOR",nullable = false, length = 100)
    private String author;

    @Column(name="BOOK_COVER", nullable = false)
    private String bookImage;

    @Column(name="DESCRIPTION",nullable = false, length = 2500)
    private String description;

    @Column(name="GENRE",nullable = false, length = 50)
    private String genre;

    @Column(name="PAGE_COUNT",nullable = false, length = 8)
    private Long pageCount;

    @Column(name="PUBLISHED_DATE", nullable = false)
    private String publishedDate;

    @Column(name="RATING",nullable = false, length = 6)
    private Integer rating;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "allBookTable")
    private List<Reviews> reviews;

    //----- Empty Constructor
    public AllBookTable() {
    }
    //----- Constructor
    public AllBookTable(long id, String isbn, String title, String author, String bookImage, String description, Long pageCount, String publishedDate, Integer rating, List<Reviews> reviews) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.bookImage = bookImage;
        this.description = description;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
        this.rating = rating;
        this.reviews = reviews;
    }
//----- Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
}
