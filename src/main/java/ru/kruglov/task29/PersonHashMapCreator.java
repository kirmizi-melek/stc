package ru.kruglov.task29;

import java.util.HashMap;
import java.util.Map;

public class PersonHashMapCreator {
    private Map<String,Person> hashMap;

    public  Map<String, Person> getHashMap() {
        return hashMap;
    }

    PersonHashMapCreator() {
        hashMap = new HashMap<>();

        Person person1 = new Person(1, "Maria", 'F');
        Person person2 = new Person(2, "Ivan", 'M');
        Person person3 = new Person(3, "Svetlana", 'F');
        Person person4 = new Person(4, "Sergey", 'M');

        hashMap.put("Key1", person1);
        hashMap.put("Key2", person1);
        hashMap.put("Key3", person2);
        hashMap.put("Key4", person3);
        hashMap.put("Key5", person4);
        hashMap.put("Key6", person4);
        hashMap.put("Key7", person1);
    }
}