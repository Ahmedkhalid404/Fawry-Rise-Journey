package model.cart;

import interfaces.Shippable;
import interfaces.ShippableItem;
import model.product.Product;

public class CartItem implements ShippableItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public String getName() { return product.getName(); }

    @Override
    public double getWeight() {
        if (product instanceof Shippable s) {
            return s.getWeight();
        }
        return 0;
    }
}
