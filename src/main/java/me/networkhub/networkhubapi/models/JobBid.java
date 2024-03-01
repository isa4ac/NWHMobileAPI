package me.networkhub.networkhubapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "job_Bids")
public class JobBid {
    @Id
    @Column(name = "jobBid_Id_PK", nullable = false, length = 96)
    private String jobbidIdPk;

    @Column(name = "jobBid_jobDetail_Id_FK", nullable = false, length = 96)
    private String jobbidJobdetailIdFk;

    @Column(name = "jobBid_Engineer_UserId_FK", nullable = false, length = 96)
    private String jobbidEngineerUseridFk;

    @Column(name = "jobBid_Posted_DT")
    private Instant jobbidPostedDt;

    @Lob
    @Column(name = "jobBid_Proposal_from_Engineer", columnDefinition = "LONGTEXT")
    private String jobbidProposalFromEngineer;

    @Column(name = "jobBid_Proposed_Amount", precision = 10, scale = 2)
    private BigDecimal jobbidProposedAmount;

    @Column(name = "jobBid_Experience_Start")
    private Instant jobbidExperienceStart;

    public String getJobbidIdPk() {
        return jobbidIdPk;
    }

    public void setJobbidIdPk(String jobbidIdPk) {
        this.jobbidIdPk = jobbidIdPk;
    }

    public String getJobbidJobdetailIdFk() {
        return jobbidJobdetailIdFk;
    }

    public void setJobbidJobdetailIdFk(String jobbidJobdetailIdFk) {
        this.jobbidJobdetailIdFk = jobbidJobdetailIdFk;
    }

    public String getJobbidEngineerUseridFk() {
        return jobbidEngineerUseridFk;
    }

    public void setJobbidEngineerUseridFk(String jobbidEngineerUseridFk) {
        this.jobbidEngineerUseridFk = jobbidEngineerUseridFk;
    }

    public Instant getJobbidPostedDt() {
        return jobbidPostedDt;
    }

    public void setJobbidPostedDt(Instant jobbidPostedDt) {
        this.jobbidPostedDt = jobbidPostedDt;
    }

    public String getJobbidProposalFromEngineer() {
        return jobbidProposalFromEngineer;
    }

    public void setJobbidProposalFromEngineer(String jobbidProposalFromEngineer) {
        this.jobbidProposalFromEngineer = jobbidProposalFromEngineer;
    }

    public BigDecimal getJobbidProposedAmount() {
        return jobbidProposedAmount;
    }

    public void setJobbidProposedAmount(BigDecimal jobbidProposedAmount) {
        this.jobbidProposedAmount = jobbidProposedAmount;
    }

    public Instant getJobbidExperienceStart() {
        return jobbidExperienceStart;
    }

    public void setJobbidExperienceStart(Instant jobbidExperienceStart) {
        this.jobbidExperienceStart = jobbidExperienceStart;
    }

}