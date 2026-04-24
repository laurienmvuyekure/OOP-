package airport.models;

import java.time.LocalDateTime;

public class Notification {
 
    private String        notificationId;
    private String        message;
    private String        recipient;
    private LocalDateTime date;
 
    public Notification() {
        this.notificationId = "NOT000";
        this.message        = "No message.";
        this.recipient      = "Unknown";
        this.date           = LocalDateTime.now();
    }
 
    public Notification(String notificationId, String message, String recipient) {
        this.notificationId = notificationId;
        this.message        = message;
        this.recipient      = recipient;
        this.date           = LocalDateTime.now();
    }
 
    public String        getNotificationId()               { return notificationId; }
    public void          setNotificationId(String id)       { this.notificationId = id; }
 
    public String        getMessage()                      { return message; }
    public void          setMessage(String m)               { this.message = m; }
 
    public String        getRecipient()                    { return recipient; }
    public void          setRecipient(String r)             { this.recipient = r; }
 
    public LocalDateTime getDate()                         { return date; }
 
    public void send() {
        System.out.printf("[Notification → %s] %s (sent at %s)%n",
            recipient, message, date);
    }
 
    @Override
    public String toString() {
        return String.format(
            "[Notification] ID=%-8s | To=%-15s | Date=%s | Msg=%s",
            notificationId, recipient, date, message
        );
    }
}
 