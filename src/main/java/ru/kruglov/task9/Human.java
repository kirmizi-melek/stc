package ru.kruglov.task9;

public abstract class Human extends Animal implements Running, Swimming{
    int speed = 100;
    int endurance = 100;

    @Override
    public void run() {
        System.out.println(this.speed);
    }

    @Override
    public void swim() {
        System.out.println(this.endurance);
    }
}
