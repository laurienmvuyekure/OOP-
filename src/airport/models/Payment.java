package airport.models;

public class Payment {

    public void processPayment() {
        if (amount > 0) {
            this.paymentStatus = PaymentStatus.COMPLETED;
            System.out.printf("[Payment] %s: $%.2f via %s → COMPLETED%n",
                    paymentId, amount, paymentMethod);
        } else {
            this.paymentStatus = PaymentStatus.FAILED;
            System.out.printf("[Payment] %s: FAILED - Invalid amount%n", paymentId);
        }
    }

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED, REFUNDED
    }

    private String paymentId;
    private double amount;
    private String paymentMethod;
    private PaymentStatus paymentStatus;

    public Payment() {
        this.paymentId = "PAY000";
        this.amount = 0.0;
        this.paymentMethod = "CASH";
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String id) {
        this.paymentId = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double a) {
        this.amount = a;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String m) {
        this.paymentMethod = m;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus s) {
        this.paymentStatus = s;
    }

    public boolean process() {
        // Simple simulation: any amount > 0 succeeds
        if (amount > 0) {
            this.paymentStatus = PaymentStatus.COMPLETED;
            System.out.printf("[Payment] %s: $%.2f via %s → COMPLETED%n",
                    paymentId, amount, paymentMethod);
            return true;
        }
        this.paymentStatus = PaymentStatus.FAILED;
        System.out.println("[Payment] " + paymentId + " FAILED: invalid amount.");
        return false;
    }

    public String generateReceipt() {
        return String.format(
                "╔══════════════════════════════════════════════╗\n" +
                        "║             PAYMENT RECEIPT                  ║\n" +
                        "╠══════════════════════════════════════════════╣\n" +
                        "║  Payment ID  : %-30s║\n" +
                        "║  Amount      : $%-29.2f║\n" +
                        "║  Method      : %-30s║\n" +
                        "║  Status      : %-30s║\n" +
                        "╚══════════════════════════════════════════════╝",
                paymentId, amount, paymentMethod, paymentStatus);
    }

    @Override
    public String toString() {
        return String.format(
                "[Payment] ID=%-8s | Amount=$%-8.2f | Method=%-12s | Status=%s",
                paymentId, amount, paymentMethod, paymentStatus);
    }
}