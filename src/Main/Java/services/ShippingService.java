package Main.Java.services;
import Main.Java.interfaces.Shippable;
import Main.Java.interfaces.ShippingServiceInterface;
import java.util.List;

public class ShippingService implements ShippingServiceInterface {
    @Override
    public void shipItems(List<Shippable> items) {
        System.out.println("Shipping the following items:");
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + "kg)");
        }
    }
}
