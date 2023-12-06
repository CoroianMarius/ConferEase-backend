package com.example.FirstTry.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Invitations")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int conferenceId;
    private int userId;
    private boolean isAccepted;

    public Invitation(int id, int conferenceId, int userId, boolean isAccepted) {
        this.id = id;
        this.conferenceId = conferenceId;
        this.userId = userId;
        this.isAccepted = isAccepted;
    }

    public Invitation() {
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
