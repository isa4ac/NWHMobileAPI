package me.networkhub.networkhubapi.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import me.networkhub.networkhubapi.interfaces.JobDetailRepo;
import me.networkhub.networkhubapi.interfaces.UserRepo;
import me.networkhub.networkhubapi.models.Greeting;
import me.networkhub.networkhubapi.models.JobDetail;
import me.networkhub.networkhubapi.models.User;
import me.networkhub.networkhubapi.models.UserReviewStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JobDetailRepo jobRepo;

    // example call: localhost:8080/login?email
    @GetMapping("/login")
    public User login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        List<User> users = userRepo.findByUserdataPrimaryEmailAndUserdataPassword(email, password);
        return users.isEmpty() ? null : users.get(0);
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
}
