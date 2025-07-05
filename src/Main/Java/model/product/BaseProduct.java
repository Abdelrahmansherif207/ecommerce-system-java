package Main.Java.model.product;

/*
 * BaseProduct.java
 * This class represents a base product with a name, price, and stock.
 * It provides methods to get product details and manage stock.
 * It is an abstract class that should be extended by specific product types.
 */
public abstract class BaseProduct {
    private String name;
    private double price;
    private Integer stock;

    public BaseProduct(String name, double price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock");
        }
    }

    @Override
    public abstract String toString();
}
