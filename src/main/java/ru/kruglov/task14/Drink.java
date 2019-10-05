package ru.kruglov.task14;

public enum Drink {
    COCACOLA(1,"Coca-Cola", 50),
    PEPSI(2,"Pepsi", 45),
    FANTA(3,"Fanta", 44),
    SPRITE(4,"Sprite", 46);

    public int id;
    public String name;
    public int price;

    Drink(int newId, String newName, int newPrice) {
        this.id = newId;
        this.name = newName;
        this.price = newPrice;
    }




}
