package airport.models;

import airport.flights.Flight;
import airport.system.Gate;

import java.time.LocalDateTime;

public class Schedule {
 
    private String        scheduleId;
    private Flight        flight;
    private Gate gate;
    private LocalDateTime departureTime;
 
    public Schedule() {
        this.scheduleId    = "SCH000";
        this.departureTime = LocalDateTime.now();
    }
 
    public Schedule(String scheduleId, Flight flight, Gate gate, LocalDateTime departureTime) {
        this.scheduleId    = scheduleId;
        this.flight        = flight;
        this.gate          = gate;
        this.departureTime = departureTime;
    }
 
    public String        getScheduleId()                  { return scheduleId; }
    public void          setScheduleId(String id)          { this.scheduleId = id; }
 
    public Flight        getFlight()                      { return flight; }
    public void          setFlight(Flight f)               { this.flight = f; }
 
    public Gate          getGate()                        { return gate; }
    public void          setGate(Gate g)                  { this.gate = g; }
 
    public LocalDateTime getDepartureTime()               { return departureTime; }
    public void          setDepartureTime(LocalDateTime t) { this.departureTime = t; }
 
    @Override
    public String toString() {
        return String.format(
            "[Schedule] ID=%-8s | Flight=%-8s | Gate=%-6s | Departure=%s",
            scheduleId,
            flight != null ? flight.getFlightId() : "N/A",
            gate   != null ? gate.getGateId()     : "N/A",
            departureTime
        );
    }
}