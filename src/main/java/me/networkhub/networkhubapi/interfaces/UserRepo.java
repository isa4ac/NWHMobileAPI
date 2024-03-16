package me.networkhub.networkhubapi.interfaces;

import me.networkhub.networkhubapi.models.User;
import me.networkhub.networkhubapi.models.UserReviewStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.userdataPrimaryEmail = ?1 AND u.userdataPassword = ?2")
    List<User> findByUserdataPrimaryEmailAndUserdataPassword(String userDataPrimaryEmail, String userDataPassword);
    List<User> findAll();
    User getByUserdataPrimaryEmail(String primaryEmail);
    @Query(nativeQuery = true)
    UserReviewStats findUserReviewStatsById_Named(String id);
}
