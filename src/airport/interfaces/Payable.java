package airport.interfaces;

public interface Payable {
    void processPayment();

    double calculateAmount();

    void generateReceipt();
}