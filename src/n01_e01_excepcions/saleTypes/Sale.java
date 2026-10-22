package n01_e01_excepcions.saleTypes;

import n01_e01_excepcions.exceptions.EmptySaleException;

import java.util.ArrayList;

public class Sale {

    private ArrayList<Product> productList;
    private double totalPrice;

    public Sale(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getListItem(int index) {
        Product listItem = this.productList.get(index);
        return listItem.toString();
    }

    public double calculateTotal() {
        if (productList == null || productList.isEmpty()) {
            throw new EmptySaleException("Per fer una venda primer has d’afegir productes");
        }
        for (Product prod : productList) {
            totalPrice += prod.getPrice();
        }
        return totalPrice;
    }

}
