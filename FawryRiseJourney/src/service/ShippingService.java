package service;

import interfaces.ShippableItem;

import java.util.List;

public class ShippingService {
    public static double costOfKg = 1.5;
    public double ship(List<ShippableItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No shippable items to ship.");
            return 0;
        }

        double totalWeight = 0;

        System.out.println("** Shipment notice **");
        for (ShippableItem item : items) {
            double weightPerUnit = item.getWeight();
            double totalWeightItem = weightPerUnit * item.getQuantity();

            System.out.printf("%dx %s %.0fg%n", item.getQuantity(), item.getName(), totalWeightItem);
            totalWeight += totalWeightItem;
        }

        double totalWeightKg = totalWeight / 1000.0;
        System.out.printf("Total package weight: %.2f kg%n\n", totalWeightKg);
        return totalWeightKg * costOfKg;
    }
}
