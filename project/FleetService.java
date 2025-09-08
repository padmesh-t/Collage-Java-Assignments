package project;
import java.util.*;
public class FleetService {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<ServiceRecord> services = new ArrayList<>();
    private List<FuelEntry> fuels = new ArrayList<>();
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }
    public void addService(ServiceRecord sr) {
        services.add(sr);
        sr.getVehicle().setLastServiceDate(sr.getDate());
    }
    public void addFuel(FuelEntry fe) {
        fuels.add(fe);
        fe.getVehicle().updateOdometer(fe.getOdometer());
    }
    public void printAllVehicles() {
        vehicles.forEach(System.out::println);
    }
    public void printFuelReport() {
        double total = fuels.stream().mapToDouble(FuelEntry::totalCost).sum();
        System.out.println("Total Fuel Expense: " + total);
    }
    public void serviceDueAlerts() {
        vehicles.forEach(v -> System.out.println(v.getRegNo() + " next service: " + v.nextServiceDue()));
    }
}
