package ru.kruglov.task43.app;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.IOException;

class ApplicationTerminal extends Application{
    int getReaderIdFromConsole() {
        Messages.TYPE_READER_ID.printMessage();
        try {
            return Integer.parseInt(InputDataHandle.getDataFromSystemIn(super.buff));
        } catch (IOException | NumberFormatException e ) {
            Messages.WRONG_INPUT.printMessage();
        }
        return 0;
    }

    int getBookIdFromConsole() {
        Messages.TYPE_BOOK_ID.printMessage();
        try {
            return Integer.parseInt(InputDataHandle.getDataFromSystemIn(super.buff));
        } catch (IOException | NumberFormatException e ) {
            Messages.WRONG_INPUT.printMessage();
        }
        return 0;
    }
}
