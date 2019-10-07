package orders;

import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<ProductBill> productBills;

    public Order() {
        this.productBills = new ArrayList<>();
    }

    public void add(Product product, Integer quantity) {
        productBills.add(new ProductBill(product, quantity));
    }

    public double getTotalPrice() {
        return productBills.stream()
                .map(ProductBill::calculateTotalPrice)
                .mapToDouble(value -> value)
                .sum();
    }

    public List<ProductBill> getProductBills() {
        return productBills;
    }

    // Please ignore the console logging in this method. This is just for the purpose of console UI for shopping cart.
    public void printOrderBill() {
        System.out.println("\n\n============================ Bill ============================");
        System.out.println(String.format("%12s\t%12s%12s%8s\t%8s", "Product", "Unit Price", "Quantity", "Tax",
                "Total Price"));
        productBills.forEach(productBill -> {
            System.out.println(productBill.toString());
        });
        System.out.println("============================================================");
        System.out.println("Total = " + String.format("%3.2f", getTotalPrice()) + " Rupeess");

    }
}
