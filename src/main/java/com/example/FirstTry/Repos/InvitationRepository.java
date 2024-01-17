package com.example.FirstTry.Repos;

import com.example.FirstTry.Entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {
    //update the status of the invitation
    @Query("UPDATE Invitation i SET i.statusId = :id WHERE i.id = :Id")
    void updateInvitation(int Id);

    //find the invitation by email and meetId
    @Query("SELECT i FROM Invitation i WHERE i.email = :email AND i.meetId = :meetId")
    List<Invitation> findByMeetIdAndEmail(int meetId, String email);
}
