package ru.kruglov.task6;

public class Department extends University {
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    Department(String newName,
               String newAddress,
               String newSpeciality) {
        super(newName, newAddress);
        this.speciality = newSpeciality;
    }
}
