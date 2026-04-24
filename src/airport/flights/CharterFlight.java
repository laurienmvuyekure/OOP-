package airport.flights;

import java.time.LocalDateTime;

public class CharterFlight extends Flight {
    private String client;
    private boolean isLuxury;

    public CharterFlight(String id, String airline, String from, String to, LocalDateTime dep, LocalDateTime arr,
            int capacity, String client, boolean isLuxury) {
        super(id, airline, from, to, dep.toString(), arr.toString(), capacity);
        this.client = client;
        this.isLuxury = isLuxury;
    }
}
