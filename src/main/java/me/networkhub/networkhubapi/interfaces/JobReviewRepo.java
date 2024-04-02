package me.networkhub.networkhubapi.interfaces;

import me.networkhub.networkhubapi.models.JobReview;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobReviewRepo extends JpaRepository<JobReview, String> {
    JobReview findJobReviewByJobreviewJobdetailIdFk(String jobId);
    List<JobReview> findJobReviewByJobreviewForEngineerUseridFk(String engId);
}
