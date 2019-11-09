package ru.kruglov.task29;

public class Person {
    public int id;
    private String name;
    private int age;

    Person(int personId, String personName, int personAge) {
        this.id = personId;
        this.name = personName;
        this.age = personAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
