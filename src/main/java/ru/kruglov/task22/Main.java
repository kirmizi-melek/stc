package ru.kruglov.task22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people =
                new ArrayList<>();
        people.add(new Person(1, "Ivan", 24));
        people.add(new Person(2, "Ivan", 20));
        people.add(new Person(3,"Ivan", 20));
        people.add(new Person(4,"Sergey", 24));
        people.add(new Person(5,"Sergey", 20));

        PersonSuperComparator psc = new PersonSuperComparator();

        //people.size();
        for (int i = 0; i < people.size(); i++ ) {
            Person comparablePerson = people.get(i);
            for (int j = i; j < people.size() ; j++) {
                Person nextPerson = people.get(j);
                if (i != j) {
                    System.out.println(comparablePerson.id + ")" + comparablePerson.getName()
                            + " & " + nextPerson.id +")" + nextPerson.getName() + "= " +
                            psc.compare(comparablePerson, nextPerson) + "\n");
                }
            }
        }
    }
}
