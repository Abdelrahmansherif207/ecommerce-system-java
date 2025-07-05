package Main.Java.model.product;

/*
 * BasicProduct.java
 * This class represents a basic product (neither shippable nor expirable ) with a name, price, and stock.
 * It extends the BaseProduct class and provides a simple implementation.
 */
public class BasicProduct extends BaseProduct {
    
    public BasicProduct(String name, double price, Integer stock) {
        super(name, price, stock);
    }

    @Override
    public String toString() {
        return getName() + " - $" + getPrice() + " (" + getStock() + " in stock)";
    }
}