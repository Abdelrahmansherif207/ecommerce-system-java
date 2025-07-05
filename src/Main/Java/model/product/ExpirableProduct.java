package Main.Java.model.product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Main.Java.interfaces.Expirable;

public class ExpirableProduct extends BaseProduct implements Expirable {

    private LocalDate expiryDate; 

    public ExpirableProduct(String name, double price, Integer stock, LocalDate expiryDate) {
        super(name, price, stock);
        this.expiryDate = expiryDate; 
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
    public String toString() {
        return getName() + " - $" + getPrice() + " (" + getStock() + " in stock) - Expiry Date: " + getExpirationDate();
    }
}
