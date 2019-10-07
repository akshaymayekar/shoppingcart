import orders.Order;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ShoppingCart {

    private List<Product> allProducts;

    public ShoppingCart() {
        this.allProducts = new ArrayList<>();
    }

    public int cartSize() {
        return allProducts.size();
    }

    public void add(Product product, int quantity) {
        IntStream.range(0, quantity).forEach(index -> allProducts.add(product));
    }

    public Order createOrder() {
        Order order = new Order();
        allProducts.forEach(order::add);
        return order;
    }
}
