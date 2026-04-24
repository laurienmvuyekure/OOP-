package airport.system;

import airport.flights.CharterFlight;
import airport.flights.Flight;
import airport.flights.DomesticFlight;
import airport.flights.InternationalFlight;
import airport.flights.CargoFlight;
import airport.flights.EmergencyFlight;
import airport.models.*;
import airport.staff.CabinCrew;
import airport.staff.Pilot;
import airport.staff.SecurityOfficer;
import airport.utils.InputValidator;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Collections.singletonList;

public class AirportSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<InternationalFlight> flights = new ArrayList<InternationalFlight>();
    private static final List<Passenger> passengers = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final List<Ticket> tickets = new ArrayList<>();
    private static final List<Payment> payments = new ArrayList<>();
    private static final List<Schedule> schedules = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   ADVANCED AIRPORT MANAGEMENT SYSTEM   ");
        System.out.println("=========================================");

        // initializeDemoFlights();

        while (true) {
            displayMainMenu();
            int choice = getValidIntInput("Enter your choice: ", 0, 8);

            switch (choice) {
                case 1:
                    bookFlight();
                    break;
                case 2:
                    viewFlights();
                    break;
                case 3:
                    viewPassengers();
                    break;
                case 4:
                    generateReports();
                    break;
                case 5:
                    manageStaff();
                    break;
                case 6:
                    manageBaggage();
                    break;
                case 7:
                    securityCheck();
                    break;
                case 8:
                    System.out.println("Thank you for using Airport Management System!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Book Flight");
        System.out.println("2. View Available Flights");
        System.out.println("3. View Passengers");
        System.out.println("4. Generate Reports");
        System.out.println("5. Manage Staff");
        System.out.println("6. Manage Baggage");
        System.out.println("7. Security Check");
        System.out.println("8. Exit");
        System.out.println("===============================");
    }

    private static void initializeDemoFlights() {
        flights.add(new DomesticFlight("DA101", "Delta Air", "JFK", "LAX",
                LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(6),
                150, "NORTHEAST"));

        flights.add(new InternationalFlight("IA202", "Emirates", "JFK", "DXB",
                LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(12),
                300, true, "Visa required for UAE"));

        flights.add(new CargoFlight("CF303", "FedEx", "JFK", "ORD",
                LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(2),
                0, 50000.0));

        flights.add(new CharterFlight("CF404", "Private Jet", "TEB", "MIA",
                LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(3),
                12, "Laurien", true));

        flights.add(new EmergencyFlight("EF505", "Air Ambulance", "JFK", "BOS",
                LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3),
                6, 5, "Medical Emergency"));
    }

    private static void bookFlight() {
        System.out.println("\n========== FLIGHT BOOKING ==========");

        // Get passenger details
        System.out.print("Enter passenger ID: ");
        String passengerId = scanner.nextLine();

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        while (!Boolean.parseBoolean(InputValidator.validateNotEmpty(fullName, "Full name"))) {
            System.out.print("Enter full name: ");
            fullName = scanner.nextLine();
        }

        System.out.print("Enter passport number: ");
        String passportNumber = scanner.nextLine();
        while (!Boolean.parseBoolean(InputValidator.validatePassportNumber(passportNumber))) {
            System.out.print("Enter passport number: ");
            passportNumber = scanner.nextLine();
        }

        System.out.print("Enter nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Passenger passenger = new Passenger(passengerId, fullName, passportNumber, nationality, phoneNumber);
        passengers.add(passenger);

        // Select flight
        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i));
        }

        int flightChoice = getValidIntInput("Select flight: ", 1, flights.size());
        InternationalFlight selectedFlight = flights.get(flightChoice - 1);

        // Check capacity
        if (!InputValidator.validateOverbooking(selectedFlight, 1)) {
            System.out.println("Cannot book this flight due to capacity constraints.");
            return;
        }

        // Create reservation
        String reservationId = "RES" + System.currentTimeMillis();
        Reservation reservation = new Reservation(reservationId, passenger, (InternationalFlight) selectedFlight);

        if (reservation.confirmReservation()) {
            System.out.println("Reservation confirmed!");
            reservations.add(reservation);

            // Create ticket
            String ticketId = "TKT" + System.currentTimeMillis();
            System.out.print("Enter seat number (e.g., A1): ");
            String seatNumber = scanner.nextLine();
            while (!Boolean.parseBoolean(InputValidator.validateSeatNumber(seatNumber))) {
                System.out.print("Enter seat number (e.g., A1): ");
                seatNumber = scanner.nextLine();
            }

            System.out.print("Enter class type (Economy/Business/First): ");
            String classType = scanner.nextLine();

            Ticket ticket = new Ticket(ticketId, passenger, (InternationalFlight) selectedFlight, seatNumber,
                    classType);
            tickets.add(ticket);

            // Process payment
            System.out.println("\nTicket Price: $" + ticket.getPrice());
            System.out.print("Enter payment method (Credit Card/PayPal/Cash): ");
            String paymentMethod = scanner.nextLine();

            String paymentId = "PAY" + System.currentTimeMillis();
            Payment payment = new Payment(paymentId, ticket.getPrice(), paymentMethod);
            payment.processPayment();
            payments.add(payment);

            // Generate boarding pass
            String boardingPassId = "BP" + System.currentTimeMillis();
            BoardingPass boardingPass = new BoardingPass(boardingPassId, ticket,
                    "GATE" + (new Random().nextInt(20) + 1),
                    selectedFlight.getDepartureTime().minusHours(1));

            // Display all details
            System.out.println(ticket.generateTicketDetails());
            System.out.println(boardingPass.generateBoardingPass());
            System.out.printf("Payment Receipt: %s - $%.2f - Status: %s%n",
                    paymentId, payment.getAmount(), payment.getPaymentStatus());

            // Send notification
            Notification notification = new Notification("NOTIF" + System.currentTimeMillis(),
                    "Your booking is confirmed for flight " + selectedFlight.getFlightId(),
                    passenger.getPhoneNumber());
            notification.send();

        } else {
            System.out.println("Reservation failed!");
        }
    }

    private static void viewFlights() {
        System.out.println("\n========== ALL FLIGHTS ==========");
        for (InternationalFlight flight : flights) {
            System.out.println(flight);
            System.out
                    .println("Booked passengers: " + flight.getBookedPassengers().size() + "/" + flight.getCapacity());
            System.out.println("---");
        }
    }

    private static void viewPassengers() {
        System.out.println("\n========== ALL PASSENGERS ==========");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    private static void generateReports() {
        System.out.println("\n========== REPORTS ==========");
        ReportGenerator reportGen = new ReportGenerator(flights, passengers, payments, schedules);
        System.out.println(reportGen.generateDailyFlightsReport());
        System.out.println(reportGen.generatePassengerStatistics());
        System.out.println(reportGen.generateRevenueReport());
    }

    private static void manageStaff() {
        System.out.println("\n========== STAFF MANAGEMENT ==========");
        System.out.println("1. Add Pilot");
        System.out.println("2. Add Cabin Crew");
        System.out.println("3. Add Security Officer");
        System.out.print("Enter choice: ");

        int choice = getValidIntInput("", 1, 3);

        System.out.print("Staff ID: ");
        String staffId = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = getValidDoubleInput("Salary: ", 0);

        switch (choice) {
            case 1:
                System.out.print("Flight hours: ");
                int flightHours = getValidIntInput("Flight hours: ", 0, 50000);
                Pilot pilot = new Pilot(staffId, name, salary, flightHours);
                System.out.println("Pilot added: " + pilot.getName());
                break;
            case 2:
                System.out.print("Enter languages (comma separated): ");
                String langs = scanner.nextLine();
                String languages = String.valueOf(new ArrayList<>(Arrays.asList(langs.split(","))));
                CabinCrew crew = new CabinCrew(staffId, name, salary, singletonList(languages));
                System.out.println("Cabin crew added: " + crew.getName());
                break;
            case 3:
                System.out.print("Security level (1-10): ");
                int secLevel = getValidIntInput("Security level: ", 1, 10);
                SecurityOfficer officer = new SecurityOfficer(staffId, name, salary, secLevel);
                System.out.println("Security officer added: " + officer.getName());
                break;
        }
    }

    private static void manageBaggage() {
        System.out.println("\n========== BAGGAGE MANAGEMENT ==========");
        if (passengers.isEmpty()) {
            System.out.println("No passengers found.");
            return;
        }

        System.out.println("Select passenger:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println((i + 1) + ". " + passengers.get(i).getFullName());
        }

        int choice = getValidIntInput("Enter choice: ", 1, passengers.size());
        Passenger selected = passengers.get(choice - 1);

        System.out.print("Baggage weight (kg): ");
        double weight = getValidDoubleInput("Weight: ", 0);

        String baggageId = "BG" + System.currentTimeMillis();
        Baggage baggage = new Baggage(baggageId, weight, selected);

        if (weight > 30) {
            System.out.println("Warning: Excess baggage fee applies!");
        }

        System.out.println("Baggage checked in successfully! ID: " + baggage.getBaggageId());
    }

    private static void securityCheck() {
        System.out.println("\n========== SECURITY CHECK ==========");
        if (passengers.isEmpty()) {
            System.out.println("No passengers found.");
            return;
        }

        System.out.println("Select passenger for security check:");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println((i + 1) + ". " + passengers.get(i).getFullName());
        }

        int choice = getValidIntInput("Enter choice: ", 1, passengers.size());
        Passenger selected = passengers.get(choice - 1);

        String checkId = "SEC" + System.currentTimeMillis();
        SecurityCheck securityCheck = new SecurityCheck(checkId, selected);

        if (securityCheck.performCheck()) {
            System.out.println("Security check cleared for " + selected.getFullName());
            System.out.println("Remarks: " + securityCheck.getRemarks());
        } else {
            System.out.println("Security check failed!");
        }
    }

    private static int getValidIntInput(String prompt, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Please enter a number between %d and %d%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private static double getValidDoubleInput(String prompt, double min) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine());
                if (value >= min) {
                    return value;
                }
                System.out.printf("Please enter a number greater than or equal to %.2f%n", min);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}