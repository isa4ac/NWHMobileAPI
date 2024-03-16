package me.networkhub.networkhubapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

// Named Query for getting an engineer's profile:
@NamedNativeQuery (name = "User.findUserReviewStatsById_Named",
        query = """
                    SELECT
                        ud.userData_Id_PK as id,
                        ud.userData_Name_First as firstName,
                        ud.userData_Name_Last as lastName,
                        ud.userData_Timezone as timeZone,
                        ROUND(DATEDIFF(ud.userData_Experience_Start, CURDATE())/-365, 1) as experience,
                        AVG(jr.jobReview_for_Engineer_Rating) as avgReview,
                        COALESCE(cj.CompletedJobs, 0) as jobsDone,
                        ud.userData_Profile_Description as bio
                    FROM
                        user_Data ud
                        LEFT JOIN job_Reviews jr ON ud.userData_Id_PK = jr.jobReview_for_Engineer_UserId_FK
                        LEFT JOIN (
                            SELECT
                                jd2.jobDetail_Engineer_UserId_FK,\s
                                COUNT(*) as CompletedJobs
                            FROM
                                job_Details jd2
                            WHERE
                                jd2.jobDetail_Defined_Job_Status_FK = 'job-status-closed'
                            GROUP BY
                                jd2.jobDetail_Engineer_UserId_FK
                        ) as cj ON ud.userData_Id_PK = cj.jobDetail_Engineer_UserId_FK
                    WHERE
                        ud.userData_Id_PK = :id
                    GROUP BY
                        ud.userData_Id_PK,
                        ud.userData_Name_First,
                        ud.userData_Name_Last,
                        ud.userData_Timezone,
                        ud.userData_Experience_Start,
                        ud.userData_Profile_Description
                """,
        resultSetMapping = "Mapping.UserReviewStats")
@SqlResultSetMapping(name = "Mapping.UserReviewStats",
                classes = @ConstructorResult(targetClass = UserReviewStats.class,
                    columns = {
                            @ColumnResult (name = "id"),
                            @ColumnResult (name = "firstName"),
                            @ColumnResult(name = "lastName"),
                            @ColumnResult(name = "timeZone"),
                            @ColumnResult (name = "experience", type=Double.class),
                            @ColumnResult (name = "jobsDone", type=Long.class),
                            @ColumnResult (name = "avgReview", type=Double.class),
                            @ColumnResult (name = "bio")
                    }))

@Entity
@Table(name = "user_Data")
public class User {
    @PrePersist
    private void ensureId(){
        this.setUserdataIdPk("user-data-" + UUID.randomUUID().toString());
    }

    @Id
    @Column(name = "userData_Id_PK", nullable = false, length = 96)
    private String userdataIdPk;

    @Column(name = "userData_Define_Role_Id_FK", nullable = false, length = 96)
    private String userdataDefineRoleIdFk;

    @Lob
    @Column(name = "userData_Timezone")
    private String userdataTimezone;

    @Lob
    @Column(name = "userData_Primary_Email", nullable = false)
    private String userdataPrimaryEmail;

    @Lob
    @Column(name = "userData_Password", nullable = false)
    private String userdataPassword;

    @Lob
    @Column(name = "userData_Name_Preferred")
    private String userdataNamePreferred;

    @Lob
    @Column(name = "userData_Name_First")
    private String userdataNameFirst;

    @Lob
    @Column(name = "userData_Name_Last")
    private String userdataNameLast;

    @Lob
    @Column(name = "userData_Name_Business")
    private String userdataNameBusiness;

    @Lob
    @Column(name = "userData_Profile_Description", columnDefinition = "LONGTEXT")
    private String userdataProfileDescription;

    @Column(name = "userData_is_Enabled", nullable = false)
    private Boolean userdataIsEnabled = false;

    @Column(name = "userData_DT_Added")
    private Instant userdataDtAdded;

    @Column(name = "userData_Rating_Average_Calc", precision = 3, scale = 2)
    private BigDecimal userdataRatingAverageCalc;

    @Column(name = "userData_Rating_Average_DT")
    private Instant userdataRatingAverageDt;

    @Column(name = "userData_Jobs_Complted_Calc")
    private Short userdataJobsCompltedCalc;

    @Column(name = "userData_Jobs_Complted_DT")
    private Instant userdataJobsCompltedDt;

    @Lob
    @Column(name = "userData_Notes", columnDefinition = "LONGTEXT")
    private String userdataNotes;

    @Column(name = "userData_Experience_Start")
    private Instant userdataExperienceStart;

