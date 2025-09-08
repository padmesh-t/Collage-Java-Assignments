package project;
import java.time.LocalDate;
public class Bike extends Vehicle {
    public Bike(String regNo, double odometer, String status, LocalDate lastServiceDate) {
        super(regNo, "Bike", odometer, status, lastServiceDate);
    }
    @Override
    public LocalDate nextServiceDue() {
        return getLastServiceDate().plusMonths(12);
    }
    @Override
    public double operatingCostPerKm(double totalFuelCost, double totalKm) {
        return (totalFuelCost + 0.2 * totalKm) / totalKm;
    }
}