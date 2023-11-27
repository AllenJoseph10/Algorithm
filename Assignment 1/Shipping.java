//import to be included

import java.time.LocalDate;

public class Shipping {
    Order order;
    LocalDate shipDate;
    double shipCost;
    public static int countUrgent;

    public Shipping(Order order, LocalDate shipDate) {
        this.order = order;
        this.shipDate = shipDate;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public double getShipCost() {
        return shipCost;
    }

    public void setShipCost(double shipCost) {
        this.shipCost = shipCost;
    }

    public double calcShipCost(boolean isUrgent) {
        if (isUrgent) {
            countUrgent++;
            return this.shipCost = 5.45;
        }
        else {
            return this.shipCost = 3.95;
        }
    }
}