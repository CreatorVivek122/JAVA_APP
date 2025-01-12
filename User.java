package Project;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int riskTolerance;
    private boolean interestedInEquity;
    private boolean interestedInDerivatives;
    private boolean interestedInMutualFunds;
    private double investmentAmount;

    // Portfolio fields
    private double equityAmount;
    private double derivativeAmount;
    private double mutualFundAmount;

    // Transaction history
    private List<String> transactionHistory;

    public User(String name, int riskTolerance, boolean interestedInEquity, boolean interestedInDerivatives, boolean interestedInMutualFunds, double investmentAmount) {
        this.name = name;
        this.riskTolerance = riskTolerance;
        this.interestedInEquity = interestedInEquity;
        this.interestedInDerivatives = interestedInDerivatives;
        this.interestedInMutualFunds = interestedInMutualFunds;
        this.investmentAmount = investmentAmount;

        // Initialize portfolio amounts
        this.equityAmount = 0;
        this.derivativeAmount = 0;
        this.mutualFundAmount = 0;

        // Initialize transaction history list
        this.transactionHistory = new ArrayList<>();
    }

    // Getters and Setters

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    // Method to get current portfolio status
    public String getPortfolioStatus() {
        return "Current Portfolio:\n" +
                "Equity Investments: Rs. " + equityAmount + "\n" +
                "Derivative Investments: Rs. " + derivativeAmount + "\n" +
                "Mutual Fund Investments: Rs. " + mutualFundAmount + "\n" +
                "Total Investment: Rs. " + investmentAmount;
    }

    // Method to allocate money into portfolio based on selected portfolio type
    public void allocateToPortfolio(double mfAllocation, double eqAllocation, double derAllocation) {
        this.mutualFundAmount = mfAllocation;
        this.equityAmount = eqAllocation;
        this.derivativeAmount = derAllocation;

        // Record the allocation transaction
        String transaction = "Allocated: " +
                "Mutual Funds: Rs. " + mfAllocation + ", " +
                "Equities: Rs. " + eqAllocation + ", " +
                "Derivatives: Rs. " + derAllocation;
        transactionHistory.add(transaction);
    }

    // Deposit money into the portfolio
    public void depositMoney(double amount) {
        if (amount > 0) {
            this.investmentAmount += amount;
            String transaction = "Deposited: Rs. " + amount;
            transactionHistory.add(transaction);
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    // Withdraw money from the portfolio
    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= investmentAmount) {
            this.investmentAmount -= amount;
            String transaction = "Withdrew: Rs. " + amount;
            transactionHistory.add(transaction);
        } else {
            System.out.println("Invalid amount. Withdrawal must be positive and not exceed the available balance.");
        }
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            System.out.println("\nTransaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Other getter methods
    public String getName() {
        return name;
    }

    public int getRiskTolerance() {
        return riskTolerance;
    }

    public boolean isInterestedInEquity() {
        return interestedInEquity;
    }

    public boolean isInterestedInDerivatives() {
        return interestedInDerivatives;
    }

    public boolean isInterestedInMutualFunds() {
        return interestedInMutualFunds;
    }
}
