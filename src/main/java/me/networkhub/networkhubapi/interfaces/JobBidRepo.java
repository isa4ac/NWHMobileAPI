package me.networkhub.networkhubapi.interfaces;

import me.networkhub.networkhubapi.models.JobBid;
import me.networkhub.networkhubapi.models.JobBidStats;
import me.networkhub.networkhubapi.models.JobDetail;
import me.networkhub.networkhubapi.models.UserReviewStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobBidRepo extends JpaRepository<JobBid, String> {
    List<JobBid> getAllByJobbidJobdetailIdFk(String job_id);
    @Query(nativeQuery = true)
    List<JobBidStats> findBidsByJobId_Named(String job_id);
}
