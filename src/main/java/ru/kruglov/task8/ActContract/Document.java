package ru.kruglov.task8.ActContract;

import java.util.Date;

abstract class Document {
    private int number;
    private Date date;
    private String[] listOfGoods;

    String[] getListOfGoods() {
        return listOfGoods;
    }

    int getNumber() {
        return number;
    }

    Date getDate() {
        return date;
    }

    String getListOfGoodsInString() {
        StringBuilder result = new StringBuilder();
        for (String str : listOfGoods) {
            result.append(str).append(", ");
        }
        return result.toString();
    }

    Document(int no, Date date, String[] list) {
        this.number = no;
        this.date = date;
        this.listOfGoods = list;
    }

    private String getClassName() {
        return this.getClass().getSimpleName();
    }

    void getDocumentInfo() {
        System.out.println(
                "ClassName:" + this.getClassName() +
                "\nNumber:" + this.getNumber() +
                "\nDate:" + this.getDate() +
                "\nList:" + this.getListOfGoodsInString());
    }
}


