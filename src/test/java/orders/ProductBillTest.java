package orders;

import org.junit.Assert;
import org.junit.Test;
import products.Category;
import products.Product;

public class ProductBillTest {

    @Test
    public void shouldCalculateTheTaxForProduct() {
        Product soap = new Product("Dove", 40, Category.A);
        ProductBill productBill = new ProductBill(soap, 1);
        Assert.assertEquals(4.0, productBill.calculateTotalTax(), 0);
    }

    @Test
    public void shouldCalculateTheTotalPriceForProduct() {
        Product soap = new Product("Dove", 40, Category.A);
        ProductBill productBill = new ProductBill(soap, 2);
        Assert.assertEquals(88.0, productBill.calculateTotalPrice(), 0);
    }
}
