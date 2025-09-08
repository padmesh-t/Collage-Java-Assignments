package project;
import java.time.LocalDate;
public class Car extends Vehicle {
    public Car(String regNo, double odometer, String status, LocalDate lastServiceDate) {
        super(regNo, "Car", odometer, status, lastServiceDate);
    }
    @Override
    public LocalDate nextServiceDue() {
        return getLastServiceDate().plusMonths(6);
    }
    @Override
    public double operatingCostPerKm(double totalFuelCost, double totalKm) {
        return (totalFuelCost + 0.5 * totalKm) / totalKm;
    }
}
