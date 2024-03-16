package me.networkhub.networkhubapi.interfaces;

import me.networkhub.networkhubapi.models.DefineTimezone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeZoneRepo extends JpaRepository<DefineTimezone, String> {

}
