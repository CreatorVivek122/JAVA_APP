package Project;

public class InvestmentProduct {
    private String name;
    private String type; // "Mutual Fund", "Equity", "Derivative"
    private int riskLevel; // 1 - Low, 2 - Medium, 3 - High
    private String description;

    public InvestmentProduct(String name, String type, int riskLevel, String description) {
        this.name = name;
        this.type = type;
        this.riskLevel = riskLevel;
        this.description = description;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public String getType() {
        return type;
    }

    // Override toString method to provide a meaningful string representation
    @Override
    public String toString() {
        return name + " (" + type + ") - Risk Level: " + riskLevel + " | " + description;
    }
}
