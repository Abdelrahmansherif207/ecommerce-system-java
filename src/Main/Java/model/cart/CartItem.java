package Main.Java.model.cart;
import Main.Java.interfaces.Expirable;
import Main.Java.interfaces.Shippable;
import Main.Java.model.product.BaseProduct;

public class CartItem {
    private BaseProduct product;
    private int quantity; 

    public CartItem(BaseProduct product, int quantity) {
        if (quantity > product.getStock()) throw new IllegalArgumentException("Not enough stock");
        this.product = product;
        this.quantity = quantity;
     }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    
    public BaseProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        if (product instanceof Expirable) {
            return ((Expirable) product).isExpired();
        }
        return false;
    }

    public boolean isShippable() {
        return product instanceof Shippable;
    }

    @Override
    public String toString() {
        return product.getName() + " x " + quantity + " = $" + (product.getPrice() * quantity);
    }

}
