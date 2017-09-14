package com.example.mahdihs76.flatiq.model;

import java.util.ArrayList;

/**
 * Created by kosar on 9/14/17.
 */

public class Group {
    public static ArrayList<Group> groupList = new ArrayList<>();

    private String id;
    private String name;
    private String adminID;
    private String location;
    private String activity;
    private String members;
    private String schedule;
    private String imageSrc;

    public Group(String id, String name, String adminID, String location, String activity, String members, String schedule, String imageSrc) {
        this.id = id;
        this.name = name;
        this.adminID = adminID;
        this.location = location;
        this.activity = activity;
        this.members = members;
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

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
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

    public static ArrayList<String> getGroupID() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getId());
        }
        return list;
    }

    public static ArrayList<String> getGroupName() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getName());
        }
        return list;
    }

    public static ArrayList<String> getGroupAdminID() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getAdminID());
        }
        return list;
    }

    public static ArrayList<String> getGroupLocation() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getLocation());
        }
        return list;
    }

    public static ArrayList<String> getGroupActivity() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getActivity());
        }
        return list;
    }

    public static ArrayList<String> getGroupMembers() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getMembers());
        }
        return list;
    }

    public static ArrayList<String> getGroupSchedule() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getSchedule());
        }
        return list;
    }

    public static ArrayList<String> getGroupImageSrc() {
        ArrayList<String> list = new ArrayList<>();
        for(Group g : groupList) {
            list.add(g.getImageSrc());
        }
        return list;
    }
}
