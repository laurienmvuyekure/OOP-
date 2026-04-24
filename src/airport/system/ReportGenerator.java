package airport.system;

import airport.flights.InternationalFlight;
import airport.models.Passenger;
import airport.models.Payment;
import airport.models.Schedule;

import java.util.List;

public class ReportGenerator {

    public ReportGenerator(List<InternationalFlight> flights, List<Passenger> passengers, List<Payment> payments, List<Schedule> schedules) {
    }

    public void generateDailyFlights() {
        System.out.println("Daily flight report");
    }

    public void generateRevenue() {
        System.out.println("Revenue report");
    }

    public void generateDelays() {
        System.out.println("Delay report");
    }

    public boolean generateDailyFlightsReport() { return true;
    }

    public boolean generatePassengerStatistics() { return generatePassengerStatistics();
    }

    public boolean generateRevenueReport() { return true;
    }
}