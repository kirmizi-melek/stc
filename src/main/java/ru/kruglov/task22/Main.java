package ru.kruglov.task22;

import java.util.ArrayList;

public class Main {
    public ArrayList personToPeopleOrganizer() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1, "Ivan", 24));
        people.add(new Person(2, "Ivan", 20));
        people.add(new Person(3,"Ivan", 20));
        people.add(new Person(4,"Sergey", 24));
        people.add(new Person(5,"Sergey", 20));
        //people.sort();
        return people;
    }

    public void dublicatePersonFinder(ArrayList<Person> people) {
        PersonSuperComparator psc = new PersonSuperComparator();
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

    public static void main(String[] args) {
        Main main = new Main();
        //main.dublicatePersonFinder(main.personToPeopleOrganizer());
        main.method();
    }

    public void method() {
      ArrayList<Person> al = personToPeopleOrganizer();
      al.sort(new PersonSuperComparator());
      for (int i = 0; i < al.size(); i++ ) {
          Person comparablePerson = al.get(i);
          System.out.printf("%s: %s \n",comparablePerson.getName(), comparablePerson.getAge());
      }
    }
}
