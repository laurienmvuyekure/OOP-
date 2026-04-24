package airport.flights;

import java.time.LocalDateTime;

public class CargoFlight extends Flight {
    private double maxCargo;

    public CargoFlight(String id, String airline, String from, String to, LocalDateTime dep, LocalDateTime arr,
            int capacity, double maxCargo) {
        super(id, airline, from, to, dep.toString(), arr.toString(), capacity);
        this.maxCargo = maxCargo;
    }
}
