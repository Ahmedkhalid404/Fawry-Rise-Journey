package model.product;

import java.time.LocalDate;

import interfaces.Shippable;

public class ExpirableShippableProduct extends ExpirableProduct implements Shippable {
    private double weight;

    public ExpirableShippableProduct(String name, int price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
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
        return "Name : " + getName() + "\n" + "Weight : " + weight + "\n" + "ExpiryDate : " + getExpiryDate();
    }
}
