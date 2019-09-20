package ru.kruglov.task7;

class Deposite {
    private int depositeSum = 0;

    int getDeposit() {
        return depositeSum;
    }

    void setDeposite(int depositeSum) {
        this.depositeSum += depositeSum;
    }

    boolean comparator(int drinkPrice) {
        return this.depositeSum >= drinkPrice;
    }

    int getChange() {
        int change = this.depositeSum;
        depositeSum = 0;
        return change;
    }

    void decreaseDeposite(int priceOfDrink) {
        this.depositeSum -= priceOfDrink;
    }
}
