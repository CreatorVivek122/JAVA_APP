package Project;

public class Transaction {
    private String type;  // Type of the transaction (e.g., "Equity", "Mutual Fund", "Derivative")
    private String name;  // Name of the investment product
    private double amount; // Amount invested
    private String date;  // Date of the transaction

    // Constructor
    public Transaction(String type, String name, double amount, String date) {
        this.type = type;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    // Override the toString method to display transaction details
    @Override
    public String toString() {
        return "Type: " + type + ", Name: " + name + ", Amount: Rs. " + amount + ", Date: " + date;
    }
}
