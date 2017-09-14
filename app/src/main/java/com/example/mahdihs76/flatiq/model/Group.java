package com.example.mahdihs76.flatiq.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kosar on 9/14/17.
 */

public class Group {
    public static List<Group> groupList = new ArrayList<>();

    private String id;
    private String name;
    private String adminID;
    private String location;
    private String activity;
    private String member;
    private String schedule;
    private String imageSrc;

    public Group(String id, String name, String adminID, String location, String activity, String member, String schedule, String imageSrc) {
        this.id = id;
        this.name = name;
        this.adminID = adminID;
        this.location = location;
        this.activity = activity;
        this.member = member;
        this.schedule = schedule;
        this.imageSrc = imageSrc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
