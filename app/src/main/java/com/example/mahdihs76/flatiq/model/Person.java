package com.example.mahdihs76.flatiq.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kosar on 9/14/17.
 */

public class Person {
    public static List<Person> personList = new ArrayList<>();


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String id;
    private String score;
    private String image;

    public Person(String firstName, String lastName, String email, String password, String id, String score, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
        this.score = score;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
