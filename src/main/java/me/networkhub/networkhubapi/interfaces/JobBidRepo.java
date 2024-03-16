package me.networkhub.networkhubapi.interfaces;

import me.networkhub.networkhubapi.models.JobBid;
import me.networkhub.networkhubapi.models.JobBidStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobBidRepo extends JpaRepository<JobBid, String> {
    @Query(nativeQuery = true)
    List<JobBidStats> findBidsByJobId_Named(String job_id);
    @Modifying
    List<JobBid> deleteByJobbidJobdetailIdFk(String job_id);
}
