package n01_e01_excepcions;

import n01_e01_excepcions.records.GroceryItem;
import n01_e01_excepcions.saleTypes.Product;
import n01_e01_excepcions.saleTypes.Sale;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ArrayList<Product> groceries = new ArrayList<>();
        List<GroceryItem> items = List.of(
                new GroceryItem("apples", 2.5),
                new GroceryItem("beer", 3.5),
                new GroceryItem("steak", 25),
                new GroceryItem("bananas", 3.85)
        );

        for (GroceryItem item : items) {
            groceries.add(new Product(item.name(), item.price()));
        }

        Sale saleOne = new Sale(groceries);
        double saleOneTotal = saleOne.calculateTotal();
        System.out.println("El total d'aquesta venda ha sigut: " + saleOneTotal);

        // Prova per afegir IndexOutOfBoundsException
        saleOne.getListItem(5);
    }
}
