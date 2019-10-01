package ru.kruglov.task13;

public class Mother {
    public static void main(String[] args) {
        Mother anna = new Mother();
        Child ivan = new Child();
        anna.feed(ivan);
    }

    private void feed(Child child){
        try {
            child.eat(Food.PORRIGE);
        } catch (ChildFeedException e) {
            e.printStackTrace();
        } finally {
            child.sayThanks();
        }
    }
}