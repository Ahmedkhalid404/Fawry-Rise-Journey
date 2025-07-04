import model.customer.Customer;
import model.product.ExpirableShippableProduct;
import model.product.Product;
import model.product.ShippableProduct;
import service.CheckoutService;
import service.ShippingService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpirableShippableProduct("Cheese", 100, 10, LocalDate.of(2025, 7, 4), 200);

        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 5, LocalDate.of(2025, 7, 4), 700);

        Product tv = new ShippableProduct("TV", 5000, 2, 10000);

        Product scratchCard = new Product("Mobile Scratch Card", 50, 100);

        Customer customer = new Customer("Ahmed", 10000);

        customer.addProductToCart(cheese, 2);
        customer.addProductToCart(biscuits, 1);
        customer.addProductToCart(tv, 1);
        customer.addProductToCart(scratchCard, 1);

        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        checkoutService.checkout(customer);
    }
}