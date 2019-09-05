package ru.kruglov.task1;

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

    public float getGasolineCost() {
        float gasolineCost = gasolineVolume * GASOLINE_PRICE / 100;
        return gasolineCost;
    }
}
