package ru.kruglov.task17;

import ru.kruglov.localLibs.CheсkForNullAndEmpty;
import ru.kruglov.localLibs.FileRead;
import ru.kruglov.localLibs.FileWrite;
import ru.kruglov.localLibs.InputDataHandle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

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
                    bookDataGetterFromSystemIn();
                } else if (inputPhrase.equals(Commands.GET_LIST_OF_BOOKS.getMessage())) {
                    String[][] arrayOfCSVData = new FileRead(pathToLibrary).getArrayOfData();
                    Book[] library = Book.createLibrary(arrayOfCSVData);
                    for (Book book:library) {
                        System.out.print(book.getInfo() + "\n");
                    }
                } else {
                    getMessageAboutWrongInput();
                }
            } catch (IOException e) {
                Messages.ERROR_APP_HANDLER.printMessage();
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }

    private void bookDataGetterFromSystemIn() throws IOException{
        String title, author, year;
        HashMap<String, String> hashMapOfBook = new HashMap();
        Messages.TYPE_BOOK_TITLE.printMessage();
        title = InputDataHandle.getDataFromSystemIn(this.buff);
        Messages.TYPE_BOOK_AUTHOR.printMessage();
        author = InputDataHandle.getDataFromSystemIn(this.buff);
        Messages.TYPE_BOOK_YEAR.printMessage();
        year = InputDataHandle.getDataFromSystemIn(this.buff);

        if (CheсkForNullAndEmpty.checker(new String[]{title,author,year})) {
            hashMapOfBook.put("title",title);
            hashMapOfBook.put("author",author);
            hashMapOfBook.put("year",year);
            bookAddition(hashMapOfBook);
            Messages.BOOK_SUCCESSFULYY_ADDED.printMessage();
        } else Messages.WRONG_INPUT.printMessage();
    }

    private void bookAddition(HashMap<String,String> hashMapOfBook) {
        Book newBook = new Book().addBookToLibrary(
                hashMapOfBook.get("title"),
                hashMapOfBook.get("author"),
                hashMapOfBook.get("year"));
        FileWrite fileWriter = new FileWrite(pathToLibrary,newBook.bookToString() );
        fileWriter.writeToFile();
    }

    private void getMessageAboutWrongInput() {
        Messages.WRONG_INPUT.printMessage();
    }
}

