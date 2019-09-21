package ru.kruglov.task9;

public class Dog extends Animal implements Running {
    @Override
    protected String getName() {
        return this.name;
    }

    @Override
    public void run() {
        String result = getName() + " is running";
        System.out.println(result);
    }
}
