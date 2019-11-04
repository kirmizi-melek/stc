package ru.kruglov.task23;

public class Product {

    String productName;
    int productQuantity;

    Product(String name, int quantity) {
        this.productName = name;
        this.productQuantity = quantity;
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
