package airport.models;

import airport.abstractclass.AirportEntity;
import airport.interfaces.*;

public class AirportManager extends AirportEntity
        implements Reservable, Payable, Trackable {

    private String airportName;
    private int terminalNumber;
    private String managerName;
    private String location;

    public AirportManager(String id, String name, String status,
            String airportName, int terminalNumber, String managerName) {
        super(id, name, status);
        this.airportName = airportName;
        this.terminalNumber = terminalNumber;
        this.managerName = managerName;
    }

    // Implement abstract methods
    public boolean validateEntity() {
        System.out.println("Validating manager...");
        return false;
    }

    public void activateEntity() {
        setStatus("Active");
    }

    public void deactivateEntity() {
        setStatus("Inactive");
    }

    public void updateDetails() {
        System.out.println("Updating manager details...");
    }

    public String generateReport() {
        System.out.println("Generating report...");
        return null;
    }

    public void logActivity() {
        System.out.println("Logging activity...");
    }

    public String checkStatus() {
        System.out.println("Status: " + getStatus());
        return null;
    }

    public void archiveEntity() {
        System.out.println("Archived.");
    }

    public void restoreEntity() {
        System.out.println("Restored.");
    }

    public void displaySummary() {
        System.out.println(toString());
    }

    // Interface methods
    public void createReservation() {
        System.out.println("Reservation created.");
    }

    public void cancelReservation() {
        System.out.println("Reservation canceled.");
    }

    public void modifyReservation() {
        System.out.println("Reservation modified.");
    }

    public void processPayment() {
        System.out.println("Payment processed.");
    }

    public double calculateAmount() {
        return 100.0;
    }

    public void generateReceipt() {
        System.out.println("Receipt generated.");
    }

    public void trackStatus() {
        System.out.println("Tracking status...");
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateDetails(String field, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDetails'");
    }

    @Override
    public void logActivity(String activity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logActivity'");
    }
}