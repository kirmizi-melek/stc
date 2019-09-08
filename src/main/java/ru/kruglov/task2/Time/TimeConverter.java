package ru.kruglov.task2.Time;

public class TimeConverter {
    
    private int seconds;

    TimeConverter(int inputSeconds) {
        if (inputSeconds >= 0) {
            this.seconds = inputSeconds;
        } else {
            System.out.println("Value of seconds is less than 0");
            System.exit(1);
        }
    }

    public String getTimeInHours() {
        String outputTime;
        int hours = seconds / 3600;
        int minutes = (seconds / 60) % 60;
        outputTime = hours + " hour(s) " + minutes + " minute(s)";
        return outputTime;
    }

    public static void main(String Args[]) {
        try {
            String inputValue  = Args[0];
            int time = Integer.parseInt(inputValue);
            TimeConverter tc = new TimeConverter(time);
            System.out.println(tc.getTimeInHours());
        } catch (ArrayIndexOutOfBoundsException aiofbe){
            aiofbe.printStackTrace();
            System.exit(1);
        } catch (NumberFormatException nfc) {
            nfc.printStackTrace();
            System.exit(1);
        }
    }
}
