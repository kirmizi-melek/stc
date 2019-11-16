package ru.kruglov.task29;

public class Main {

    public static void main(String[] args) {
        //Creating of hasmap
        PersonHashMapCreator phmc = new PersonHashMapCreator();

        //Printing hashMap in console
        System.out.println("hashMap before deleting duplicates");
        PersonHashMapActions.printOutputHashMap(phmc.getHashMap());

        //Finding and deleting of duplicates from hashmap
        System.out.println("\nhashMap after deleting duplicates");
        PersonHashMapActions.removeTheDuplicates(phmc.getHashMap());

        //Printing of hashMap without duplicates in console
        PersonHashMapActions.printOutputHashMap(phmc.getHashMap());

        //Deleting of element from hashMap by separate request
        PersonHashMapActions.removeItemFromMapByValue(phmc.getHashMap(), new Person(1,"Maria", 'F'));

        //Printing of hashMap after deleting of single element
        System.out.println("\nhashMap after deleting item by its value");
        PersonHashMapActions.printOutputHashMap(phmc.getHashMap());
    }
}
