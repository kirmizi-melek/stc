package ru.kruglov.task14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodayDate {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime now = LocalDateTime.now();

    public String getTodayDate() {
        return dtf.format(now);
    }
}
