package ru.kruglov.task19;

public class RemainderOfDivisionException extends Throwable {
    RemainderOfDivisionException() {
        super("Remainder of the division is not equal to zero");
    }
}
