package orders;

import org.junit.Assert;
import org.junit.Test;
import products.Category;
import products.Product;

public class OrderTest {

    @Test
    public void getTotalPrice() {

        Order order = new Order();
        Product soap = new Product("Dove", 40, Category.A);
        Product toothpaste = new Product("Colgate", 100, Category.B);
        order.add(soap, 2);
        order.add(toothpaste, 3);
        Assert.assertEquals(448, order.getTotalPrice(), 0);
    }
}
