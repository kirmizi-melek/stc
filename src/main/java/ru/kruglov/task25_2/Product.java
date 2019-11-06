package ru.kruglov.task25_2;

import java.util.HashMap;

public class Product {

    String productName;
    int productQuantity;

    Product(String name, int quantity) {
        this.productName = name;
        this.productQuantity = quantity;
    }

    public HashMap<String, Integer> getMapOfProductsFields() {
        HashMap<String, Integer> newHashMap = new HashMap<>();
        newHashMap.put(productName,productQuantity);
        return newHashMap;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
