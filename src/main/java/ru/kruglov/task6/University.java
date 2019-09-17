package ru.kruglov.task6;

public class University {
    protected String name;
    protected String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void printName() {
        System.out.println("Я университет " + name);
    }

    University(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }


}
