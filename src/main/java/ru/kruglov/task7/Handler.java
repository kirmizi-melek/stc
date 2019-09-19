package ru.kruglov.task7;

import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Handler {
    private boolean appStatus = true;
    private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    private Drinks[] drinks = Drinks.class.getEnumConstants();
    private Deposite deposit = new Deposite();

    void start() throws IOException {

        System.out.println(Responses.WELCOME.getText());
        while (appStatus) {
            String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
            switch (inputPhrase) {
                case ("exit") :
                    System.out.println(Responses.GOODBYE.getText());
                    appStatus = false;
                    break;
                case ("menu") :
                    getMenu();
                    break;
                case ("help") :
                    System.out.println(Responses.HELP.getText());
                    break;
                case ("deposit"):
                    System.out.println(Responses.PUT_MONEY.getText());
                    coinAcceptor(deposit);
                    break;
                case ("drink"):
                    System.out.println(Responses.SELECT_DRINK.getText());
                    buyDrink();
                    break;
                case ("change"):
                    System.out.println("Take your change: " + deposit.getChange());
                    break;
            }
        }
    }

    private void getMenu() {
        Drinks.getMenu(drinks);
    }

    private void coinAcceptor(Deposite depo) {
        try {
            int coins = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
            depo.setDeposite(coins);
            System.out.println(Responses.CURRENT_DEPOSITE.getText() + depo.getDeposite());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buyDrink() {
        try {
            int drinkID = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
            int cost = Drinks.getPriceForSelectedDrink(drinks, drinkID);
            if (deposit.comparator(cost)) {
                deposit.decreaseDeposite(cost);
                System.out.println(Drinks.getDrink() +
                                   Drinks.getNameForSelectedDrink(drinks, drinkID));
                System.out.println("Your deposit balance: " + deposit.getDeposite());
            } else {
                System.out.println(Responses.NOT_ENOUPH_MONEY.getText());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
