package ru.kruglov.task14;

import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class VendingMachine {
    private String brand;
    private Drink[] drinks;
    private Deposit deposit = new Deposit();
    private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

    VendingMachine(String brand, Drink... drinks) {
        this.brand = brand;
        this.drinks = drinks;
    }

    private void printMenu() {
        System.out.println(Response.PRICELIST.getText());
        for (Drink drink : drinks) {
            System.out.println(drink.id + ") " +
                    drink.name + " : " +
                    drink.price + " " +
                    Response.CURRENCY.getText());
        }
        LoggerExample.LOGGER.info("User gets menu");
    }
    private void takeMoney() {
            try {
                int money = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
                deposit.increaseDeposite(money);
                System.out.println(Response.CURRENT_DEPOSIT.getText() + deposit.getDeposit());
            } catch (IOException e) {
                LoggerExample.LOGGER.warning(e.toString());
            }
    }

    private void makeDeal() {
        try {
            int drinkID = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
            int cost = getPriceForSelectedDrink(drinks, drinkID);
            String drinkName = getNameForSelectedDrink(drinks, drinkID);
            if (drinkName != null) {
                if (deposit.priceAndDepositComparison(cost)) {
                    giveOutDrink(drinkID, cost);
                } else {
                    System.out.println(Response.NOT_ENOUPH_MONEY.getText());
                }
            } else {
                System.out.println(Response.WRONG_DRINK_ID.getText());
            }
        } catch (IOException e) {
            LoggerExample.LOGGER.warning(e.toString());
        }
    }

    private void giveOutDrink(int id, int cost) {
        deposit.decreaseDeposite(cost);
        System.out.println(getDrink() +
                getNameForSelectedDrink(drinks, id));
        System.out.println("Your deposit balance: " + deposit.getDeposit());
    }

    private static int getPriceForSelectedDrink(Drink[] allDrinks, int id){
        int priceOfDrink = 0;
        for (Drink drink : allDrinks) {
            if (id == drink.id) {
                priceOfDrink = drink.price;
                break;
            }
        }
        return priceOfDrink;
    }

    private static String getNameForSelectedDrink(Drink[] allDrinks, int id) {
        for (Drink drink : allDrinks) {
            if (id == drink.id) {
                return drink.name;
            }
        }
        return null;
    }

    private static String getDrink() {
        return Response.TAKE_DRINK.getText();
    }

    class UserInterfaceHandler {
        private boolean appStatus = true;
        private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        void start() throws IOException {
            System.out.println(brand +"\n"+ Response.WELCOME.getText());
            while (appStatus) {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                switch (inputPhrase) {
                    case ("exit") :
                        System.out.println(Response.GOODBYE.getText());
                        appStatus = false;
                        break;
                    case ("menu") :
                        printMenu();
                        break;
                    case ("help") :
                        System.out.println(Response.HELP.getText());
                        break;
                    case ("deposit"):
                        System.out.println(Response.PUT_MONEY.getText());
                        takeMoney();
                        break;
                    case ("drink"):
                        System.out.println(Response.SELECT_DRINK.getText());
                        makeDeal();
                        break;
                    case ("change"):
                        System.out.println(Response.TAKE_CHANGE.getText() + deposit.getChange());
                        break;
                    case ("check"):
                        System.out.println(Response.CURRENT_DEPOSIT.getText() + deposit.getDeposit());
                        break;
                    default:
                        System.out.println(Response.WRONG_INPUT.getText());
                        break;
                }
            }
        }
    }
}
