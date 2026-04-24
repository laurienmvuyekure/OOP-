package airport.flights;

import java.time.LocalDateTime;
import java.util.Collection;

public class Flight {
    protected String flightId;
    protected String airlineName;
    protected String departure;
    protected String destination;
    protected String departureTime;
    protected String arrivalTime;
    protected int capacity;

    public Flight() {
    }

    public Flight(String id, String airline, String dep, String dest,
                  String dep2, String arr, int cap) {
        this.flightId = id;
        this.airlineName = airline;
        this.departure = dep;
        this.destination = dest;
        this.departureTime = dep2;
        this.arrivalTime = arr;
        this.capacity = cap;
    }

    public void calculateDuration() {
        System.out.println("Duration calculated (simplified).");
    }

    @Override
    public String toString() {
        return airlineName + " (" + flightId + ")";
    }

    public Object getFlightId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFlightId'");
    }

    public Object getDepartureLocation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartureLocation'");
    }

    public long calculateFlightDurationMinutes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateFlightDurationMinutes'");
    }

    public void displayFlightInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayFlightInfo'");
    }

    public String getFlightType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFlightType'");
    }

    public LocalDateTime getDepartureTime() { return getDepartureTime();
    }

    public Collection<Object> getBookedPassengers() { return getBookedPassengers();
    }

    public String getCapacity() { return getFlightType();
    }
}