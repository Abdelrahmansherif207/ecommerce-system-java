package Main.Java.model;

import Main.Java.interfaces.Expirable;
import Main.Java.interfaces.Shippable;
import Main.Java.model.cart.Cart;
import Main.Java.model.product.BaseProduct;
import Main.Java.services.ShippingService;
import Main.Java.model.cart.CartItem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart(this.name);
    }
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(BaseProduct product, int quantity) {
        System.err.println("Adding " + quantity + " of " + product.getName() + " to cart.");
        cart.addItem(product, quantity);
    }
    
    public void checkout (ShippingService shippingService) {
        List<CartItem> items = this.cart.getItems();

        if(cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subTotal = this.cart.getSubTotal();
        double shippingFees= 0;
        List<Shippable> toShip = new ArrayList<>();

        for(CartItem item : items) {
            BaseProduct product = item.getProduct();

            if(product instanceof Expirable) {
                if(((Expirable) product).isExpired()) {
                    throw new IllegalStateException("Product " + product.getName() + " is expired.");
                }
            }

            if(product instanceof Shippable) {
                double weight = (((Shippable) product).getWeight());
                shippingFees += weight * item.getQuantity();
                toShip.add((Shippable) product);
            }

            if (item.getQuantity() > product.getStock()) {
                throw new IllegalStateException("Not enough stock for " + product.getName());
            }
        }

        double total = subTotal + shippingFees;

        if (balance < total) {
            throw new IllegalStateException("Insufficient balance.");
        }

        for(CartItem item : items) {
            item.getProduct().decreaseStock(item.getQuantity());
        }

        balance -= total;

        if (!toShip.isEmpty()) {
            shippingService.shipItems(toShip);
        }

        printSummary(cart.getOwnerName(), subTotal, shippingFees, total, balance);
    }


    private void printSummary (String name , double subtotal , double shippingFees, double total , double balance) {
        System.out.println("\nCheckout Complete!");
        System.out.println("Customer: " + name);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping Fees: $" + shippingFees);
        System.out.println("Total Paid: $" + total);
        System.out.println("Remaining Balance: $" + balance);

        cart.clear();
    }
}
