package ru.kruglov.task8.ActContract;

import java.util.Date;

public class Contract extends Document {
    Contract(int no, Date date, String[] list) {
        super(no,date,list);
    }

    void getClassName() {
        System.out.println("Contract");
    }
}
