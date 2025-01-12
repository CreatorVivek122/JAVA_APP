package Project;

import java.util.Scanner;

public class FinanceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Finance App");

        // Sample user creation (In practice, you will take input from the user)
        User user = new User("John Doe", 2, true, true, true, 100000);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Portfolio Status");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Select Portfolio & Allocate Investment");
            System.out.println("5. SIP Calculator");
            System.out.println("6. Display Transaction History");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // View current portfolio status
                    System.out.println(user.getPortfolioStatus());
                    break;

                case 2:
                    // Deposit money into the portfolio
                    System.out.print("Enter the amount you want to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.depositMoney(depositAmount);
                    break;

                case 3:
                    // Withdraw money from the portfolio
                    System.out.print("Enter the amount you want to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    user.withdrawMoney(withdrawAmount);
                    break;

                case 4:
                    // Select portfolio and allocate investment
                    System.out.println("\nSelect Portfolio Type:");
                    System.out.println("1. Portfolio 1 (50% Mutual Funds, 30% Equities, 20% Derivatives)");
                    System.out.println("2. Portfolio 2 (60% Mutual Funds, 20% Equities, 20% Derivatives)");
                    System.out.println("3. Portfolio 3 (40% Mutual Funds, 40% Equities, 20% Derivatives)");

                    int portfolioChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    double mfAllocation = 0, eqAllocation = 0, derAllocation = 0;

                    switch (portfolioChoice) {
                        case 1:
                            mfAllocation = 0.5 * user.getInvestmentAmount();
                            eqAllocation = 0.3 * user.getInvestmentAmount();
                            derAllocation = 0.2 * user.getInvestmentAmount();
                            break;
                        case 2:
                            mfAllocation = 0.6 * user.getInvestmentAmount();
                            eqAllocation = 0.2 * user.getInvestmentAmount();
                            derAllocation = 0.2 * user.getInvestmentAmount();
                            break;
                        case 3:
                            mfAllocation = 0.4 * user.getInvestmentAmount();
                            eqAllocation = 0.4 * user.getInvestmentAmount();
                            derAllocation = 0.2 * user.getInvestmentAmount();
                            break;
                        default:
                            System.out.println("Invalid portfolio choice!");
                            break;
                    }

                    user.allocateToPortfolio(mfAllocation, eqAllocation, derAllocation);
                    break;

                case 5:
                    // SIP Calculator
                    System.out.print("Enter your monthly SIP amount: Rs. ");
                    double monthlySIP = scanner.nextDouble();

                    System.out.print("Enter expected annual rate of return (in %): ");
                    double annualReturn = scanner.nextDouble();

                    System.out.print("Enter duration in months: ");
                    int durationMonths = scanner.nextInt();

                    // Use SIP Calculator to display result
                    SIPCalculator.displaySIPDetails(monthlySIP, annualReturn, durationMonths);
                    break;

                case 6:
                    // Display transaction history
                    user.displayTransactionHistory();
                    break;

                case 7:
                    // Exit
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
