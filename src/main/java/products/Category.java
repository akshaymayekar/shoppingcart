package products;

public enum Category {
    A(10),
    B(20),
    C(0);

    private double tax;

    Category(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }
}
