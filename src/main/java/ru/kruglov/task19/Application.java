package ru.kruglov.task19;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Application {
    private BufferedReader buff;
    boolean appStatus = true;

    Application() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    private void exitApp() throws IOException {
        Messages.GOODBYE.printMessage();
        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        Messages.HELP.printMessage();
    }

    void appHandler() throws IOException {
        while (appStatus) {
            Messages.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                Commands command = Commands.valueOf(inputPhrase.toUpperCase());
                switch (command) {
                    case HELP:
                        getHelp();
                        break;
                    case EXIT:
                        exitApp();
                        break;
                    case CHEQUE:
                        ArrayList<Product> products = new ProductArrayCreator().makeArrayOfProducts("products.txt", 3);
                        chequePrinter(products);
                        break;
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }

    private void chequePrinter(ArrayList<Product> products) {
        String format = "|%1$-20s|%2$-7s|%3$-7s|%4$-10s|\n";
        float totalCost = 0f;
        System.out.format(format, "Наименование", "Цена", "Кол-во","Стоимость");
        System.out.format(format, "====================", "=======", "=======","==========");
        for (Product product : products) {
            totalCost += product.getCost();
            HashMap<String, String> hashMap = product.getInstanceFields();
            System.out.format(
                            format,
                            hashMap.get("name"),
                            hashMap.get("price"),
                            hashMap.get("count"), //TODO Поиграться с форматами format, чтобы
                            hashMap.get("cost")); //TODO не нужно было приводить float к String

        }
        System.out.format(format, "====================", "=======", "=======","==========");
        System.out.format(format, "Итого", "", "", totalCost);

    }
}

