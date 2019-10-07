import orders.Order;
import products.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Product, Integer> allProducts;

    public ShoppingCart() {
        this.allProducts = new LinkedHashMap<>();
    }

    public int cartSize() {
        return allProducts.values().stream().mapToInt(s -> s).sum();
    }

    public void add(Product product, int quantity) {
        if (allProducts.containsKey(product)) {
            int currentQuantity = allProducts.get(product);
            allProducts.put(product, currentQuantity + quantity);
        } else {
            allProducts.put(product, quantity);
        }
    }

    public Order createOrder() {
        Order order = new Order();
        allProducts.forEach(order::add);
        return order;
    }
}
