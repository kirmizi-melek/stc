package ru.kruglov.task23;

import java.util.List;

interface Basket {

    void addProduct(String product, int quantity);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProductsInTheBasket();

    int getProductQuantity(String product);

}
