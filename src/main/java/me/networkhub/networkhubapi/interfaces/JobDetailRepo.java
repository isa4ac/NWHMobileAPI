package me.networkhub.networkhubapi.interfaces;

import me.networkhub.networkhubapi.models.JobDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobDetailRepo extends JpaRepository<JobDetail, String> {
    List<JobDetail> findJobDetailByJobdetailBusinessUseridFk(String id);
    Boolean deleteByJobdetailIdPk(String id);
    JobDetail getByJobdetailIdPk(String id);
}
