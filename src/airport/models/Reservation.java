package airport.models;

import airport.flights.Flight;
import airport.flights.InternationalFlight;

public class Reservation {
    private String id;
    private Passenger passenger;
    private Flight flight;
    private String status;

    public Reservation(String reservationId, Passenger passenger, InternationalFlight selectedFlight) {
        this.id = reservationId;
        this.passenger = passenger;
        this.flight = selectedFlight;
        this.status = "Pending";
    }

    public Reservation() {

    }

    public boolean confirmReservation() {
        if (passenger != null && flight != null) {
            status = "Confirmed";
            return true;
        }
        return false;
    }

    public void cancelReservation() {
        status = "Cancelled";
    }

    public void updateReservation() {
        System.out.println("Reservation updated");
    }
}