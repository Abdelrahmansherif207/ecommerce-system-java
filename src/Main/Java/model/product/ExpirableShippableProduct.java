package Main.Java.model.product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Main.Java.interfaces.Expirable;
import Main.Java.interfaces.Shippable;


public class ExpirableShippableProduct extends BaseProduct implements Shippable, Expirable {
    private LocalDate expiryDate;
    private double weight;

    public ExpirableShippableProduct(String name, double price, Integer stock , LocalDate expiryDate, double weight) {
        super(name, price , stock);
        this.expiryDate = expiryDate;
        this.weight = weight; 
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String getExpirationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return expiryDate.format(formatter);
    }


    @Override
    public double getWeight() {
        return this.weight;
    }
    
    @Override
      public String toString() {
        return getName() + " - $" + getPrice() + " (" + getStock() + " in stock) - Expiry Date: " + getExpirationDate() 
               + " - Weight: " + getWeight();
    }
}