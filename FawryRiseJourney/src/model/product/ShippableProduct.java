package model.product;

import interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    private double weight;
    public ShippableProduct(String name, int price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Name : " + getName() + "\n" + "Weight : " + weight;
    }
}
