package ru.kruglov.task14;

import java.util.logging.Level;

import static ru.kruglov.task14.LoggerExample.LOGGER;

class VendingMachine {
    public String getBrand() {
        return brand;
    }

    private String brand;

    public Drink[] getDrinks() {
        return drinks;
    }

    private Drink[] drinks;
    private Deposit deposit = new Deposit();

    public int getDepositSum() {
        return deposit.getDeposit();
    }

    VendingMachine(String brand, Drink... drinks) {
        this.brand = brand;
        this.drinks = drinks;
    }

    public int getChange() {
        return deposit.getChange();
    }


    public void takeMoney(int money) {
        deposit.increaseDeposite(money);

    }

    public void makeDeal(int drinkID) throws NoMoneyException, DrinkNotFoundException {
            int cost = getSelectedDrink(drinkID).price;
            String drinkName = getSelectedDrink(drinkID).name;
            if (drinkName != null) {
                if (deposit.priceAndDepositComparison(cost)) {
                    deposit.decreaseDeposite(cost);
                    LOGGER.log(Level.INFO, "User got his drink: " + getSelectedDrink(drinkID).name);
                } else {
                    throw new NoMoneyException();
                }
            } else {
                throw new DrinkNotFoundException();
            }
    }

    public Drink getSelectedDrink(int id){
        for (Drink drink : drinks) {
            if (id == drink.id) {
                return drink;
            }
        }
        return null;
    }

    public static String getDrink() {
        return Response.TAKE_DRINK.getText();
    }
}
