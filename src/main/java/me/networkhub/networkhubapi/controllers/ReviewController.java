package me.networkhub.networkhubapi.controllers;

import me.networkhub.networkhubapi.interfaces.JobReviewRepo;
import me.networkhub.networkhubapi.models.JobReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ReviewController {
    @Autowired
    JobReviewRepo jobReviewRepo;

    @GetMapping("/getEngineerReviews")
    public List<JobReview> getEngineerReviews(@RequestParam(value = "userId") String userId) {
        return jobReviewRepo.findJobReviewByJobreviewForEngineerUseridFk(userId);
    }

    @PostMapping("/addBusinessJobReview")
    public void addBusinessJobReview(@RequestParam(value = "jobId") String jobId,
                                     @RequestParam(value = "businessId") String bId,
                                     @RequestParam(value = "engineerId") String eId,
                                     @RequestParam(value = "rating") Integer rating,
                                     @RequestParam(value = "reviewText") String reviewText) {
        JobReview existingReview = jobReviewRepo.findJobReviewByJobreviewJobdetailIdFk(jobId);
        // determine if there is a review for the job already
        if (existingReview != null) {
            // if so: update
            existingReview.setJobreviewForEngineerRating(rating);
            existingReview.setJobreviewForEngineerText(reviewText);
            existingReview.setJobreviewForEngineerPostedDt(Instant.now());
            jobReviewRepo.save(existingReview);
        } else {
            // if not: insert
            JobReview newReview = new JobReview();
            newReview.setJobreviewJobdetailIdFk(jobId);
            newReview.setJobreviewForBusinessUseridFk(bId);
            newReview.setJobreviewForEngineerUseridFk(eId);
            newReview.setJobreviewForEngineerRating(rating);
            newReview.setJobreviewForEngineerText(reviewText);
            newReview.setJobreviewForEngineerPostedDt(Instant.now());
            jobReviewRepo.save(newReview);
        }
    }
}
