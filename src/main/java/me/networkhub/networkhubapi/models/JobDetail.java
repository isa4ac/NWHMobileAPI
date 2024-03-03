package me.networkhub.networkhubapi.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "job_Details")
public class JobDetail {
    @PrePersist
    private void ensureId(){
        this.setJobdetailIdPk("job-detail-" + UUID.randomUUID().toString());
    }

    @Id
    @Column(name = "jobDetail_Id_PK", nullable = false, length = 96)
    private String jobdetailIdPk;

    @Column(name = "jobDetail_Business_UserId_FK", nullable = false, length = 96)
    private String jobdetailBusinessUseridFk;

    @Column(name = "jobDetail_Engineer_UserId_FK", length = 96)
    private String jobdetailEngineerUseridFk;

    @Column(name = "jobDetail_Defined_Job_Status_FK", nullable = false, length = 96)
    private String jobdetailDefinedJobStatusFk;

    @Column(name = "jobDetail_Posted_DT")
    private Instant jobdetailPostedDt;

    @Lob
    @Column(name = "jobDetail_Title")
    private String jobdetailTitle;

    @Lob
    @Column(name = "jobDetail_Description_from_Business", columnDefinition = "LONGTEXT")
    private String jobdetailDescriptionFromBusiness;

    @Lob
    @Column(name = "jobDetail_Description_from_Engineer", columnDefinition = "LONGTEXT")
    private String jobdetailDescriptionFromEngineer;

    @Lob
    @Column(name = "jobDetail_Proposal_Target_Budget")
    private String jobdetailProposalTargetBudget;

    @Column(name = "jobDetail_Proposal_Target_Date")
    private Instant jobdetailProposalTargetDate;

    @Lob
    @Column(name = "jobDetail_Proposal_Agreed_Budget")
    private String jobdetailProposalAgreedBudget;

    @Column(name = "jobDetail_Proposal_Agreed_Date")
    private Instant jobdetailProposalAgreedDate;

    @Lob
    @Column(name = "jobDetail_Proposal_Final_Budget")
    private String jobdetailProposalFinalBudget;

    @Column(name = "jobDetail_Proposal_Final_Date")
    private Instant jobdetailProposalFinalDate;

    @Column(name = "jobDetail_is_Accepted_by_Business_Bool", nullable = false)
    private Boolean jobdetailIsAcceptedByBusinessBool = false;

    @Column(name = "jobDetail_is_Accepted_by_Business_DT")
    private Instant jobdetailIsAcceptedByBusinessDt;

    @Column(name = "jobDetail_is_Accepted_by_Engineer_Bool", nullable = false)
    private Boolean jobdetailIsAcceptedByEngineerBool = false;

    @Column(name = "jobDetail_is_Accepted_by_Engineer_DT")
    private Instant jobdetailIsAcceptedByEngineerDt;

    @Column(name = "jobDetail_is_Finished_by_Business_Bool", nullable = false)
    private Boolean jobdetailIsFinishedByBusinessBool = false;

    @Column(name = "jobDetail_is_Finished_by_Business_DT")
    private Instant jobdetailIsFinishedByBusinessDt;

    @Column(name = "jobDetail_is_Finished_by_Engineer_Bool", nullable = false)
    private Boolean jobdetailIsFinishedByEngineerBool = false;

    @Column(name = "jobDetail_is_Finished_by_Engineer_DT")
    private Instant jobdetailIsFinishedByEngineerDt;

    @Lob
    @Column(name = "jobDetail_Notes", columnDefinition = "LONGTEXT")
    private String jobdetailNotes;

    @Column(name = "jobDetail_is_Removed", nullable = false)
    private Integer jobdetailIsRemoved;

    public String getJobdetailIdPk() {
        return jobdetailIdPk;
    }

    public void setJobdetailIdPk(String jobdetailIdPk) {
        this.jobdetailIdPk = jobdetailIdPk;
    }

    public String getJobdetailBusinessUseridFk() {
        return jobdetailBusinessUseridFk;
    }

    public void setJobdetailBusinessUseridFk(String jobdetailBusinessUseridFk) {
        this.jobdetailBusinessUseridFk = jobdetailBusinessUseridFk;
    }

    public String getJobdetailEngineerUseridFk() {
        return jobdetailEngineerUseridFk;
    }

    public void setJobdetailEngineerUseridFk(String jobdetailEngineerUseridFk) {
        this.jobdetailEngineerUseridFk = jobdetailEngineerUseridFk;
    }

    public String getJobdetailDefinedJobStatusFk() {
        return jobdetailDefinedJobStatusFk;
    }

    public void setJobdetailDefinedJobStatusFk(String jobdetailDefinedJobStatusFk) {
        this.jobdetailDefinedJobStatusFk = jobdetailDefinedJobStatusFk;
    }

    public Instant getJobdetailPostedDt() {
        return jobdetailPostedDt;
    }

    public void setJobdetailPostedDt(Instant jobdetailPostedDt) {
        this.jobdetailPostedDt = jobdetailPostedDt;
    }

    public String getJobdetailTitle() {
        return jobdetailTitle;
    }

    public void setJobdetailTitle(String jobdetailTitle) {
        this.jobdetailTitle = jobdetailTitle;
    }

    public String getJobdetailDescriptionFromBusiness() {
        return jobdetailDescriptionFromBusiness;
    }

    public void setJobdetailDescriptionFromBusiness(String jobdetailDescriptionFromBusiness) {
        this.jobdetailDescriptionFromBusiness = jobdetailDescriptionFromBusiness;
    }

