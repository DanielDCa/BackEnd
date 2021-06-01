package edu.upc.dsa.models;

import java.util.List;

public class User {

    String username;
    String name;
    String avatar;
    String surname;
    List<String> medallas;

    public User(String username, String name, String avatar, String surname, List<String> medallas) {
        this.username = username;
        this.name = name;
        this.avatar = avatar;
        this.surname = surname;
        this.medallas = medallas;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getMedallas() {
        return medallas;
    }

    public void setMedallas(List<String> medallas) {
        this.medallas = medallas;
    }
}
