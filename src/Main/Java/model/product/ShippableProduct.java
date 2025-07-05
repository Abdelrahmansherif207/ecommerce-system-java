package Main.Java.model.product;
import Main.Java.interfaces.Shippable;

public class ShippableProduct extends BaseProduct implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, Integer stock ,  double weight) {
        super(name, price, stock);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ShippableProduct{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", weight=" + weight +
                '}';
    }
}