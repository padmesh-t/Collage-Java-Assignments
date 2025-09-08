package project;
public class FuelEntry {
    private String entryId;
    private Vehicle vehicle;
    private double liters;
    private double pricePerLiter;
    private double odometer;
    private String station;
    public FuelEntry(String entryId, Vehicle vehicle, double liters, double pricePerLiter, double odometer, String station) {
        this.entryId = entryId;
        this.vehicle = vehicle;
        this.liters = liters;
        this.pricePerLiter = pricePerLiter;
        this.odometer = odometer;
        this.station = station;
    }
    public static FuelEntry logFuel(String entryId, Vehicle v, double liters, double pricePerLiter, double odometer, String station) {
        return new FuelEntry(entryId, v, liters, pricePerLiter, odometer, station);
    }
    public static FuelEntry logFuel(String entryId, Vehicle v, int totalAmount, double pricePerLiter, double odometer, String station) {
        double liters = totalAmount / pricePerLiter;
        return new FuelEntry(entryId, v, liters, pricePerLiter, odometer, station);
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getOdometer() {
        return odometer;
    }

    public double totalCost() {
        return liters * pricePerLiter;
    }
    @Override
    public String toString() {
        return "Fuel[" + entryId + " " + liters + "L for " + vehicle.getRegNo() + "]";
    }
}
