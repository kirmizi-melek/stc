package ru.kruglov.task6;

public class University {
    protected String name;
    private String address;

    public String getName() {
        return this.getClass().getSimpleName() + " " + this.name;
    }

    public String getAddress() {
        return address;
    }

    University(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }


}
