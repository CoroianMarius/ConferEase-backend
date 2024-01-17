package com.example.FirstTry.Repos;

import com.example.FirstTry.Entity.MyEventData;
import com.example.FirstTry.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyEventDataRepository extends JpaRepository<MyEventData, Integer> {

    //get the conferences of a user by email
    @Query("SELECT c FROM MyEventData c WHERE c.owner = :email OR :email MEMBER OF c.invitees")
    List<MyEventData> findConferencesByEmail(@Param("email") String email);

    //get the past conferences of a user by email
    @Query("SELECT c FROM MyEventData c WHERE c.end < CURRENT_DATE AND (c.owner = :email OR :email MEMBER OF c.invitees)")
    List<MyEventData> findPastConferencesByEmail(@Param("email") String email);

    @Query("SELECT c FROM MyEventData c WHERE c.start > CURRENT_DATE AND (c.owner = :email OR :email MEMBER OF c.invitees)")
    List<MyEventData> findFutureConferencesByEmail(@Param("email") String email);

    //get that returns the conferences of a department
    @Query("SELECT c FROM MyEventData c WHERE :department MEMBER OF c.departments")
    List<MyEventData> findConferencesByDepartment(@Param("department") String department);

    //get the public conferences
    @Query("SELECT c FROM MyEventData c WHERE c.isPublic = true")
    List<MyEventData> findPublicConferences();
}
