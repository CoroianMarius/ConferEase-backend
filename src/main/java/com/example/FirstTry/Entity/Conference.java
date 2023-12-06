package com.example.FirstTry.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Conferences")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    private Date start;
    private Date end;
    private String color;
    private String location;
    private String type;
    //I want to add a list of users who are invited to the conference
    @ManyToMany(mappedBy = "conferences")
    private Set<User> invites = new HashSet<>();
    private boolean isPublic;


    public Conference(int id, String text, Date start, Date end, String color, String location, String type, Set<User> invites, boolean isPublic) {
        this.id = id;
        this.text = text;
        this.start = start;
        this.end = end;
        this.color = color;
        this.location = location;
        this.type = type;
        this.invites = invites;
        this.isPublic = isPublic;
    }

    public Conference() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Set<User> getInvites() {
        return invites;
    }

    public void setInvites(Set<User> invites) {
        this.invites = invites;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
