package ru.kruglov.task25;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // task 25.1 Filtering of Map.
        // If duplicate values are exist - return FALSE, else - TRUE
        HashMap<String,String> hmp = new HashMapPreparator().hashMapPreparator();
        System.out.println(new DuplicateValueFinder().hashMapDuplicateValueFinder(hmp));
    }
}
