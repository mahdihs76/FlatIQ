package com.example.mahdihs76.flatiq.tool;

import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kosar on 9/14/17.
 */

public class Queries {

    public static final Double RANGE = 5.0;

    public static ArrayList<Group> getNear(String coordinates, List<Group> allGroups) {

        ArrayList<Group> result = new ArrayList<>();
        Double longitude = 0.0;
        Double latitude = 0.0;
        try {
            String[] longLat = coordinates.split("-");
            longitude = Double.parseDouble(longLat[0]);
            latitude = Double.parseDouble(longLat[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Group g : allGroups) {
            if (isInRange(longitude, latitude, g)) {
                result.add(g);
            }
        }
        return result;
    }

    public static boolean isInRange(Double longitude, Double latitude, Group g) {

        Double longi = 0.0;
        Double lati = 0.0;
        try {
            String[] longLat = g.getLocation().split("-");
            longi = Double.parseDouble(longLat[0]);
            lati = Double.parseDouble(longLat[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (longitude + RANGE >= longi && longitude - RANGE <= longi && latitude + RANGE >= lati && latitude - RANGE <= lati) {
            return true;
        }
        return false;
    }


    public static ArrayList<Person> getGroupMembers(String groupID) {
        Group group = null;
        ArrayList<Person> persons = new ArrayList<>();

        for(Group g : Group.groupList) {
            if(g.getId().equals(groupID)){
                group = g;
            }
        }

        if(group != null) {
            String Ids = group.getMembers();
            String[] splitIds = Ids.split("-");
            for (String s : splitIds) {
                for(Person p : Person.personList){
                    if(p.getId().equals(s)){
                        persons.add(p);
                    }
                }
            }

        }
        return persons;
    }

    public static Group getGroupWithId(String id) {
        for (Group group: Group.groupList) {
            if (group.getId().equals(id)){
                return group;
            }
        }
        return null;
    }


}
