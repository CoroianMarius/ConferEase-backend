package com.example.FirstTry.Controller;

import com.example.FirstTry.Entity.Invitation;
import com.example.FirstTry.Entity.MyEventData;
import com.example.FirstTry.Entity.User;
import com.example.FirstTry.Repos.InvitationRepository;
import com.example.FirstTry.Repos.MyEventDataRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "api/conference")
public class MyEventDataController {
    public final MyEventDataRepository myEventDataRepository;
    private final InvitationRepository invitationRepository;

    public MyEventDataController(MyEventDataRepository myEventDataRepository, InvitationRepository invitationRepository) {
        this.myEventDataRepository = myEventDataRepository;
        this.invitationRepository = invitationRepository;
    }

    @PostMapping()
    public ResponseEntity<MyEventData> createConference(@RequestBody MyEventData myEventData) {
        // Save the conference first
        MyEventData savedConference = myEventDataRepository.save(myEventData);

        // Iterate over the array of invitee emails and create invitations
        for (String inviteeEmail : myEventData.getInvitees()) {
            Invitation invitation = new Invitation();
            invitation.setMeetId(savedConference.getId());
            invitation.setEmail(inviteeEmail);
            invitation.setStatusId(0);
            invitationRepository.save(invitation);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(savedConference);
    }


    //get the conferences of a user by email
    @GetMapping("/{email}")
    public ResponseEntity<List<MyEventData>> getConferencesByEmail(@PathVariable String email) {
        List<MyEventData> myEventData = myEventDataRepository.findConferencesByEmail(email);

        return ResponseEntity.ok(myEventData);
    }

    //get the past conferences of a user by email
    @GetMapping("/1/{email}")
    public ResponseEntity<List<MyEventData>> getPastConferencesByEmail(@PathVariable String email) {
        List<MyEventData> myEventData = myEventDataRepository.findPastConferencesByEmail(email);

        return ResponseEntity.ok(myEventData);
    }

    @GetMapping("/2/{email}")
    public ResponseEntity<List<MyEventData>> getFutureConferencesByEmail(@PathVariable String email) {
        List<MyEventData> myEventData = myEventDataRepository.findFutureConferencesByEmail(email);

        return ResponseEntity.ok(myEventData);
    }

    //put request to update a conference without the owner
    @PutMapping("/update/{Id}")
    public ResponseEntity<MyEventData> updateEvent(@PathVariable int Id, @RequestBody MyEventData updatedEventData) {
        MyEventData existingEvent = myEventDataRepository.findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        // Update fields, except for the owner
        existingEvent.setText(updatedEventData.getText());
        existingEvent.setStart(updatedEventData.getStart());
        existingEvent.setEnd(updatedEventData.getEnd());
        existingEvent.setLocation(updatedEventData.getLocation());
        existingEvent.setType(updatedEventData.getType());
        existingEvent.setInvitees(updatedEventData.getInvitees());
        existingEvent.setMeetLink(updatedEventData.getMeetLink());
        existingEvent.setPublic(updatedEventData.isPublic());
        existingEvent.setDepartments(updatedEventData.getDepartments());
        // Do not update the owner field

        MyEventData savedEvent = myEventDataRepository.save(existingEvent);
        return ResponseEntity.ok(savedEvent);
    }

    //get that returns the conferences of a department
    @GetMapping("/department/{department}")
    public ResponseEntity<List<MyEventData>> getConferencesByDepartment(@PathVariable String department) {
        List<MyEventData> myEventData = myEventDataRepository.findConferencesByDepartment(department);

        return ResponseEntity.ok(myEventData);
    }

    @GetMapping("/public")
    public ResponseEntity<List<MyEventData>> getPublicConferences() {
        List<MyEventData> myEventData = myEventDataRepository.findPublicConferences();

        return ResponseEntity.ok(myEventData);
    }
}
