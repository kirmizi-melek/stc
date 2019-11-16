package ru.kruglov.task29;

public class Main {

    public static void main(String[] args) {
        PersonHashMapCreator phmc = new PersonHashMapCreator();
        System.out.println("hashMap before deleting duplicates");
        PersonHashMapActions.printOutputHashMap(phmc.getHashMap());
        System.out.println("\nhashMap after deleting duplicates");
        PersonHashMapActions.removeTheDuplicates(phmc.getHashMap());
        PersonHashMapActions.printOutputHashMap(phmc.getHashMap());

        PersonHashMapActions.removeItemFromMapByValue(phmc.getHashMap(), new Person(1,"Maria", 'F'));
        System.out.println("\nhashMap after deleting item by its value");
        PersonHashMapActions.printOutputHashMap(phmc.getHashMap());

    }
}
