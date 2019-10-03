package ru.kruglov.task13;

public class Mother {
    public static void main(String[] args) {
        Child ivan = new Child();
        Mother anna = new Mother();
        UserInterfaceHandler userInterfaceHandler = new UserInterfaceHandler();
        userInterfaceHandler.start(anna, ivan);
    }

    public void feed(Child child, Food food){
        try {
            child.eat(food);
        } catch (ChildFeedException e) {
            e.printStackTrace();
        } finally {
            child.sayThanks();
        }
    }


}