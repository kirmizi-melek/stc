package ru.kruglov.task7;

public class Deposite {
    private int depositeSum = 0;

    public int getDeposite() {
        return depositeSum;
    }

    public void setDeposite(int depositeSum) {
        this.depositeSum += depositeSum;
    }

    public boolean comparator(int drinkPrice) {
        return this.depositeSum >= drinkPrice;
    }

    public int getChange() {
        int change = this.depositeSum;
        depositeSum = 0;
        return change;
    }

    public void decreaseDeposite(int priceOfDrink) {
        this.depositeSum -= priceOfDrink;
    }
}
