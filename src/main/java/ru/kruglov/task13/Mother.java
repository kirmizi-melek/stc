package ru.kruglov.task13;

public class Mother {
    public static void main(String[] args) {
        Mother anna = new Mother();
        Child ivan = new Child();
        Food food = Food.PORRIGE;
        anna.feed(ivan, food);
    }

    private void feed(Child child, Food food){
        try {
            child.eat(food);
        } catch (ChildFeedException e) {
            e.printStackTrace();
        } finally {
            child.sayThanks();
        }
    }
}