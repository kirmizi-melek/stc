package ru.kruglov.task9;

public class Fish extends Animal implements Swimming {
    @Override
    protected String getName() {
        return this.name;
    }

    @Override
    public void swim() {
        String result = getName() + " is swimming";
        System.out.println(result);
    }
}
