package com.example.FirstTry.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Invitations")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int meetId;
    private String email;
    private int statusId;


    public Invitation(int id, int meetId, String email, int statusId) {
        this.id = id;
        this.meetId = meetId;
        this.email = email;
        this.statusId = statusId;
    }

    public Invitation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeetId() {
        return meetId;
    }

    public void setMeetId(int meetId) {
        this.meetId = meetId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
