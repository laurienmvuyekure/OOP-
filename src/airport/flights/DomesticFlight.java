package airport.flights;

import java.time.LocalDateTime;

public class DomesticFlight extends Flight {

    private String regionCode; // unique attribute

    public DomesticFlight() {
        super();
        this.regionCode = "DOM-XX";
    }

    public DomesticFlight(String flightId, String airline, String from,
                          String to, String dep, LocalDateTime arr,
                          int capacity, String regionCode) {
        super(flightId, airline, from, to, dep, String.valueOf(arr), capacity);
        this.regionCode = regionCode;
    }

    public DomesticFlight(String da101, String deltaAir, String jfk, String lax, LocalDateTime localDateTime, LocalDateTime arr, int capacity, String northeast) {
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String code) {
        this.regionCode = code;
    }

    @Override
    public String getFlightType() {
        return "DOMESTIC";
    }

    @Override
    public long calculateFlightDurationMinutes() {
        // Domestic flights: add 15-min mandatory safety buffer
        return super.calculateFlightDurationMinutes() + 15;
    }

    @Override
    public void displayFlightInfo() {
        System.out.println("** DOMESTIC FLIGHT **");
        System.out.println("   Region Code : " + regionCode);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Region: " + regionCode;
    }
}