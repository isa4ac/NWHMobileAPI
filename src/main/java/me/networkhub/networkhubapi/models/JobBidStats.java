package me.networkhub.networkhubapi.models;

import java.time.Instant;

public class JobBidStats {
    private String id;
    private String engineerId;
    private String jobId;
    private Instant postDate;
    private String propFromEng;
    private Double propAmount;
    private Long jobsDone;
    private Double avgReview;
    private Double experience;
    private String firstName;
    private String lastName;
    private String bio;
    // profile pic

    public JobBidStats(String id, String engineerId, String jobId, Instant postDate, String propFromEng, Double propAmount, Long jobsDone, Double avgReview, Double experience, String firstName, String lastName, String bio) {
        this.id = id;
        this.engineerId = engineerId;
        this.jobId = jobId;
        this.postDate = postDate;
        this.propFromEng = propFromEng;
        this.propAmount = propAmount;
        this.jobsDone = jobsDone;
        this.avgReview = avgReview;
        this.experience = experience;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(String engineerId) {
        this.engineerId = engineerId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public String getPropFromEng() {
        return propFromEng;
    }

    public void setPropFromEng(String propFromEng) {
        this.propFromEng = propFromEng;
    }

    public Double getPropAmount() {
        return propAmount;
    }

    public void setPropAmount(Double propAmount) {
        this.propAmount = propAmount;
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

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}