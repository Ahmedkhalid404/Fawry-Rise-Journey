package model.product;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;
    public ExpirableProduct(String name, int price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String toString() {
        return "Name : " + getName() + "\n" + "expiryDate : " + expiryDate;
    }
}
