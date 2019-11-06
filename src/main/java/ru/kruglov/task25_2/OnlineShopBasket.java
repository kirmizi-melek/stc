package ru.kruglov.task25_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OnlineShopBasket implements Basket {
    //ArrayList<Product> productsInTheBasket = new ArrayList<>();
    HashMap<String, Integer> productsInTheBasketH = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        productsInTheBasketH.put(product,quantity);
        //productsInTheBasket.add(new Product(product,quantity));
    }

    @Override
    public void removeProduct(String product){
        if(productsInTheBasketH.containsKey(product)) {
            productsInTheBasketH.remove(product);
        } else {
            //TODO
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if(productsInTheBasketH.containsKey(product)) {
            int oldQuantity = productsInTheBasketH.get(product);
            productsInTheBasketH.replace(product, oldQuantity, quantity);
        } else {
            //TODO
        }
    }

    @Override
    public void clear() {
        productsInTheBasketH.clear();
    }

    @Override
    public List<String> getProductsInTheBasket() {
        ArrayList arrayOfProductsNames = new ArrayList();
        if (productsInTheBasketH != null){
                arrayOfProductsNames.addAll(productsInTheBasketH.keySet());
                return arrayOfProductsNames;
        } else return null;
    }

    @Override
    public int getProductQuantity(String product) {
        int quantity = 0;
        if (productsInTheBasketH != null) {
            quantity = productsInTheBasketH.get(product);
        }
        return quantity;
    }
}
