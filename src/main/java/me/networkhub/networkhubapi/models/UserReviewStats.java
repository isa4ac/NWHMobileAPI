package me.networkhub.networkhubapi.models;

import java.time.Instant;

public class UserReviewStats {
    private String firstName;
    private String lastName;
    private Instant experienceStart;
    private Long jobsDone;
    private Double avgReview;
    private String bio;

    public UserReviewStats(String firstName, String lastName, Instant experienceStart, Long jobsDone, Double avgReview, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceStart = experienceStart;
        this.jobsDone = jobsDone;
        this.avgReview = avgReview;
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getExperienceStart() {
        return experienceStart;
    }

    public void setExperienceStart(Instant experienceStart) {
        this.experienceStart = experienceStart;
    }

    public Long getJobsDone() {
        return jobsDone;
    }

    public void setJobsDone(Long jobsDone) {
        this.jobsDone = jobsDone;
    }

    public Double getAvgReview() {
        return avgReview;
    }

    public void setAvgReview(Double avgReview) {
        this.avgReview = avgReview;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}