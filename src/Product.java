public class Product {

    String name;
    String unit;
    Category category;
    double quantity;

    public Product(String name, String unit, Category category) {
        this.name = name;
        this.unit = unit;
        this.category = category;
    }

    public Product(String name, String unit, Category category, double quantity) {
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }
}
