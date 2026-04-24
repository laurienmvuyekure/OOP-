package airport.flights;

import java.time.LocalDateTime;

public class EmergencyFlight extends Flight {

    private int emergencyLevel; // 1 (low) – 5 (critical)

    public EmergencyFlight() {
        super();
        this.emergencyLevel = 1;
    }

    public EmergencyFlight(String flightId, String airline, String from,
            String to, LocalDateTime dep, LocalDateTime arr,
            int capacity, int emergencyLevel) {
        super();
        this.flightId = flightId;
        this.airlineName = airline;
        this.departure = from;
        this.destination = to;
        this.departureTime = dep.toString();
        this.arrivalTime = arr.toString();
        this.capacity = capacity;
        this.emergencyLevel = Math.min(5, Math.max(1, emergencyLevel));
    }

    public EmergencyFlight(String ef505, String airAmbulance, String jfk, String bos, LocalDateTime localDateTime, LocalDateTime localDateTime1, int i, int i1, String medicalEmergency) {
    }

    public int getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(int lvl) {
        this.emergencyLevel = Math.min(5, Math.max(1, lvl));
    }

    @Override
    public String getFlightType() {
        return "EMERGENCY";
    }

    @Override
    public long calculateFlightDurationMinutes() {
        // Emergency flights get priority — duration reduced proportionally
        long base = super.calculateFlightDurationMinutes();
        double reduction = 1.0 - (emergencyLevel * 0.05);
        return (long) (base * reduction);
    }

    @Override
    public void displayFlightInfo() {
        System.out.println("** EMERGENCY FLIGHT ** LEVEL: " + emergencyLevel);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Emergency Level: " + emergencyLevel + "/5";
    }
}