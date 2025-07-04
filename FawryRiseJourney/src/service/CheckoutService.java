package service;

import model.cart.CartItem;
import model.customer.Customer;
import model.product.ExpirableProduct;
import model.product.Product;
import interfaces.Shippable;
import interfaces.ShippableItem;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer) {
        if (customer.isCartEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        List<CartItem> items = getCartItems(customer);

        List<ShippableItem> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product instanceof Shippable) {
                shippableItems.add(item);
            }
        }


        double subtotal = customer.getCartSubtotal();
        double shippingFees = shippingService.ship(shippableItems);
        double paidAmount = subtotal + shippingFees;

        if (customer.getBalance() < paidAmount) {
            throw new IllegalStateException("Insufficient balance.");
        }

        customer.deduct(paidAmount);

        for (CartItem item : items) {
            Product p = item.getProduct();
            p.setQuantity(p.getQuantity() - item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s : %.2f%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("---------------------------");
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Shipping: %.2f%n", shippingFees);
        System.out.printf("Total paid: %.2f%n", paidAmount);
        System.out.printf("Remaining balance: %.2f%n", customer.getBalance());

        customer.clearCart();
    }

    private static List<CartItem> getCartItems(Customer customer) {
        List<CartItem> items = customer.getCartItems();

        for (CartItem item : items) {
            Product product = item.getProduct();

            if (product instanceof ExpirableProduct expirable) {
                if (expirable.isExpired()) {
                    throw new IllegalStateException("Product " + product.getName() + " is expired.");
                }
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new IllegalStateException("Product " + product.getName() + " is out of stock.");
            }
        }
        return items;
    }
}
