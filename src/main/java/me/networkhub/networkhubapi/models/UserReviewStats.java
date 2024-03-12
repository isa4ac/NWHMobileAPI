package me.networkhub.networkhubapi.models;

import java.time.Instant;

public class UserReviewStats {
    private String id;
    private String firstName;
    private String lastName;
    private String timeZone;
    private Double experience;
    private Long jobsDone;
    private Double avgReview;
    private String bio;

    public UserReviewStats(String id,String firstName, String lastName, String timeZone, Double experience, Long jobsDone, Double avgReview, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeZone = timeZone;
        this.experience = experience;
        this.jobsDone = jobsDone;
        this.avgReview = avgReview;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
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