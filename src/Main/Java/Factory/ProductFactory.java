package Main.Java.Factory;

import Main.Java.model.product.*;
import java.time.LocalDate;


public class ProductFactory {

    public static BaseProduct createProduct(ProductTypeEnum type, String name, double price, int stock) {
        return createProduct(type, name, price, stock, null, 0.0);
    }

    public static BaseProduct createProduct(ProductTypeEnum type, String name, double price, int stock, LocalDate expiryDate, double weight) {
        switch (type) {
            case BASIC:
                return new BasicProduct(name, price, stock);
            case SHIPPABLE:
                return new ShippableProduct(name, price, stock, weight);
            case EXPIRABLE:
                return new ExpirableProduct(name, price, stock, expiryDate);
            case EXPIRABLE_SHIPPABLE:
                return new ExpirableShippableProduct(name, price, stock, expiryDate, weight);
            default:
                throw new IllegalArgumentException("Unsupported product type");
        }
    }
}