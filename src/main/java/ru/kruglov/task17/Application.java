package ru.kruglov.task17;

import ru.kruglov.localLibs.FileRead;
import ru.kruglov.localLibs.FileWrite;
import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Application {
    private BufferedReader buff;
    boolean appStatus = true;
    private String pathToLibrary = "library.csv";

    Application() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    private void exitApp() throws IOException {
        Messages.GOODBYE.printMessage();

        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        Messages.HELP.printMessage();
    }

    void appHandler() throws IOException {
        while (appStatus) {
            Messages.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                    getHelp();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    exitApp();
                } else if (inputPhrase.equals(Commands.ADD_BOOK.getMessage())) {
                    bookAddition();
                } else if (inputPhrase.equals(Commands.GET_LIST_OF_BOOKS.getMessage())) {
                    String[][] s = new FileRead(pathToLibrary).getArrayOfData();
                    Book[] library = Book.createLibrary(s);
                    for (Book book:library) {
                        System.out.print(book.getInfo() + "\n");
                    }
                } else {
                    wrongInput();
                }
            } catch (IOException e) {
                buff.close();
                Messages.ERROR_APP_HANDLER.printMessage();
                e.printStackTrace();
            }
        }
    }

    private void bookAddition() throws IOException{
        String title, author, year;
        Messages.TYPE_BOOK_TITLE.printMessage();
        title = InputDataHandle.getDataFromSystemIn(this.buff);
        Messages.TYPE_BOOK_AUTHOR.printMessage();
        author = InputDataHandle.getDataFromSystemIn(this.buff);
        Messages.TYPE_BOOK_YEAR.printMessage();
        year = InputDataHandle.getDataFromSystemIn(this.buff);
        Book newBook = new Book().addBookToLibrary(title, author, year);
        FileWrite fileWriter = new FileWrite(pathToLibrary,newBook.bookToString() );
        fileWriter.writeToFile();
        }

    private void wrongInput() {
        Messages.WRONG_INPUT.printMessage();
    }
}

