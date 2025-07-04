package model.cart;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > product.getQuantity()) {
                    throw new IllegalArgumentException("Not enough stock available");
                }
                items.remove(item);
                items.add(new CartItem(product, newQuantity));
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void setQuantity(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                items.remove(item);
                items.add(new CartItem(product, quantity));
                return;
            }
        }
    }

    public void removeProduct(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                items.remove(item);
                return;
            }
        }
    }

    public void clear() {
        items.clear();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
