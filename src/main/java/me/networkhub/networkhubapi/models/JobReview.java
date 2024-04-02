package me.networkhub.networkhubapi.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "job_Reviews")
public class JobReview {
    @PrePersist
    private void ensureId(){
        this.setJobreviewIdPk("job-review-" + UUID.randomUUID().toString());
    }

    @Id
    @Column(name = "jobReview_Id_PK", nullable = false, length = 96)
    private String jobreviewIdPk;

    @Column(name = "jobReview_jobDetail_Id_FK", nullable = false, length = 96)
    private String jobreviewJobdetailIdFk;

    @Column(name = "jobReview_for_Business_UserId_FK", length = 96)
    private String jobreviewForBusinessUseridFk;

    @Column(name = "jobReview_for_Business_Posted_DT")
    private Instant jobreviewForBusinessPostedDt;

    @Column(name = "jobReview_for_Business_Rating", columnDefinition = "INTEGER(11,0)")
    private Integer jobreviewForBusinessRating;

    @Lob
    @Column(name = "jobReview_for_Business_Text", columnDefinition = "LONGTEXT")
    private String jobreviewForBusinessText;

    @Column(name = "jobReview_for_Engineer_UserId_FK", length = 96)
    private String jobreviewForEngineerUseridFk;

    @Column(name = "jobReview_for_Engineer_Posted_DT")
    private Instant jobreviewForEngineerPostedDt;

    @Column(name = "jobReview_for_Engineer_Rating")
    private Integer jobreviewForEngineerRating;

    @Lob
    @Column(name = "jobReview_for_Engineer_Text", columnDefinition = "LONGTEXT")
    private String jobreviewForEngineerText;

    @Lob
    @Column(name = "jobReview_Notes", columnDefinition = "LONGTEXT")
    private String jobreviewNotes;

    public String getJobreviewIdPk() {
        return jobreviewIdPk;
    }

    public void setJobreviewIdPk(String jobreviewIdPk) {
        this.jobreviewIdPk = jobreviewIdPk;
    }

    public String getJobreviewJobdetailIdFk() {
        return jobreviewJobdetailIdFk;
    }

    public void setJobreviewJobdetailIdFk(String jobreviewJobdetailIdFk) {
        this.jobreviewJobdetailIdFk = jobreviewJobdetailIdFk;
    }

    public String getJobreviewForBusinessUseridFk() {
        return jobreviewForBusinessUseridFk;
    }

    public void setJobreviewForBusinessUseridFk(String jobreviewForBusinessUseridFk) {
        this.jobreviewForBusinessUseridFk = jobreviewForBusinessUseridFk;
    }

    public Instant getJobreviewForBusinessPostedDt() {
        return jobreviewForBusinessPostedDt;
    }

    public void setJobreviewForBusinessPostedDt(Instant jobreviewForBusinessPostedDt) {
        this.jobreviewForBusinessPostedDt = jobreviewForBusinessPostedDt;
    }

    public Integer getJobreviewForBusinessRating() {
        return jobreviewForBusinessRating;
    }

    public void setJobreviewForBusinessRating(Integer jobreviewForBusinessRating) {
        this.jobreviewForBusinessRating = jobreviewForBusinessRating;
    }

    public String getJobreviewForBusinessText() {
        return jobreviewForBusinessText;
    }

    public void setJobreviewForBusinessText(String jobreviewForBusinessText) {
        this.jobreviewForBusinessText = jobreviewForBusinessText;
    }

    public String getJobreviewForEngineerUseridFk() {
        return jobreviewForEngineerUseridFk;
    }

    public void setJobreviewForEngineerUseridFk(String jobreviewForEngineerUseridFk) {
        this.jobreviewForEngineerUseridFk = jobreviewForEngineerUseridFk;
    }

    public Instant getJobreviewForEngineerPostedDt() {
        return jobreviewForEngineerPostedDt;
    }

    public void setJobreviewForEngineerPostedDt(Instant jobreviewForEngineerPostedDt) {
        this.jobreviewForEngineerPostedDt = jobreviewForEngineerPostedDt;
    }

    public Integer getJobreviewForEngineerRating() {
        return jobreviewForEngineerRating;
    }

    public void setJobreviewForEngineerRating(Integer jobreviewForEngineerRating) {
        this.jobreviewForEngineerRating = jobreviewForEngineerRating;
    }

    public String getJobreviewForEngineerText() {
        return jobreviewForEngineerText;
    }

    public void setJobreviewForEngineerText(String jobreviewForEngineerText) {
        this.jobreviewForEngineerText = jobreviewForEngineerText;
    }

    public String getJobreviewNotes() {
        return jobreviewNotes;
    }

    public void setJobreviewNotes(String jobreviewNotes) {
        this.jobreviewNotes = jobreviewNotes;
    }

}