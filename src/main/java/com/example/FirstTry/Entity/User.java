package com.example.FirstTry.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="Users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence"
    )
    private int id;
    private String email;
    private boolean isAdmin;
    private String password;
    private String depart;

    public Set<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(Set<Conference> conferences) {
        this.conferences = conferences;
    }

    @ManyToMany
    @JoinTable(
            name = "user_conference",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "conference_id")
    )
    private Set<Conference> conferences = new HashSet<>();

    public User() {
    }

    public User(int id, String email, boolean isAdmin, String password, String depart) {
        this.id = id;
        this.email = email;
        this.isAdmin = isAdmin;
        this.password = password;
        this.depart = depart;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
}
