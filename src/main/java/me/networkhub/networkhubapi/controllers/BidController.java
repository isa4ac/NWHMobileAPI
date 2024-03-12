package me.networkhub.networkhubapi.controllers;

import me.networkhub.networkhubapi.interfaces.JobBidRepo;
import me.networkhub.networkhubapi.interfaces.JobDetailRepo;
import me.networkhub.networkhubapi.interfaces.UserRepo;
import me.networkhub.networkhubapi.models.JobBid;
import me.networkhub.networkhubapi.models.JobBidStats;
import me.networkhub.networkhubapi.models.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class BidController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JobBidRepo jobBidRepo;

    @GetMapping("/jobbids")
    public List<JobBidStats> getJobBids(@RequestParam(value = "job_id") String job_id) {
        return jobBidRepo.findBidsByJobId_Named(job_id);
    }
}
