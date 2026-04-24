package airport.flights;

import java.time.LocalDateTime;

public class InternationalFlight extends Flight {
    private boolean passportRequired;

    public InternationalFlight(String id, String airline, String dep, String dest,
                               LocalDateTime dep2, LocalDateTime arr, int cap,
                               boolean passportRequired, String visaRequiredForUae) {
        super(id, airline, dep, dest, dep2, String.valueOf(arr), cap);
        this.passportRequired = passportRequired;
    }

    @Override
    public void calculateDuration() {
        System.out.println("International flight duration calculated.");
    }

    @Override
    public String toString() {
        return super.toString() + " [International]";
    }

    public void checkPassport() {
        System.out.println("Passport required: " + passportRequired);
    }
}