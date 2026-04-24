package airport.utils;

import airport.flights.Flight;

import java.util.regex.Pattern;

public class InputValidator {

    // Passport: 1–2 letters followed by 6–9 digits (common format)
    private static final Pattern PASSPORT_PATTERN = Pattern.compile("^[A-Z]{1,2}\\d{6,9}$");
    // Flight ID: 2 letters + 3–4 digits, e.g. "AA123" or "QF1234"
    private static final Pattern FLIGHT_ID_PATTERN = Pattern.compile("^[A-Z]{2}\\d{3,4}$");
    // Seat: 1–3 digits + one letter A–F
    private static final Pattern SEAT_PATTERN = Pattern.compile("^\\d{1,3}[A-F]$");

    public static boolean validateOverbooking(Flight selectedFlight, int seats) {
        return selectedFlight != null
                && selectedFlight.getBookedPassengers().size() + seats <= selectedFlight.getCapacity();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static String validateNotEmpty(String value, String fieldName) {
        if (isNullOrEmpty(value)) {
            return "ERROR: " + fieldName + " cannot be empty.";
        }
        return null;
    }

    public static boolean isValidPassport(String passport) {
        return passport != null && PASSPORT_PATTERN.matcher(passport.toUpperCase()).matches();
    }

    public static boolean isEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    public static String validateSeatNumber(String seatNumber) {
        if (isNullOrEmpty(seatNumber))
            return "ERROR: Seat number cannot be empty.";
        if (!SEAT_PATTERN.matcher(seatNumber.toUpperCase()).matches())
            return "ERROR: Invalid seat number format. Expected: 1-3 digits + letter A-F (e.g., 12A).";
        return null;
    }

    public static String validatePassportNumber(String passport) {
        if (isNullOrEmpty(passport))
            return "ERROR: Passport number cannot be empty.";
        if (!PASSPORT_PATTERN.matcher(passport.toUpperCase()).matches())
            return "ERROR: Invalid passport number format. Expected: 1-2 letters + 6-9 digits (e.g. AB123456).";
        return null;
    }

    public String validateFlightId(String flightId) {
        if (isNullOrEmpty(flightId))
            return "ERROR: Flight ID cannot be empty.";
        if (!FLIGHT_ID_PATTERN.matcher(flightId.toUpperCase()).matches())
            return "ERROR: Invalid Flight ID format. Expected: 2 letters + 3-4 digits (e.g. KQ100).";
        return null;
    }

    public static String validateSeatNumber1(String seat) {
        if (isNullOrEmpty(seat))
            return "ERROR: Seat number cannot be empty.";
        if (!SEAT_PATTERN.matcher(seat.toUpperCase()).matches())
            return "ERROR: Invalid seat number. Expected format: row + column (e.g. 12A, 3C).";
        return null;
    }

    public String validateCapacity(int capacity) {
        if (capacity <= 0)
            return "ERROR: Capacity must be greater than zero.";
        if (capacity > 900)
            return "ERROR: Capacity " + capacity + " exceeds maximum allowed (900).";
        return null;
    }

    /**
     * Convenience: print an error and return false if error != null.
     */
    public boolean check(String error) {
        if (error != null) {
            System.out.println(error);
            return false;
        }
        return true;
    }
}
