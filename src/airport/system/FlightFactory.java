package airport.system;

import airport.flights.*;
import java.time.LocalDateTime;
import java.util.Map;

public class FlightFactory {
    public static Object createFlight(String type, Map<String, Object> params) {
        String flightId = (String) params.get("flightId");
        String airlineName = (String) params.get("airlineName");
        String departureLocation = (String) params.get("departureLocation");
        String destination = (String) params.get("destination");
        LocalDateTime departureTime = (LocalDateTime) params.get("departureTime");
        LocalDateTime arrivalTime = (LocalDateTime) params.get("arrivalTime");
        int capacity = (int) params.get("capacity");

        switch (type.toLowerCase()) {
            case "domestic":
                String regionCode = (String) params.get("regionCode");
                return new DomesticFlight(flightId, airlineName, departureLocation, destination,
                        departureTime, arrivalTime, capacity, regionCode);
            case "international":
                boolean passportRequired = (boolean) params.get("passportRequired");
                String visaRequirements = (String) params.get("visaRequirements");
                return new InternationalFlight(flightId, airlineName, departureLocation, destination,
                        departureTime, arrivalTime, capacity, passportRequired, visaRequirements);
            case "cargo":
                double cargoWeightLimit = (double) params.get("cargoWeightLimit");
                return new CargoFlight(flightId, airlineName, departureLocation, destination,
                        departureTime, arrivalTime, capacity, cargoWeightLimit);
            case "charter":
                String privateClientName = (String) params.get("privateClientName");
                boolean isLuxury = (boolean) params.get("isLuxury");
                return new CharterFlight(flightId, airlineName, departureLocation, destination,
                        departureTime, arrivalTime, capacity, privateClientName, isLuxury);
            case "emergency":
                int emergencyLevel = (int) params.get("emergencyLevel");
                String emergencyType = (String) params.get("emergencyType");
                return new EmergencyFlight(flightId, airlineName, departureLocation, destination,
                        departureTime, arrivalTime, capacity, emergencyLevel, emergencyType);
            default:
                throw new IllegalArgumentException("Unknown flight type: " + type);
        }
    }
}