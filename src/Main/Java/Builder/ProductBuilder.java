
package Main.Java.Builder;

import java.time.LocalDate;

import Main.Java.model.product.*;
import Main.Java.Factory.ProductFactory;

public class ProductBuilder {
    private String name;
    private double price;
    private int stock;
    private LocalDate expiryDate;
    private double weight;
    private ProductTypeEnum type;

    public ProductBuilder setType(ProductTypeEnum type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public ProductBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public BaseProduct build() {
        return ProductFactory.createProduct(type, name, price, stock, expiryDate, weight);
    }
}
