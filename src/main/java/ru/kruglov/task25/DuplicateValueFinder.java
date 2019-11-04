package ru.kruglov.task25;

import java.util.*;

public class DuplicateValueFinder {
    boolean resultOfCheck = true;

    boolean hashMapDuplicateValueFinder(HashMap<String, String> originalMap) {
        int mapSize = originalMap.size();
        Collection<String> collectionOfValues = originalMap.values();
        String[] arrayOfValues = collectionOfValues.toArray(new String[mapSize]);
        for (int i = 0; i < arrayOfValues.length; i++ ) {
            String comparableValue = arrayOfValues[i];
            for (int j = i; j < arrayOfValues.length; j++) {
                String nextValue = arrayOfValues[j];
                if (comparableValue.equals(nextValue) && i != j) {
                    resultOfCheck = false;
                }
            }
        }
        return resultOfCheck;
    }
}
