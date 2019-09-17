package ru.kruglov.task2.Gasoline;

public class GasolineCounter {
    private static final int GASOLINE_PRICE = 4300; // price in cents
    private int gasolineVolume;

    GasolineCounter(int volume) {
        if (volume > 0) {
            this.gasolineVolume = volume;
        } else {
            System.out.println("Value of gasoline volume is less or equal 0");
        }
    }

    private float getGasolineCost() {
        return (float) (gasolineVolume * GASOLINE_PRICE / 100);
    }

    public static void main(String[] args) {
        try {
            String inputValue = args[0];
            int volume = Integer.parseInt(inputValue);
            GasolineCounter gc = new GasolineCounter(volume);
            System.out.println(gc.getGasolineCost());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
