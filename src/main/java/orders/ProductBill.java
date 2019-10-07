package orders;

import products.Product;

import java.util.Objects;

public class ProductBill {
    private Product product;
    private Integer quantity;

    public ProductBill(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double calculateTotalPrice() {
        return (quantity * product.getPrice() + calculateTotalTax());
    }

    public double calculateTotalTax() {
        return (quantity * getProductPrice() * product.getTaxPercentage() * 100) / (100 * 100);
    }

    public double getProductPrice() {
        return product.getPrice();
    }


    @Override
    public String toString() {
        return String.format("%12s\t\t%3.2f\t\t%2d\t\t\t%3.2f\t%3.2f", product.getName(), product.getPrice(),
                quantity,
                calculateTotalTax(),
                calculateTotalPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBill that = (ProductBill) o;

        return Objects.equals(this.product, that.product) &&
                Objects.equals(this.quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
