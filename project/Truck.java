package project;
import java.time.LocalDate;
public class Truck extends Vehicle {
    public Truck(String regNo, double odometer, String status, LocalDate lastServiceDate) {
        super(regNo, "Truck", odometer, status, lastServiceDate);
    }
    @Override
    public LocalDate nextServiceDue() {
        return getLastServiceDate().plusMonths(3);
    }
    @Override
    public double operatingCostPerKm(double totalFuelCost, double totalKm) {
        return (totalFuelCost + 1.5 * totalKm) / totalKm;
    }
}
