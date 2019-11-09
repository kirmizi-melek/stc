package ru.kruglov.task29;

import java.util.HashMap;
import java.util.Map;

public class PersonHashMapActions {

    public static Map<String,Person> createMap() {
        HashMap<String, Person> hashMapOfPersons = new HashMap<>();
        Person person1 = new Person(1, "Maria", 'F');
        Person person2 = new Person(2, "Ivan", 'M');
        Person person3 = new Person(3, "Svetlana", 'F');
        Person person4 = new Person(4, "Sergey", 'M');

        hashMapOfPersons.put("Key1", person1);
        hashMapOfPersons.put("Key2", person1);
        hashMapOfPersons.put("Key3", person2);
        hashMapOfPersons.put("Key4", person3);
        hashMapOfPersons.put("Key5", person4);
        hashMapOfPersons.put("Key6", person4);

        return hashMapOfPersons;
    }

    public static void removeTheDuplicates() {
        //TODO Реализовать метод поиска дубликатов в исх. мапе, а также при нахождении дубликата
    }

    public static void removeItemFromMapByValue(Map<String,Person> map, Person value) {
//        TODO удалить дубликат из исходной мапы используя этот метод
//        Map<String, Person> copy = new HashMap<>(map);
//        for (Map.Entry<String, Person> pair: copy.entrySet())
//        {
//            if (pair.getValue().equals(value))
//                map.remove(pair.getKey());
//        }
    }
}

