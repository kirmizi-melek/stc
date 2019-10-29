package ru.kruglov.task19;

import java.util.HashMap;

public class Product {
    private String name;
    private float count;
    private float price;
    private float cost;
    private float priceInCents;
    private float costInCents;

    Product(String name, float count, float price) throws ProductIsNotValidException {
        if (!name.equals("") && count > 0f && price > 0f) {
            this.name = name;
            this.count = count;
            this.price = price;
            countCost();
        } else throw new ProductIsNotValidException(name, count, price);
    }

    private void countCost() {
        priceToPriceInCents();
        costInCentsCounter();
        costInCentsToCost();
    }

    public HashMap<String, String> getInstanceFields() {
        HashMap<String, String> instanceFields = new HashMap<>();
        instanceFields.put("name", this.name);
        instanceFields.put("price", String.valueOf(this.price));
        instanceFields.put("count", String.valueOf(this.count));
        instanceFields.put("cost", String.valueOf(this.cost));
        return instanceFields;
    }

    private void priceToPriceInCents() {
        this.priceInCents = Math.round(this.price * 100);
    }

    private void costInCentsCounter() {
        this.costInCents = Math.round(this.priceInCents * this.count);
    }

    private void costInCentsToCost() {
        this.cost = this.costInCents/100;
    }


}
