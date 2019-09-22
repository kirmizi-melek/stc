package ru.kruglov.task8.ActContract;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Main maker = new Main();
        maker.makeDocuments();
    }

    void makeDocuments() {
        String[] list = {"some","thing"};
        Date date = new Date();

        Act actA = new Act (1, date, list);
        Contract contractA = Converter.converter(actA);
        contractA.getDocumentInfo();

        System.out.println();

        Document contractB = new Contract(2, date, list);
        Act actB = Converter.converter((Contract) contractB);
        actB.getDocumentInfo();

    }
}
