package ru.kruglov.task6;

public class Department {
    private String name;
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    Department(String newName,String newSpeciality) {
        this.name = newName;
        this.speciality = newSpeciality;
    }

    public String getName() {
        return this.getClass().getSimpleName() + " " + this.name;
    }
}
