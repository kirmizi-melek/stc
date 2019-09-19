package ru.kruglov.task7;

public enum Drinks {
    COCACOLA(1,"Coca-Cola", 50),
    PEPSI(2,"Pepsi", 45),
    FANTA(3,"Fanta", 44),
    SPRITE(4,"Sprite", 46);

    public int id;
    private String name;
    private int price;

    Drinks(int newId, String newName, int newPrice) {
        this.id = newId;
        this.name = newName;
        this.price = newPrice;
    }

    public static void getMenu(Drinks[] allDrinks) {
        System.out.println(Responses.PRICELIST.getText());
        for (Drinks drink : allDrinks) {
            System.out.println(drink.id + ") " +
                               drink.name + " : " +
                               drink.price + " " +
                               Responses.CURRENCY.getText());
        }
    }

    public static int getPriceForSelectedDrink(Drinks[] allDrinks, int id){
        int priceOfDrink = 0;
        for (Drinks drink : allDrinks) {
            if (id == drink.id) {
                priceOfDrink = drink.price;
                break;
            }
        }
        return priceOfDrink;
    }

    public static String getNameForSelectedDrink(Drinks[] allDrinks, int id) {
        String drinkName = null;
        for (Drinks drink : allDrinks) {
            if (id == drink.id) {
                drinkName = drink.name;
                break;
            }
        }
        return drinkName;
    }

    public static String getDrink() {
        return Responses.TAKE_DRINK.getText();
    }
}
