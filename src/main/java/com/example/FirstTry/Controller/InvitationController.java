package com.example.FirstTry.Controller;

import com.example.FirstTry.Entity.Invitation;
import com.example.FirstTry.Repos.InvitationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "api/invite/")
public class InvitationController {
    public final InvitationRepository invitationRepository;
    public InvitationController(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    //put that updates the status of the invitation
    @PutMapping("/update")
    public ResponseEntity<?> updateInvitation(@RequestBody Invitation updateInfo) {
        List<Invitation> invitations = invitationRepository.findByMeetIdAndEmail(updateInfo.getMeetId(), updateInfo.getEmail());

        if (invitations.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invitation not found");
        }

        // Assuming we update the first matching invitation
        Invitation invitationToUpdate = invitations.get(0);
        invitationToUpdate.setStatusId(updateInfo.getStatusId());
        invitationRepository.save(invitationToUpdate);

        return ResponseEntity.ok().build();
    }
}
