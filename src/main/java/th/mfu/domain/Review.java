package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewer;
    private String content;
    private int rating;

    // Constructors
    public Review() {}

    public Review(String reviewer, String content, int rating) {
        this.reviewer = reviewer;
        this.content = content;
        this.rating = rating;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

