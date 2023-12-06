package com.example.FirstTry.Repos;

import com.example.FirstTry.Entity.Conference;
import com.example.FirstTry.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
}
