package Project;

public class SIPCalculator {

    // Method to calculate the SIP returns
    public static double calculateSIP(double monthlyAmount, double annualRate, int months) {
        // Convert annual rate to monthly rate
        double monthlyRate = annualRate / 12 / 100;

        // Calculate the future value using the SIP formula
        double futureValue = monthlyAmount * (Math.pow(1 + monthlyRate, months) - 1) / monthlyRate * (1 + monthlyRate);

        return futureValue;
    }

    // Method to display SIP calculation details
    public static void displaySIPDetails(double monthlyAmount, double annualRate, int months) {
        double maturityAmount = calculateSIP(monthlyAmount, annualRate, months);

        System.out.println("\nSIP Calculation Details:");
        System.out.println("Monthly Investment: Rs. " + monthlyAmount);
        System.out.println("Expected Annual Return: " + annualRate + "%");
        System.out.println("Investment Duration: " + months + " months");
        System.out.println("Total Maturity Amount (after " + months + " months): Rs. " + String.format("%.2f", maturityAmount));
    }
}
