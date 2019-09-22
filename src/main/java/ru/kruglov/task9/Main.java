package ru.kruglov.task9;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setName("Pluto");
        dog1.run();
        Duck duck1 = new Duck();
        duck1.setName("Donald");
        duck1.flyDown();
        duck1.swim();

        Human man = new HumanSwimmer();
        man.run();
        man.swim();
    }
}
