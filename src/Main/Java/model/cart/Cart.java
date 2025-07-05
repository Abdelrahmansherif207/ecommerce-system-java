package Main.Java.model.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Main.Java.model.product.BaseProduct;


public class Cart {
    private List<CartItem> items = new ArrayList<>();    
    private String ownerName;

    public Cart(String owner) {
        this.ownerName=owner;
    }
    public void addItem(BaseProduct product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public double getSubTotal() {
        return items.stream()
                    .mapToDouble(item -> item.getTotalPrice())
                    .sum();
    }

    public void clear() {
        items.clear();
    }
}
