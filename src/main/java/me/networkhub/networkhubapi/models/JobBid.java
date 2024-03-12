package me.networkhub.networkhubapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
// Named Query for getting an job bids and bidder stats:
@NamedNativeQuery (name = "JobBid.findBidsByJobId_Named",
        query = """
                    SELECT
                        jb1_0.jobBid_Id_PK as id,
                        jb1_0.jobBid_Engineer_UserId_FK as engineerId,
                        jb1_0.jobBid_jobDetail_Id_FK as jobId,
                        jb1_0.jobBid_Posted_DT as postDate,
                        jb1_0.jobBid_Proposal_from_Engineer as propFromEng,
                        jb1_0.jobBid_Proposed_Amount as propAmount,
                        COALESCE(jd_completed.CompletedJobs, 0) as jobsDone,
                        AVG(jr.jobReview_for_Engineer_Rating) as avgReview,
                        ROUND(DATEDIFF(ud.userData_Experience_Start, CURDATE())/-365, 1) as experience,
                        ud.userData_Name_First as firstName,
                        ud.userData_Name_Last as lastName,
                        ud.userData_Profile_Description as bio
                    FROM
                        job_Bids jb1_0
                            LEFT JOIN job_Reviews jr ON jb1_0.jobBid_Engineer_UserId_FK = jr.jobReview_for_Engineer_UserId_FK
                            LEFT JOIN (
                            SELECT
                                jobDetail_Engineer_UserId_FK,
                                COUNT(*) as CompletedJobs
                            FROM
                                job_Details
                            WHERE
                                jobDetail_Defined_Job_Status_FK = 'job-status-closed'
                            GROUP BY
                                jobDetail_Engineer_UserId_FK
                        ) as jd_completed ON jb1_0.jobBid_Engineer_UserId_FK = jd_completed.jobDetail_Engineer_UserId_FK
                            LEFT JOIN user_Data ud on jb1_0.jobBid_Engineer_UserId_FK = ud.userData_Id_PK
                    WHERE
                        jb1_0.jobBid_jobDetail_Id_FK = 'job-detail-e3b1ea91-dfd0-4a53-a2dc-98668d8faa5c'
                    GROUP BY
                        jb1_0.jobBid_Id_PK, jb1_0.jobBid_Engineer_UserId_FK, jb1_0.jobBid_Experience_Start,
                        jb1_0.jobBid_jobDetail_Id_FK, jb1_0.jobBid_Posted_DT, jb1_0.jobBid_Proposal_from_Engineer,
                        jb1_0.jobBid_Proposed_Amount, jd_completed.CompletedJobs
                """,
        resultSetMapping = "Mapping.JobBidStats")
@SqlResultSetMapping(name = "Mapping.JobBidStats",
        classes = @ConstructorResult(targetClass = JobBidStats.class,
                columns = {
                        @ColumnResult (name = "id"),
                        @ColumnResult (name = "engineerId"),
                        @ColumnResult(name = "jobId"),
                        @ColumnResult(name = "postDate", type=Instant.class),
                        @ColumnResult(name = "propFromEng"),
                        @ColumnResult(name = "propAmount", type=Double.class),
                        @ColumnResult (name = "jobsDone", type=Long.class),
                        @ColumnResult (name = "avgReview", type=Double.class),
                        @ColumnResult (name = "experience", type=Double.class),
                        @ColumnResult(name = "firstName"),
                        @ColumnResult(name = "lastName"),
                        @ColumnResult(name = "bio")
                }))
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