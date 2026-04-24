package airport.models;

public class SecurityCheck {

    public boolean performCheck() { return true;
    }

    public enum CheckStatus { PENDING, PASSED, FAILED, REQUIRES_REVIEW }
 
    private String      checkId;
    private Passenger   passenger;
    private CheckStatus status;
    private String      remarks;
 
    public SecurityCheck() {
        this.checkId  = "SEC000";
        this.status   = CheckStatus.PENDING;
        this.remarks  = "No remarks.";
    }
 
    public SecurityCheck(String checkId, Passenger passenger) {
        this.checkId   = checkId;
        this.passenger = passenger;
        this.status    = CheckStatus.PENDING;
        this.remarks   = "Awaiting security screening.";
    }
 
    public String      getCheckId()               { return checkId; }
    public void        setCheckId(String id)       { this.checkId = id; }
 
    public Passenger   getPassenger()             { return passenger; }
    public void        setPassenger(Passenger p)  { this.passenger = p; }
 
    public CheckStatus getStatus()                { return status; }
    public void        setStatus(CheckStatus s)   { this.status = s; }
 
    public String      getRemarks()               { return remarks; }
    public void        setRemarks(String r)       { this.remarks = r; }
 
    public void conductCheck(boolean passed) {
        this.status  = passed ? CheckStatus.PASSED : CheckStatus.FAILED;
        this.remarks = passed ? "All clear. Passenger may proceed."
                              : "Security alert flagged. Manual review needed.";
        System.out.println("[SecurityCheck] " + checkId + " → " + this.status);
    }
 
    @Override
    public String toString() {
        return String.format(
            "[SecurityCheck] ID=%-8s | Passenger=%-15s | Status=%-18s | Remarks=%s",
            checkId,
            passenger != null ? passenger.getFullName() : "N/A",
            status, remarks
        );
    }
}
 