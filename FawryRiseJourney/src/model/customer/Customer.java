package model.customer;

import model.product.Product;
import model.cart.Cart;
import model.cart.CartItem;

import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private final Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public double deduct(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;

        return balance;
    }

    public void addProductToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }
    public void setQuantityToProductInCart(Product product, int quantity){
        cart.setQuantity(product, quantity);
    }
    public void removeProductFromCart(Product product) {
        cart.removeProduct(product);
    }
    public void clearCart(){
        cart.clear();
    }
    public void showItemsInCart(){
        List<CartItem> items = cart.getItems();
        int cnt = 1;
        for (CartItem item : items) {
            System.out.println("Product - " + cnt++ + " : \n" +
                                item.getProduct().toString() + "\n" +
                                "Unit Price : " + item.getProduct().getPrice() + "\n" +
                                "Quantity   : " + item.getQuantity() + "\n" +
                                "Price      : " + (item.getProduct().getPrice() * item.getQuantity()) );
            System.out.println("\n================================\n");
        }

        System.out.println("Total price : " + getCartSubtotal());
    }

    public List<CartItem> getCartItems() {
        return cart.getItems();
    }

    public double getCartSubtotal(){
        return cart.getSubtotal();
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }
}
