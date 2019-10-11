package ru.kruglov.task14;

import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import static ru.kruglov.task14.LoggerExample.LOGGER;

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
        LOGGER.log(Level.INFO, "User requested menu");
    }
    private void takeMoney() {
            try {
                int money = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
                deposit.increaseDeposite(money);
                System.out.println(Response.CURRENT_DEPOSIT.getText() + deposit.getDeposit());
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Error with adding coins into vending machine", e);
            }
    }

    private void makeDeal() {
        try {
            int drinkID = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
            int cost = getSelectedDrink(drinkID).price;
            String drinkName = getSelectedDrink(drinkID).name;
            if (drinkName != null) {
                if (deposit.priceAndDepositComparison(cost)) {
                    giveOutDrink(drinkID, cost);
                } else {
                    System.out.println(Response.NOT_ENOUPH_MONEY.getText());
                    LOGGER.log(Level.INFO, "User tried to order drink not having enough money");
                }
            } else {
                LOGGER.log(Level.INFO, "User selected wrong drink id");
                System.out.println(Response.WRONG_DRINK_ID.getText());
            }
        } catch (IOException e) {
            LOGGER.warning(e.toString());
        }
    }

    private void giveOutDrink(int id, int cost) {
        deposit.decreaseDeposite(cost);
        System.out.println(getDrink() + getSelectedDrink(id).name);
        System.out.println("Your deposit balance: " + deposit.getDeposit());
        LOGGER.log(Level.INFO, "User got his drink: " + getSelectedDrink(id).name);
    }

    private Drink getSelectedDrink(int id){
        for (Drink drink : drinks) {
            if (id == drink.id) {
                return drink;
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
                        LOGGER.log(Level.INFO, "User left the vending machine");
                        appStatus = false;
                        break;
                    case ("menu") :
                        printMenu();
                        break;
                    case ("help") :
                        System.out.println(Response.HELP.getText());
                        LOGGER.log(Level.INFO, "User asked the help");
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
                        LOGGER.log(Level.INFO, "User checked the balance");
                        break;
                    default:
                        System.out.println(Response.WRONG_INPUT.getText());
                        LOGGER.log(Level.INFO, "User typed wrong command");
                        break;
                }
            }
        }
    }
}
