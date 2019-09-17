package ru.kruglov.task7;

public class Main {
    public static void main(String[] args) {
        Drinks[] drinks = Drinks.class.getEnumConstants();
        Drinks.getMenu(drinks);
    }
}
