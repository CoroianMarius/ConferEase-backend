package com.example.FirstTry.Entity;

public class User {
    private int id;
    private String email;
    private boolean isAdmin;
    private String password;
    private String depart;

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
