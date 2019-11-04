package ru.kruglov.task23;

import java.util.ArrayList;
import java.util.List;

public class OnlineShopBasket implements Basket {
    ArrayList<Product> productsInTheBasket = new ArrayList<>();

    private Product getProductByItsName(String productName) {
        Product outputProduct = null;
        for (int i = 0; i < productsInTheBasket.size() ; i++) {
            outputProduct = productsInTheBasket.get(i);
            if (outputProduct.getProductName().equals(productName)) {
                break;
            }
        }
        return outputProduct;
    }

    private int getIdOfProduct(String productName) {
        int index = -1;
        for (int i = 0; i < productsInTheBasket.size() ; i++) {
            String comaparableProductName = productsInTheBasket.get(i).getProductName();
            if (comaparableProductName.equals(productName)){
                index = i;
                break;
            } else {
                System.out.println("Product which you want to delete does not exist \n");
            }
        }
        return index;
    }

    @Override
    public void addProduct(String product, int quantity) {
        productsInTheBasket.add(new Product(product,quantity));
    }

    @Override
    public void removeProduct(String product){
        int idOfProduct = getIdOfProduct(product);
        if ( idOfProduct >= 0 ) {
            productsInTheBasket.remove(productsInTheBasket.get(idOfProduct));
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if(getProductByItsName(product) != null) {
            productsInTheBasket.set(productsInTheBasket.indexOf(getProductByItsName(product)), new Product(product, quantity));
        }
    }

    @Override
    public void clear() {
        productsInTheBasket.clear();
    }

    @Override
    public List<String> getProductsInTheBasket() {
        String productName;
        ArrayList arrayOfProductsNames = new ArrayList();
        if (productsInTheBasket != null){
            for (int i = 0; i < productsInTheBasket.size() ; i++) {
                productName = productsInTheBasket.get(i).getProductName();
                arrayOfProductsNames.add(productName);
            }
            return arrayOfProductsNames;
        } else return null;
    }

    @Override
    public int getProductQuantity(String product) {
        int quantity = 0;
        if (productsInTheBasket != null) {
            for (int i = 0; i < productsInTheBasket.size() ; i++) {
                if (productsInTheBasket.get(i).getProductName().equals(product)) {
                    quantity = productsInTheBasket.get(i).productQuantity;
                }
            }
        }
        return quantity;
    }
}
