package ru.kruglov.task29;

import java.util.Comparator;

public class PersonSuperComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getName().equals(person2.getName()) &&
                person1.getSex() == person2.getSex()) {
            return 0;
        } else return 1;
    }
}
