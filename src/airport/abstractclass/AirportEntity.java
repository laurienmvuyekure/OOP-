package airport.abstractclass;

import java.time.LocalDate;

public abstract class AirportEntity {

    private String entityId;
    private String name;
    private String status;
    private LocalDate createdDate;
    private LocalDate lastUpdated;

    public AirportEntity() {
        this.entityId = "UNKNOWN";
        this.name = "UNKNOWN";
        this.status = "INACTIVE";
        this.createdDate = LocalDate.now();
        this.lastUpdated = LocalDate.now();
    }

    public AirportEntity(String entityId, String name, String status) {
        this.entityId = entityId;
        this.name = name;
        this.status = status;
        this.createdDate = LocalDate.now();
        this.lastUpdated = LocalDate.now();
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String id) {
        this.entityId = id;
        this.lastUpdated = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.lastUpdated = LocalDate.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        this.status = s;
        this.lastUpdated = LocalDate.now();
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    protected void touchUpdated() {
        this.lastUpdated = LocalDate.now();
    }

    public abstract boolean validateEntity();

    public abstract void activateEntity();

    public abstract void deactivateEntity();

    public abstract void updateDetails(String field, String value);

    public abstract String generateReport();

    public abstract void logActivity(String activity);

    public abstract String checkStatus();

    public abstract void archiveEntity();

    public abstract void restoreEntity();

    public abstract void displaySummary();

    @Override
    public String toString() {
        return String.format(
                "[AirportEntity] ID=%-10s | Name=%-20s | Status=%-10s | Created=%s | Updated=%s",
                entityId, name, status, createdDate, lastUpdated);
    }
}