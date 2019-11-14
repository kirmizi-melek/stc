package ru.kruglov.task29;

import java.util.*;

public class PersonHashMapActions {
    static Map<String,Person> hashMap = new HashMap<>();

    public static Map<String,Person> createMap() {
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

        return hashMap;
    }


    public static void printOutputHashMap() {
        for (Map.Entry<String,Person> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Person value = entry.getValue();
            System.out.printf("%s: id=%s; name=%s; sex=%s \n",
                    key, value.getId(), value.getName(), value.getSex());
        }
    }

    public static void removeTheDuplicates() {
        hashMap = createMap();
        Collection<Person> list = hashMap.values();
        for (Iterator<Person> iterator = list.iterator(); iterator.hasNext();) {
            if (Collections.frequency(list, iterator.next())>1) {
                iterator.remove();
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String,Person> map, Person value) {
//        TODO удалить дубликат из исходной мапы используя этот метод
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

