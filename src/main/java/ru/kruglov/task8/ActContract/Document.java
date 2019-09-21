package ru.kruglov.task8.ActContract;

import java.util.Date;

public class Document {
    int number;
    Date date;
    String[] listOfGoods;

    Document(){};

    Document(int no, Date date, String[] list) {
        this.number = no;
        this.date = date;
        this.listOfGoods = list;
    }

    void getClassName() {
        System.out.println("Document");
    }
}


