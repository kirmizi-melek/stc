package ru.kruglov.task25_1;

import java.util.HashMap;

public class HashMapPreparator {
    HashMap<String,String> hashMapPreparator() {
        HashMap<String, String> originalMap = new HashMap<>();
        originalMap.put("Вася", "Иванов1");
        originalMap.put("Иван", "Иванов");
        originalMap.put("Олег", "Яковлев");
        return originalMap;
    }
}
