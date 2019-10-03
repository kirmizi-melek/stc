package ru.kruglov.task13;

import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UserInterfaceHandler {
    private boolean appStatus = true;
    private Food food;
    private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

    void start(Mother mother, Child child) {
        try {
            String inputPhrase;
            while (appStatus) {
                System.out.println("Покорми ребенка");
                 inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                switch (inputPhrase) {
                    case ("exit"):
                        System.exit(0);
                        break;
                    case ("carrot"):
                        this.food = Food.CARROT;
                        break;
                    case ("porrige"):
                        this.food =  Food.PORRIGE;
                        break;
                    case ("apple"):
                        this.food =  Food.APPLE;
                        break;
                    case ("milk"):
                        this.food =  Food.MILK;
                        break;
                    case ("soup"):
                        this.food =  Food.SOUP;
                        break;
                    default:
                        continue;
                }
                mother.feed(child, food);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
