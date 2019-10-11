package ru.kruglov.task13;

public class Child {

    public void eat(Food food) throws ChildFeedException {
        if (food.getTaste() == true) {
            sayThanksForTastyFood(food);
        } else throw new ChildFeedException(food.toString());
    }

    public void sayThanks() {
        System.out.println("Спасибо, мама \n");
    }

    private void sayThanksForTastyFood(Food food) {
        System.out.println("Съел " + food + " за обе щеки");
    }
}
