package com.example.FirstTry.Controller;

import com.example.FirstTry.Repos.ConferenceRepository;
import com.example.FirstTry.Entity.Conference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/conference")
public class ConferenceController {
    public final ConferenceRepository conferenceRepository;

    public ConferenceController(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @GetMapping
    public List<Conference> getConference(){
        return conferenceRepository.findAll();
    }

    @PostMapping
    public void registerNewConference(@RequestBody Conference conference){
        conferenceRepository.save(conference);
    }
 //put the conference by id
    @PutMapping("/{id}")
public void updateConference(@PathVariable Integer id, @RequestBody Conference conference){
        conferenceRepository.findById(id).map(conference1 -> {
            conference1.setText(conference.getText());
            conference1.setStart(conference.getStart());
            conference1.setEnd(conference.getEnd());
            conference1.setColor(conference.getColor());
            conference1.setLocation(conference.getLocation());
            conference1.setType(conference.getType());
            conference1.setInvites(conference.getInvites());
            conference1.setPublic(conference.isPublic());
            return conferenceRepository.save(conference1);
        }
        );
    }
}
