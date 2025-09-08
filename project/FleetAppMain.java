package project;
import java.time.LocalDate;
public class FleetAppMain{
    public static void main(String[] args) {
        FleetService fs = new FleetService();
        Vehicle car1 = new Car("TN01AB1234", 15000, "Active", LocalDate.of(2025, 1, 1));
        Vehicle truck1 = new Truck("TN09XY9876", 80000, "Active", LocalDate.of(2024, 12, 15));
        Vehicle bike1 = new Bike("TN05ZZ1111", 5000, "Active", LocalDate.of(2024, 6, 1));
        fs.addVehicle(car1);
        fs.addVehicle(truck1);
        fs.addVehicle(bike1);
        FuelEntry f1 = FuelEntry.logFuel("F1", car1, 40, 100, 15200, "HP");
        FuelEntry f2 = FuelEntry.logFuel("F2", truck1, 5000, 100, 80500, "IOCL");
        fs.addFuel(f1);
        fs.addFuel(f2);
        ServiceRecord sr1 = new ServiceRecord("S1", car1, "General", 5000, LocalDate.now(), "Oil Change");
        fs.addService(sr1);
        System.out.println("=== Vehicle List ===");
        fs.printAllVehicles();
        System.out.println("\n=== Fuel Report ===");
        fs.printFuelReport();
        System.out.println("\n=== Service Due Alerts ===");
        fs.serviceDueAlerts();
    }
}