    public String getJobdetailDescriptionFromEngineer() {
        return jobdetailDescriptionFromEngineer;
    }

    public void setJobdetailDescriptionFromEngineer(String jobdetailDescriptionFromEngineer) {
        this.jobdetailDescriptionFromEngineer = jobdetailDescriptionFromEngineer;
    }

    public String getJobdetailProposalTargetBudget() {
        return jobdetailProposalTargetBudget;
    }

    public void setJobdetailProposalTargetBudget(String jobdetailProposalTargetBudget) {
        this.jobdetailProposalTargetBudget = jobdetailProposalTargetBudget;
    }

    public Instant getJobdetailProposalTargetDate() {
        return jobdetailProposalTargetDate;
    }

    public void setJobdetailProposalTargetDate(Instant jobdetailProposalTargetDate) {
        this.jobdetailProposalTargetDate = jobdetailProposalTargetDate;
    }

    public String getJobdetailProposalAgreedBudget() {
        return jobdetailProposalAgreedBudget;
    }

    public void setJobdetailProposalAgreedBudget(String jobdetailProposalAgreedBudget) {
        this.jobdetailProposalAgreedBudget = jobdetailProposalAgreedBudget;
    }

    public Instant getJobdetailProposalAgreedDate() {
        return jobdetailProposalAgreedDate;
    }

    public void setJobdetailProposalAgreedDate(Instant jobdetailProposalAgreedDate) {
        this.jobdetailProposalAgreedDate = jobdetailProposalAgreedDate;
    }

    public String getJobdetailProposalFinalBudget() {
        return jobdetailProposalFinalBudget;
    }

    public void setJobdetailProposalFinalBudget(String jobdetailProposalFinalBudget) {
        this.jobdetailProposalFinalBudget = jobdetailProposalFinalBudget;
    }

    public Instant getJobdetailProposalFinalDate() {
        return jobdetailProposalFinalDate;
    }

    public void setJobdetailProposalFinalDate(Instant jobdetailProposalFinalDate) {
        this.jobdetailProposalFinalDate = jobdetailProposalFinalDate;
    }

    public Boolean getJobdetailIsAcceptedByBusinessBool() {
        return jobdetailIsAcceptedByBusinessBool;
    }

    public void setJobdetailIsAcceptedByBusinessBool(Boolean jobdetailIsAcceptedByBusinessBool) {
        this.jobdetailIsAcceptedByBusinessBool = jobdetailIsAcceptedByBusinessBool;
    }

    public Instant getJobdetailIsAcceptedByBusinessDt() {
        return jobdetailIsAcceptedByBusinessDt;
    }

    public void setJobdetailIsAcceptedByBusinessDt(Instant jobdetailIsAcceptedByBusinessDt) {
        this.jobdetailIsAcceptedByBusinessDt = jobdetailIsAcceptedByBusinessDt;
    }

    public Boolean getJobdetailIsAcceptedByEngineerBool() {
        return jobdetailIsAcceptedByEngineerBool;
    }

    public void setJobdetailIsAcceptedByEngineerBool(Boolean jobdetailIsAcceptedByEngineerBool) {
        this.jobdetailIsAcceptedByEngineerBool = jobdetailIsAcceptedByEngineerBool;
    }

    public Instant getJobdetailIsAcceptedByEngineerDt() {
        return jobdetailIsAcceptedByEngineerDt;
    }

    public void setJobdetailIsAcceptedByEngineerDt(Instant jobdetailIsAcceptedByEngineerDt) {
        this.jobdetailIsAcceptedByEngineerDt = jobdetailIsAcceptedByEngineerDt;
    }

    public Boolean getJobdetailIsFinishedByBusinessBool() {
        return jobdetailIsFinishedByBusinessBool;
    }

    public void setJobdetailIsFinishedByBusinessBool(Boolean jobdetailIsFinishedByBusinessBool) {
        this.jobdetailIsFinishedByBusinessBool = jobdetailIsFinishedByBusinessBool;
    }

    public Instant getJobdetailIsFinishedByBusinessDt() {
        return jobdetailIsFinishedByBusinessDt;
    }

    public void setJobdetailIsFinishedByBusinessDt(Instant jobdetailIsFinishedByBusinessDt) {
        this.jobdetailIsFinishedByBusinessDt = jobdetailIsFinishedByBusinessDt;
    }

    public Boolean getJobdetailIsFinishedByEngineerBool() {
        return jobdetailIsFinishedByEngineerBool;
    }

    public void setJobdetailIsFinishedByEngineerBool(Boolean jobdetailIsFinishedByEngineerBool) {
        this.jobdetailIsFinishedByEngineerBool = jobdetailIsFinishedByEngineerBool;
    }

    public Instant getJobdetailIsFinishedByEngineerDt() {
        return jobdetailIsFinishedByEngineerDt;
    }

    public void setJobdetailIsFinishedByEngineerDt(Instant jobdetailIsFinishedByEngineerDt) {
        this.jobdetailIsFinishedByEngineerDt = jobdetailIsFinishedByEngineerDt;
    }

    public String getJobdetailNotes() {
        return jobdetailNotes;
    }

    public void setJobdetailNotes(String jobdetailNotes) {
        this.jobdetailNotes = jobdetailNotes;
    }

    public Integer getJobdetailIsRemoved() {
        return jobdetailIsRemoved;
    }

    public void setJobdetailIsRemoved(Integer jobdetailIsRemoved) {
        this.jobdetailIsRemoved = jobdetailIsRemoved;
    }

}