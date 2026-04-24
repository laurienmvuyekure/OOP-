package airport.models;

import airport.flights.Flight;
import airport.flights.InternationalFlight;

public class Ticket {
    private String id;
    private Passenger passenger;
    private Flight flight;
    private String seat;
    private double price;

    public Ticket(String ticketId, Passenger passenger, InternationalFlight selectedFlight, String seatNumber,
            String classType) {
        this.id = ticketId;
        this.passenger = passenger;
        this.flight = selectedFlight;
        this.seat = seatNumber;
        this.price = calculatePrice(classType);
    }

    private double calculatePrice(String classType) {
        // Base price for international flight
        double basePrice = 500.0;
        switch (classType.toLowerCase()) {
            case "business":
                return basePrice * 2.5;
            case "first":
                return basePrice * 4.0;
            default:
                return basePrice;
        }
    }

    public double calculatePrice() {
        return price;
    }

    public void generateDetails() {
        System.out.println("Ticket: " + passenger + " - " + flight);
    }

    public double getPrice() {
        return price;
    }

    public String generateTicketDetails() {
        return String.format("Ticket ID: %s | Passenger: %s | Flight: %s | Seat: %s | Price: $%.2f",
                id, passenger.getFullName(), ((InternationalFlight) flight).getFlightId(), seat, price);
    }
}