import orders.Order;
import orders.ProductBill;
import org.junit.Assert;
import org.junit.Test;
import products.Category;
import products.Product;

import java.util.List;

public class ShoppingCartTest {

    @Test
    public void createBlankShoppingCartTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertEquals(0, shoppingCart.cartSize());
    }

    @Test
    public void shouldCalculateTotalPrice() {

        ShoppingCart shoppingCart = new ShoppingCart();
        Product soap = new Product("Dove", 40, Category.A);
        Product toothpaste = new Product("Colgate", 100, Category.B);
        Product washingPowder = new Product("Surf Excel", 200);

        shoppingCart.add(soap, 1);
        shoppingCart.add(toothpaste, 1);
        shoppingCart.add(washingPowder, 1);

        Assert.assertEquals(364, shoppingCart.createOrder().getTotalPrice(), 0);
    }

    @Test
    public void shouldGetProductwiseCostAndTax() {

        ShoppingCart shoppingCart = new ShoppingCart();
        Product soap = new Product("Dove", 40, Category.A);
        Product washingPowder = new Product("Surf Excel", 200);

        shoppingCart.add(soap, 1);
        shoppingCart.add(washingPowder, 1);

        Order order = shoppingCart.createOrder();

        List<ProductBill> productBills = order.getProductBills();
        Assert.assertEquals(2, productBills.size());

        ProductBill productBill = productBills.get(0);
        Assert.assertEquals(soap, productBill.getProduct());
        Assert.assertEquals(4, productBill.calculateTotalTax(), 0);
        Assert.assertEquals(44, productBill.calculateTotalPrice(), 0);

        productBill = productBills.get(1);
        Assert.assertEquals(washingPowder, productBill.getProduct());
        Assert.assertEquals(0, productBill.calculateTotalTax(), 0);
        Assert.assertEquals(200, productBill.calculateTotalPrice(), 0);
    }
}
