package orders;

import products.Product;

public class ProductBill {
    private Product product;

    public ProductBill(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public double calculateTotalPrice() {
        return product.getPrice() + calculateTotalTax();
    }

    public double calculateTotalTax() {
        return Math.round((getProductPrice() * product.getTaxPercentage() * 100) / (100 * 100));
    }

    public double getProductPrice() {
        return product.getPrice();
    }


    @Override
    public String toString() {
        return String.format("%12s\t\t%3.2f\t\t\t%3.2f\t%3.2f", product.getName(), product.getPrice(),
                calculateTotalTax(),
                calculateTotalPrice());
    }
}
