package Main.Java.ui;

import java.time.LocalDate;

import Main.Java.Builder.ProductBuilder;
import Main.Java.model.Customer;
import Main.Java.model.product.*;
import Main.Java.services.ShippingService;

public class ConsoleApp {
    public void run() {
        System.out.println("Welcome to the Console E-commerce App!");
        System.out.println("========================================");

        // Product creation
        BaseProduct cheese = new ProductBuilder()
            .setType(ProductTypeEnum.EXPIRABLE_SHIPPABLE)
            .setName("Cheddar Cheese")
            .setPrice(4.0)
            .setStock(10)
            .setExpiryDate(LocalDate.now().plusDays(3))
            .setWeight(0.6)
            .build();

        BaseProduct tv = new ProductBuilder()
            .setType(ProductTypeEnum.SHIPPABLE)
            .setName("Samsung TV")
            .setPrice(1500.0)
            .setStock(5)
            .setWeight(18.0)
            .build();

        BaseProduct biscuits = new ProductBuilder()
            .setType(ProductTypeEnum.EXPIRABLE)
            .setName("Biscuits")
            .setPrice(2.5)
            .setStock(20)
            .setExpiryDate(LocalDate.now().plusDays(5))
            .build();

        BaseProduct scratchCard = new ProductBuilder()
            .setType(ProductTypeEnum.BASIC)
            .setName("Mobile Recharge")
            .setPrice(10.0)
            .setStock(50)
            .build();


        // Customer Register
        Customer customer = new Customer("Alice", 2000.0);
        System.out.println("Customer Registered: " + customer.getName() + " with balance $" + customer.getBalance());
        System.out.println("========================================");
        // Adding to cart
        try {
            customer.addToCart(cheese, 2);
            customer.addToCart(tv, 1);
            customer.addToCart(biscuits, 3);
            customer.addToCart(scratchCard, 5);
            // customer.addToCart(cheese, 11); //! This will throw an exception due to insufficient stock


            System.out.println("User Cart: " + customer.getCart().getItems());
            System.out.println("Total Cart Value: " + customer.getCart().getSubTotal());
        } catch (Exception e) {
            System.out.println(" Error adding to cart: " + e.getMessage());
        }
        System.out.println("========================================");
        // Checkout
        ShippingService shippingService = new ShippingService();
        try {
            customer.checkout(shippingService);
        } catch (Exception e) {
            System.out.println(" Checkout failed: " + e.getMessage());
        }
    }  
}
