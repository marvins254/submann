package com.example.submann;

public class user {
    private String username, email;
    private int id;

    public user(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
