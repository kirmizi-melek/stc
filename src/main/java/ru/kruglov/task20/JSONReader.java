package ru.kruglov.task20;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONReader {
    String inputLine;

    JSONReader(String input) {
        this.inputLine = input;
    }

    public ArrayList<Fact> factReader() {
        JSONObject obj = new JSONObject(inputLine);
        JSONArray arr = obj.getJSONArray("all");
        ArrayList<Fact> facts = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            String factId = arr.getJSONObject(i).getString("_id");
            String factText = arr.getJSONObject(i).getString("text");
            String factType = arr.getJSONObject(i).getString("type");
            int fact_upvotes = arr.getJSONObject(i).getInt("upvotes");
            Fact fact = new Fact();
            fact.setId(factId);
            fact.setText(factText);
            fact.setType(factType);
            facts.add(fact);
        }
        return facts;
    }
}
