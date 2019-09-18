package ru.kruglov.task7;

import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Field;

class Handler {
    private boolean appStatus = true;
    private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    private Drinks[] drinks = Drinks.class.getEnumConstants();
    private Deposite deposite = new Deposite();

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
                    coinAcceptor(deposite);
                    break;
                case ("drink"):
                    int cost = Drinks.getPriceForSelectedDrink(drinks, 10);
                    System.out.println(cost);
                    break;
            }
        }
    }

    private void coinAcceptor(Deposite depo) {
        try {
            int coins = Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
            depo.setDeposite(coins);
            System.out.println(depo.getDeposite());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getMenu() {
        Drinks.getMenu(drinks);
    }

}
