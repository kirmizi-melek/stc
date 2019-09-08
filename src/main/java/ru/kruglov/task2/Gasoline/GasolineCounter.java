package ru.kruglov.task2.Gasoline;

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

    public static void main(String Args[]) {
        try {
            String inputValue = Args[0];
            int volume = Integer.parseInt(inputValue);
            GasolineCounter gc = new GasolineCounter(volume);
            System.out.println(gc.getGasolineCost());
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            aiobe.printStackTrace();
            System.exit(1);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            System.exit(1);
        }

    }
}