    @Column(name = "userData_Business_Location")
    private String userdataBusinessLocation;

    public String getUserdataIdPk() {
        return userdataIdPk;
    }

    public void setUserdataIdPk(String userdataIdPk) {
        this.userdataIdPk = userdataIdPk;
    }

    public String getUserdataDefineRoleIdFk() {
        return userdataDefineRoleIdFk;
    }

    public void setUserdataDefineRoleIdFk(String userdataDefineRoleIdFk) {
        this.userdataDefineRoleIdFk = userdataDefineRoleIdFk;
    }

    public String getUserdataTimezone() {
        return userdataTimezone;
    }

    public void setUserdataTimezone(String userdataTimezone) {
        this.userdataTimezone = userdataTimezone;
    }

    public String getUserdataPrimaryEmail() {
        return userdataPrimaryEmail;
    }

    public void setUserdataPrimaryEmail(String userdataPrimaryEmail) {
        this.userdataPrimaryEmail = userdataPrimaryEmail;
    }

    public String getUserdataPassword() {
        return userdataPassword;
    }

    public void setUserdataPassword(String userdataPassword) {
        this.userdataPassword = userdataPassword;
    }

    public String getUserdataNamePreferred() {
        return userdataNamePreferred;
    }

    public void setUserdataNamePreferred(String userdataNamePreferred) {
        this.userdataNamePreferred = userdataNamePreferred;
    }

    public String getUserdataNameFirst() {
        return userdataNameFirst;
    }

    public void setUserdataNameFirst(String userdataNameFirst) {
        this.userdataNameFirst = userdataNameFirst;
    }

    public String getUserdataNameLast() {
        return userdataNameLast;
    }

    public void setUserdataNameLast(String userdataNameLast) {
        this.userdataNameLast = userdataNameLast;
    }

    public String getUserdataNameBusiness() {
        return userdataNameBusiness;
    }

    public void setUserdataNameBusiness(String userdataNameBusiness) {
        this.userdataNameBusiness = userdataNameBusiness;
    }

    public String getUserdataProfileDescription() {
        return userdataProfileDescription;
    }

    public void setUserdataProfileDescription(String userdataProfileDescription) {
        this.userdataProfileDescription = userdataProfileDescription;
    }

    public Boolean getUserdataIsEnabled() {
        return userdataIsEnabled;
    }

    public void setUserdataIsEnabled(Boolean userdataIsEnabled) {
        this.userdataIsEnabled = userdataIsEnabled;
    }

    public Instant getUserdataDtAdded() {
        return userdataDtAdded;
    }

    public void setUserdataDtAdded(Instant userdataDtAdded) {
        this.userdataDtAdded = userdataDtAdded;
    }

    public BigDecimal getUserdataRatingAverageCalc() {
        return userdataRatingAverageCalc;
    }

    public void setUserdataRatingAverageCalc(BigDecimal userdataRatingAverageCalc) {
        this.userdataRatingAverageCalc = userdataRatingAverageCalc;
    }

    public Instant getUserdataRatingAverageDt() {
        return userdataRatingAverageDt;
    }

    public void setUserdataRatingAverageDt(Instant userdataRatingAverageDt) {
        this.userdataRatingAverageDt = userdataRatingAverageDt;
    }

    public Short getUserdataJobsCompltedCalc() {
        return userdataJobsCompltedCalc;
    }

    public void setUserdataJobsCompltedCalc(Short userdataJobsCompltedCalc) {
        this.userdataJobsCompltedCalc = userdataJobsCompltedCalc;
    }

    public Instant getUserdataJobsCompltedDt() {
        return userdataJobsCompltedDt;
    }

    public void setUserdataJobsCompltedDt(Instant userdataJobsCompltedDt) {
        this.userdataJobsCompltedDt = userdataJobsCompltedDt;
    }

    public String getUserdataNotes() {
        return userdataNotes;
    }

    public void setUserdataNotes(String userdataNotes) {
        this.userdataNotes = userdataNotes;
    }

    public Instant getUserdataExperienceStart() {
        return userdataExperienceStart;
    }

    public void setUserdataExperienceStart(Instant userdataExperienceStart) {
        this.userdataExperienceStart = userdataExperienceStart;
    }

    public String getUserdataBusinessLocation() {
        return userdataBusinessLocation;
    }

    public void setUserdataBusinessLocation(String userdataBusinessLocation) {
        this.userdataBusinessLocation = userdataBusinessLocation;
    }
}