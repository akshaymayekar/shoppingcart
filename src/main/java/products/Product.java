package products;

import java.util.Objects;
import java.util.StringJoiner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        return Objects.equals(this.category, that.category) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, price);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("category = " + category)
                .add("name = " + name)
                .add("price = " + price)
                .toString();
    }
}
