package Project;

import java.util.ArrayList;
import java.util.List;

public class FinanceAdvisor {

    private List<InvestmentProduct> mutualFunds;
    private List<InvestmentProduct> equities;
    private List<InvestmentProduct> derivatives;

    public FinanceAdvisor() {
        mutualFunds = new ArrayList<>();
        equities = new ArrayList<>();
        derivatives = new ArrayList<>();

        // Example products
        mutualFunds.add(new InvestmentProduct("Axis Growth Fund", "Mutual Fund", 2, "Moderate risk, 8% annual return"));
        mutualFunds.add(new InvestmentProduct("SBI Balanced Fund", "Mutual Fund", 1, "Low risk, 5% annual return"));

        equities.add(new InvestmentProduct("Adani Enterprises", "Equity", 3, "High risk, high return"));
        equities.add(new InvestmentProduct("Tata Energy", "Equity", 2, "Moderate risk, moderate return"));

        derivatives.add(new InvestmentProduct("Banknifty 52000 PE", "Derivative", 3, "High risk, leveraged returns"));
        derivatives.add(new InvestmentProduct("Nifty 24000 CE", "Derivative", 2, "Moderate risk, moderate returns"));
    }

    // Modify suggestInvestment method to only accept User
    public void suggestInvestment(User user) {
        System.out.println("\nInvestment Suggestions for " + user.getName() + ":");
        boolean foundAny = false;

        double totalInvestment = user.getInvestmentAmount();
        double equityAllocation = totalInvestment * 0.3; // 30% for equities
        double derivativeAllocation = totalInvestment * 0.2; // 20% for derivatives
        double mutualFundAllocation = totalInvestment * 0.5; // 50% for mutual funds

        if (user.isInterestedInEquity()) {
            foundAny = suggestEquities(user, equityAllocation) || foundAny;
        }

        if (user.isInterestedInDerivatives()) {
            foundAny = suggestDerivatives(user, derivativeAllocation) || foundAny;
        }

        foundAny = suggestMutualFunds(user, mutualFundAllocation) || foundAny;

        if (!foundAny) {
            System.out.println("No suitable investments found based on your preferences and risk tolerance.");
        }
    }

    private boolean suggestEquities(User user, double allocation) {
        System.out.println("\nEquity Investments (Allocation: Rs. " + allocation + "):");
        boolean found = false;
        for (InvestmentProduct product : equities) {
            if (product.getRiskLevel() <= user.getRiskTolerance()) {
                System.out.println(product + " - Suggested for Rs. " + (allocation / equities.size()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No suitable equity investments found.");
        }
        return found;
    }

    private boolean suggestDerivatives(User user, double allocation) {
        System.out.println("\nDerivatives Investments (Allocation: Rs. " + allocation + "):");
        boolean found = false;
        for (InvestmentProduct product : derivatives) {
            if (product.getRiskLevel() <= user.getRiskTolerance()) {
                System.out.println(product + " - Suggested for Rs. " + (allocation / derivatives.size()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No suitable derivatives investments found.");
        }
        return found;
    }

    private boolean suggestMutualFunds(User user, double allocation) {
        System.out.println("\nMutual Fund Investments (Allocation: Rs. " + allocation + "):");
        boolean found = false;
        for (InvestmentProduct product : mutualFunds) {
            if (product.getRiskLevel() <= user.getRiskTolerance()) {
                System.out.println(product + " - Suggested for Rs. " + (allocation / mutualFunds.size()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No suitable mutual fund investments found.");
        }
        return found;
    }

    // No need to change anything else here
}
