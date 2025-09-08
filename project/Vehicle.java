package project;

import java.time.LocalDate;

public class Vehicle {
    private String regNo;
    private String type;
    private double odometer;
    private String status;
    private LocalDate lastServiceDate;
    public Vehicle(String regNo, String type, double odometer, String status, LocalDate lastServiceDate) {
        this.regNo = regNo;
        this.type = type;
        this.odometer = odometer;
        this.status = status;
        this.lastServiceDate = lastServiceDate;
    }
    public void updateOdometer(double newReading) {
        if (newReading > this.odometer) {
            this.odometer = newReading;
        }
    }
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
    public String getRegNo() { 
    	return regNo; 
    }
    public String getType() { 
    	return type;
    }
    public double getOdometer() { 
    	return odometer;
    }
    public String getStatus() {
    	return status;
    }
    public LocalDate getLastServiceDate() {
    	return lastServiceDate; 
    }
    public void setLastServiceDate(LocalDate date) {
        this.lastServiceDate = date;
    }
    public LocalDate nextServiceDue() {
        return lastServiceDate.plusMonths(6);
    }
    public double operatingCostPerKm(double totalFuelCost, double totalKm) {
        return totalFuelCost / totalKm;
    }
    @Override
    public String toString() {
        return regNo + " (" + type + "), Odometer: " + odometer + ", Status: " + status;
    }
}
