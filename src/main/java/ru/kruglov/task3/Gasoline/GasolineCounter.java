package ru.kruglov.task3.Gasoline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GasolineCounter {
    private static int GASOLINE_PRICE = 4300; // price in cents
    private int gasolineVolume;

    GasolineCounter(int volume) {
        if (volume > 0) {
            this.gasolineVolume = volume;
        } else {
            System.out.println("Value of gasoline volume is less or equal 0");
            System.exit(1);
        }
    }

    private float getGasolineCost() {
        float gasolineCost = gasolineVolume * GASOLINE_PRICE / 100;
        return gasolineCost;
    }

    public static void main(String Args[]) throws IOException {
        System.out.println("Type needed volume of gasoline:");
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = buff.readLine();
        try {
            int volume = Integer.parseInt(inputValue);
            GasolineCounter gc = new GasolineCounter(volume);
            System.out.println("Total cost of gasoline = " + gc.getGasolineCost());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
