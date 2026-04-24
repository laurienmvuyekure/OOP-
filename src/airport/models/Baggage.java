package airport.models;

public class Baggage {

    public Baggage(String baggageId, double weight, Passenger selected) {
    }

    public enum BaggageStatus { CHECKED_IN, IN_TRANSIT, DELIVERED, LOST, DELAYED }
 
    private String        baggageId;
    private double        weightKg;
    private Passenger     owner;
    private BaggageStatus status;
 
    public Baggage() {
        this.baggageId = "BAG000";
        this.weightKg  = 0.0;
        this.status    = BaggageStatus.CHECKED_IN;
    }
 
    public Baggage(String baggageId, double weightKg, Passenger owner, BaggageStatus status) {
        this.baggageId = baggageId;
        this.weightKg  = weightKg;
        this.owner     = owner;
        this.status    = status;
    }
 
    public String        getBaggageId()               { return baggageId; }
    public void          setBaggageId(String id)       { this.baggageId = id; }
 
    public double        getWeightKg()                { return weightKg; }
    public void          setWeightKg(double w)         { this.weightKg = w; }
 
    public Passenger     getOwner()                   { return owner; }
    public void          setOwner(Passenger p)         { this.owner = p; }
 
    public BaggageStatus getStatus()                  { return status; }
    public void          setStatus(BaggageStatus s)   { this.status = s; }
 
    @Override
    public String toString() {
        return String.format(
            "[Baggage] ID=%-8s | Owner=%-15s | Weight=%.2f kg | Status=%s",
            baggageId,
            owner != null ? owner.getFullName() : "N/A",
            weightKg, status
        );
    }
}
 