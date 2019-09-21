package ru.kruglov.task8.ActContract;

import java.util.Date;

public class Act extends Document {
    Act(int no, Date date, String[] list) {
        super(no,date,list);
    }
    void getClassName() {
        System.out.println("Act");
    }
}
