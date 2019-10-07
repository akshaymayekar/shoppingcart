import orders.Order;
import products.Category;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Please ignore the logic and formatting in this class as it is only to create console UI for the user.
public class ShoppersZone {

    public static void main(String[] args) {
        List<Product> allProducts = getAllProducts();
        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("** ShoppersZone ** \t\t Cart(" + shoppingCart.cartSize() + ")");
            for (int i = 0; i < allProducts.size(); i++) {
                Product product = allProducts.get(i);
                System.out.println((i + 1) + ". " + product.getName() + "\t\t" + product.getPrice());
            }
            System.out.print(" Add product to cart ( or Enter X to proceed for Bill) : ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("X")) {
                break;
            }
            int productIndex = Integer.parseInt(input);
            shoppingCart.add(allProducts.get(productIndex - 1), 1);
        }

        Order order = shoppingCart.createOrder();
        order.printOrderBill();
    }

    private static List<Product> getAllProducts() {
        return new ArrayList<Product>() {{
            add(new Product("Dove", 40, Category.A));
            add(new Product("Colgate", 100, Category.B));
            add(new Product("Surf Excel", 200));
        }};
    }
}
