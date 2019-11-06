package ru.kruglov.task25_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        OnlineShopBasket basket = new OnlineShopBasket();

        main.addProductToBasket(basket);
        System.out.println("Default basket");
        main.getProductsFromBasket(basket);

        main.removeProductFromBasket(basket, "Milk");
        System.out.println("Basket after deleting milk");
        main.getProductsFromBasket(basket);

        main.updateProductInBasket(basket, "Potatoes", 999);
        System.out.println("Basket after increnent count of Potatoes");
        main.getProductsFromBasket(basket);
    }

    void addProductToBasket(OnlineShopBasket basket) {
        basket.addProduct("Milk", 1);
        basket.addProduct("Carrot", 10);
        basket.addProduct("Bread", 2);
        basket.addProduct("Potatoes", 3);
    }

    void removeProductFromBasket(OnlineShopBasket basket, String productName) {
            basket.removeProduct(productName);
    }

    void updateProductInBasket(OnlineShopBasket basket, String productName, int quantity) {
        basket.updateProductQuantity(productName, quantity);
    }

    void getProductsFromBasket(OnlineShopBasket basket) {
        String productName;
        ArrayList arrayOfProductsNames = (ArrayList) basket.getProductsInTheBasket();
        for (int i = 0; i < arrayOfProductsNames.size() ; i++) {
            productName = (String) arrayOfProductsNames.get(i);
            System.out.printf("[#"+i + ": %s, %s pcs.]",
                    productName,
                    basket.getProductQuantity(productName));
        }
        System.out.print("\n");
    }

}
