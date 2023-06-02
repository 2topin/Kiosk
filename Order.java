package Kiosk;
// 주문
import java.util.List;

public class Order {
    private List<Item> cart;

    public Order(List<Item> cart) {
        this.cart = cart;
    }

    public void printOrderSummary() {
        System.out.println("[ Order Summary ]");
        for (Item item : cart) {
            System.out.printf("%-15s | W %.1f%n", item.getName(), item.getPrice());
        }
        System.out.println("------------------------");
        System.out.printf("Total: $%.2f%n", calculateTotal());
    }

    private double calculateTotal() {
        double total = 0.0;
        for (Item item : cart) {
            total += item.getPrice();
        }
        return total;
    }

}
