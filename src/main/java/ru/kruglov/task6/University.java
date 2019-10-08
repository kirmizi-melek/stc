package ru.kruglov.task6;

import java.util.ArrayList;
import java.util.List;

public class University {
    protected String name;
    private String address;
    public List<Department> departments;
    public String getName() {
        return this.getClass().getSimpleName() + " " + this.name;
    }
    public String getAddress() {
        return address;
    }

    University(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
        departments = new ArrayList<Department>();
    }

    public void addDepartment(String name,
                              String speciality) {
        Department newDepartment = new Department(name, speciality);
        departments.add(newDepartment);
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
