package products;

public class Product {
    private final String name;
    private final double price;
    private final Category category;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.category = Category.C;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxPercentage() {
        return category.getTax();
    }
}
