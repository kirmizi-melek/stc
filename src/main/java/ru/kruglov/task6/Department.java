package ru.kruglov.task6;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String speciality;
    public List<StudyGroup> groups;

    public String getSpeciality() {
        return speciality;
    }

    Department(String newName,String newSpeciality) {
        this.name = newName;
        this.speciality = newSpeciality;
        groups = new ArrayList<StudyGroup>();
    }

    public void addGroup(String name,int groupNo, int countsOfStudent) {
        StudyGroup newGroup = new StudyGroup(name, groupNo, countsOfStudent);
        groups.add(newGroup);
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }
}
