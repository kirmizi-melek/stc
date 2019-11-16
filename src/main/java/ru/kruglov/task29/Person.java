package ru.kruglov.task29;

public class Person {
    public int id;
    private String name;
    private char sex;

    Person(int personId, String personName, char personSex) {
        this.id = personId;
        this.name = personName;
        this.sex = personSex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Person comparablePeson = (Person)obj;
        if (this.getId() == comparablePeson.getId() &&
            this.getName().equals(comparablePeson.getName()) &&
            this.getSex() == comparablePeson.getSex()) {
                    return true;
        }  else {
            return false;
        }
    }
}
