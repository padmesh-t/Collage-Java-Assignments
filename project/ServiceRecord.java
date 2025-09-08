package project;
import java.time.LocalDate;
public class ServiceRecord {
    private String recordId;
    private Vehicle vehicle;
    private String serviceType;
    private double cost;
    private LocalDate date;
    private String notes;
    public ServiceRecord(String recordId, Vehicle vehicle, String serviceType, double cost, LocalDate date, String notes) {
        this.recordId = recordId;
        this.vehicle = vehicle;
        this.serviceType = serviceType;
        this.cost = cost;
        this.date = date;
        this.notes = notes;
    }
    public double getCost() {
    	return cost;
    }
    public Vehicle getVehicle() { 
    	return vehicle;
    }
    public LocalDate getDate() {
    	return date;
   }
    @Override
    public String toString() {
        return "Service[" + recordId + " for " + vehicle.getRegNo() + " on " + date + "]";
    }
}
