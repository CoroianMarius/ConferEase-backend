package com.example.FirstTry.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class MyEventData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    private String location;
    private String type;
    @ElementCollection
    private Set<String> invitees;
    @Column(name = "meet_link")
    private String meetLink;
    private boolean isPublic=true;
    private String owner;
    @ElementCollection
    private Set<String> departments;

    public MyEventData() {
    }

    public MyEventData(int id, String text, Date start, Date end, String location, String type, Set<String> invitees, String meetLink, boolean isPublic, String owner, Set<String> departments) {
        this.id = id;
        this.text = text;
        this.start = start;
        this.end = end;
        this.location = location;
        this.type = type;
        this.invitees = invitees;
        this.meetLink = meetLink;
        this.isPublic = isPublic;
        this.owner = owner;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<String> getInvitees() {
        return invitees;
    }

    public void setInvitees(Set<String> invitees) {
        this.invitees = invitees;
    }

    public String getMeetLink() {
        return meetLink;
    }

    public void setMeetLink(String meetLink) {
        this.meetLink = meetLink;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<String> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<String> departments) {
        this.departments = departments;
    }
}
