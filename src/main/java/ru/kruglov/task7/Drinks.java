package ru.kruglov.task7;

public enum Drinks {
    COCACOLA("Coca-Cola", 50),
    PEPSI("Pepsi", 45),
    FANTA("Fanta", 44),
    SPRITE("Sprite", 46);

    private String name;
    private int price;

    Drinks(String newName, int newPrice) {
        this.name = newName;
        this.price = newPrice;
    }

    public static void getMenu(Drinks[] allDrinks) {
        System.out.println("Menu");
        for (Drinks drink : allDrinks) {
            System.out.println(drink.name + " : " + drink.price + " rub.");
        }
    }


}
