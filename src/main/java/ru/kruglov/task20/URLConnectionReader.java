package ru.kruglov.task20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
    private final static String PATH_TO_API = "https://cat-fact.herokuapp.com";
    private final static String GET_FACTS = "/facts";
    private final static String GET_USERS = "/users";

    public void request() throws Exception {
        String inputLine;
        URL url = new URL(PATH_TO_API + GET_FACTS);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));

        while ((inputLine = in.readLine()) != null) {
                JSONReader jsonReader = new JSONReader(inputLine);
                new FactSerializator().saveArrayOfFactsToFile(jsonReader.factReader());
        }
        in.close();
    }
}