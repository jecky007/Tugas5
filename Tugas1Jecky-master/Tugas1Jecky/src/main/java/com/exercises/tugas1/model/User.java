package com.exercises.tugas1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

int id;
String username;
String email;
String name;
String password;

@ElementCollection

    private List<String> roles= new ArrayList<>();
boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(int id, String username, String email, String name, String password, List<String> roles, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }
}
