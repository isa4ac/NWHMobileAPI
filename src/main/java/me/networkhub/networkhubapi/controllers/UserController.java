package me.networkhub.networkhubapi.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import me.networkhub.networkhubapi.interfaces.JobDetailRepo;
import me.networkhub.networkhubapi.interfaces.TimeZoneRepo;
import me.networkhub.networkhubapi.interfaces.UserRepo;
import me.networkhub.networkhubapi.models.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JobDetailRepo jobRepo;
    @Autowired
    TimeZoneRepo timeZoneRepo;

    // example call: localhost:8080/login?email
    @GetMapping("/login")
    public User login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        List<User> users = userRepo.findByUserdataPrimaryEmailAndUserdataPassword(email, password);
        return users.isEmpty() ? new User() : users.get(0);
    }
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    @GetMapping("/engProf")
    public UserReviewStats getEngineerProfile(@RequestParam(value = "id") String id) {
        return userRepo.findUserReviewStatsById_Named(id);
    }
    @GetMapping("/businessJobs")
    public List<JobDetail> getBusinessJobs(@RequestParam(value = "id") String id) {
        return jobRepo.findJobDetailByJobdetailBusinessUseridFk(id);
    }
    @PostMapping("/updateprofile")
    public String updateJob(@RequestParam(value = "user_id") String jobId,
                            @RequestParam(value = "business_name") String bName,
                            @RequestParam(value = "bio") String description) {

        User user = userRepo.getReferenceById(jobId);
        user.setUserdataNameBusiness(bName);
        user.setUserdataProfileDescription(description);
        User savedUser = userRepo.save(user);
        if (!savedUser.equals(null) && savedUser != null) {
            return "Success";
        } else {
            return "Failed to save job.";
        }
    }
    @PostMapping("/business_signup")
    public User businessSignup(@RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "first_name") String firstName,
                                 @RequestParam(value = "last_name") String lastName,
                                 @RequestParam(value = "time_zone") String timeZone,
                                 @RequestParam(value = "business_name") String businessName,
                                 @RequestParam(value = "business_location") String businessLocation,
                                 @RequestParam(value = "bio") String bio) {
        User user = new User();

        if (userRepo.getByUserdataPrimaryEmail(email) != null) {
            return new User();
        }

        user.setUserdataDefineRoleIdFk("role-business");
        user.setUserdataPrimaryEmail(email);
        user.setUserdataPassword(password);
        user.setUserdataNameFirst(firstName);
        user.setUserdataNameLast(lastName);
        user.setUserdataTimezone(timeZone);
        user.setUserdataNameBusiness(businessName);
        user.setUserdataProfileDescription(bio);
        user.setUserdataBusinessLocation(businessLocation);
        user.setUserdataIsEnabled(true);
        user.setUserdataDtAdded(Instant.now());

        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @GetMapping("/gettimezones")
    public List<DefineTimezone> getTimeZones() {
        return timeZoneRepo.findAll();
    }
}
