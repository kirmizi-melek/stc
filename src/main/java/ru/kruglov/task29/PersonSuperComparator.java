package ru.kruglov.task29;

import java.util.Comparator;

public class PersonSuperComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getId() == person2.getId()) {
            if (person1.getName().equals(person2.getName())) {
                return Character.compare(person1.getSex(), person2.getSex());
            } else return person1.getName().compareTo(person2.getName());
        } else if (person1.getId() < person2.getId()) {
            return -1;
        } else {
            return 1;
        }
    }
}
