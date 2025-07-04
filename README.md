# 🛒 E-Commerce Checkout System

This is a simple Java-based e-commerce checkout system demonstrating **object-oriented programming (OOP)** best practices, including abstraction, interfaces, and polymorphism.

It allows you to:

Define products with name, price, quantity  
Support products that expire (e.g., Cheese, Biscuits)  
Support products that require shipping, with weight info (e.g., TV, Cheese)  
Manage a shopping cart per customer  
Validate quantities and expiration dates during checkout  
Calculate shipping fees  
Generate shipment notices and detailed checkout receipts  
Handle error cases such as:
  - empty cart
  - insufficient customer balance
  - expired products
  - unavailable stock

---

## 🚀 Features

- Object-oriented design with `Product` as the base class
- Interfaces:
  - `Shippable` for products requiring shipment
  - `ShippableItem` for items requiring shipment
- `Customer` owns a single `Cart`
- `Cart` supports adding, removing, and clearing items
- `ShippingService` prints shipment notices with total package weight
- `CheckoutService` validates and finalizes the order

---


## Example Usage

```java
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
```

## Sample console output:

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
1x TV 10000g
Total package weight: 11.10 kg

** Checkout receipt **
2x Cheese : 200.00
1x Biscuits : 150.00
1x TV : 5000.00
1x Mobile Scratch Card : 50.00
---------------------------
Subtotal: 5400.00
Shipping: 16.65
Total paid: 5416.65
Remaining balance: 4583.35
```
