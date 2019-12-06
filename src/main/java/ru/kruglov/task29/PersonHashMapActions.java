package ru.kruglov.task29;

import java.util.*;

public class PersonHashMapActions {

    public static void printOutputHashMap(Map<String,Person> map) {
        for (Map.Entry<String,Person> entry : map.entrySet()) {
            String key = entry.getKey();
            Person value = entry.getValue();
            System.out.printf("%s: id=%s; name=%s; sex=%s \n",
                    key, value.getId(), value.getName(), value.getSex());
        }
    }

    public static void removeTheDuplicates(Map<String,Person> map) {
        Set<Map.Entry<String,Person>>  list = new HashMap<>(map).entrySet();
        for (Iterator<Map.Entry<String,Person>> iterator = list.iterator(); iterator.hasNext();) {
           // if (Collections.frequency(list, iterator.next())>1) {
               // iterator.remove();
                if (iterator.hasNext()) {
                    Map.Entry<String,Person> personEntry = iterator.next();
                    removeItemFromMapByValue(map, personEntry.getValue());
                    map.put(personEntry.getKey(), personEntry.getValue());
                }
          //  }
        }
    }

    public static void removeItemFromMapByValue(Map<String,Person> map, Person value) {
//      TODO удалить дубликат из исходной мапы используя этот метод
        Map<String,Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
}

