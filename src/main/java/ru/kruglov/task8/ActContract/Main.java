package ru.kruglov.task8.ActContract;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String[] list = {"1","2"};
        Date date = new Date();


        Act act = new Act (4, date, list);
        Contract contract = new Contract(5,date,list);
        Contract ac = (Act)act.getClassName();
        ac.getClassName();
        }



}
