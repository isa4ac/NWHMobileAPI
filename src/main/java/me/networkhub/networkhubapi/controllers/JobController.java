package me.networkhub.networkhubapi.controllers;

import me.networkhub.networkhubapi.interfaces.JobDetailRepo;
import me.networkhub.networkhubapi.interfaces.UserRepo;
import me.networkhub.networkhubapi.models.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class JobController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JobDetailRepo jobRepo;

    @PostMapping("/postjob")
    public String postJob(@RequestParam(value = "business_user_id") String userId,
                        @RequestParam(value = "job_title") String title,
                        @RequestParam(value = "job_description") String description,
                        @RequestParam(value = "target_budget") String targetBudget,
                        @RequestParam(value = "target_date") Instant targetDate) {

        JobDetail job = new JobDetail();
        job.setJobdetailBusinessUseridFk(userId);
        job.setJobdetailDefinedJobStatusFk("job-status-open"); // since it is a new job; it should always have this value as a default
        job.setJobdetailTitle(title);
        job.setJobdetailDescriptionFromBusiness(description);
        job.setJobdetailProposalTargetBudget(targetBudget);
        job.setJobdetailProposalTargetDate(targetDate);
        job.setJobdetailIsRemoved(0);
        job.setJobdetailPostedDt(Instant.now());
        JobDetail savedJob = jobRepo.save(job);
        if (!savedJob.equals(null) && savedJob != null) {
            return "Success";
        } else {
            return "Failed to save job.";
        }
    }

    @PostMapping("/removejob")
    public String removeJob(@RequestParam(value = "id") String id) {
        try {
            jobRepo.deleteById(id);
            return "Success";
        } catch (DataAccessException ex) {
            return "Failed to remove job.";
        }
    }
}
