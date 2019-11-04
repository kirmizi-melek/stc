package ru.kruglov.task25;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> hmp = new HashMapPreparator().hashMapPreparator();
        System.out.println(new DuplicateValueFinder().hashMapDuplicateValueFinder(hmp));
    }
}
