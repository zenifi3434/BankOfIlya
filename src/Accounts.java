import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Accounts class simulates a banking system with multiple account types.
 * It supports overdraft, loan, cash ISA, and compound interest accounts.
 * Users can perform actions like creating accounts, making withdrawals, and transferring funds.
 */
public class Accounts {
    private String type;
    private double amount;
    private int length;
    private double rate;

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Accounts> accountz = new ArrayList<>();

    /**
     * Constructor to create a new account.
     *
     * @param type   The type of the account.
     * @param amount The initial balance of the account.
     * @param length The duration of the account (in years).
     * @param rate   The annual interest rate for the account.
     */
    public Accounts(String type, double amount, int length, double rate) {
        this.type = type;
        this.amount = amount;
        this.length = length;
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Account Type: " + type + " | Balance: $" + amount + " | Length: " + length + " years | Interest Rate: " + rate + "%";
    }

    /**
     * Method to create an overdraft account with a fixed amount and interest rate.
     */
    public static void overdraft() {
        Accounts overdraft = new Accounts("Overdraft", 500, 1, 10);
        accountz.add(overdraft);
        System.out.println("\n✅ A new Overdraft account with $500 has been created!");
        System.out.println();

        // Display payment information
        System.out.println("1. Monthly Repayment (With Interest):");
        System.out.println("Monthly Payment: $47.50");

        System.out.println("\n2. Total Paid Over 1 Year (With Interest):");
        System.out.println("Total Paid: $570.00");

        System.out.println("\n3. Weekly Repayment (With Interest):");
        System.out.println("Weekly Payment: $10.96");

        System.out.println("\n4. Yearly Repayment (With Interest):");
        System.out.println("Total Paid: $570.00");
    }

    /**
     * Method to create a loan account with a fixed amount and interest rate.
     */
    public static void loan() {
        Accounts loan = new Accounts("Loan", 30000, 15, 5);
        accountz.add(loan);
        System.out.println("\n✅ A new Loan account with $30,000 has been created!");
        System.out.println();

        // Display payment information
        System.out.println("1. Monthly Repayment (With Interest):");
        System.out.println("Monthly Payment: $237.22");

        System.out.println("\n2. Total Paid Over 15 Years (With Interest):");
        System.out.println("Total Paid: $42,694.65");

        System.out.println("\n3. Yearly Repayment (With Interest):");
        System.out.println("Yearly Payment: $2,846.64");
    }

    /**
     * Method to create a Cash ISA account with user input for deposit amount.
     * Calculates interest over different periods.
     */
    public static void cashisa() {
        int cashIsaCount = 0;
        for (Accounts account : accountz) {
            if (account.getType().equalsIgnoreCase("Cash ISA")) {
                cashIsaCount++;
            }
        }

        if (cashIsaCount >= 2) {
            System.out.println("❌ You are not allowed more than 2 Cash ISA accounts!");
            return;
        }

        Accounts cashISA = new Accounts("Cash ISA", 0, 5, 10);
        accountz.add(cashISA);
        System.out.println("\n✅ A new CASH ISA account has been created!");

        System.out.println("SIMULATED ACCOUNT...");
        System.out.println("How much would you like to put in your Cash ISA?");
        double isamoney = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline character after nextDouble()

        // Calculate interest over 5 years (annual compounding)
        double annualCompoundAmount = isamoney * Math.pow(1 + 0.10, 5);
        double oneYearAmount = isamoney * (1 + 0.10);
        double monthlyRate = 0.10 / 12;
        double monthlyCompoundAmount = isamoney * Math.pow(1 + monthlyRate, 12 * 5);

        System.out.printf("After 5 years with Annual Compounding: $%.2f\n", annualCompoundAmount);
        System.out.printf("After 1 year with Annual Compounding: $%.2f\n", oneYearAmount);
        System.out.printf("After 5 years with Monthly Compounding: $%.2f\n", monthlyCompoundAmount);
    }

    /**
     * Method to create a Compound Interest account with user input for deposit amount.
     * Calculates compound interest over 7 years.
     */
    public static void compoundInterest() {
        Accounts compoundInterest = new Accounts("Compound Interest", 0, 7, 8);
        accountz.add(compoundInterest);
        System.out.println("\n✅ A new Compound Interest account has been created!");

        System.out.println("SIMULATED ACCOUNT...");
        System.out.println("How much would you like to put in your Compound Interest account?");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline character after nextDouble()

        // Compound Interest over 7 years (annual compounding)
        double compoundAmount = amount * Math.pow(1 + 0.08, 7);

        System.out.printf("After 7 years with Annual Compounding: $%.2f\n", compoundAmount);
    }

    /**
     * Method to handle withdrawal from an account.
     */
    public void withdraw() {
        System.out.println("\nHow much would you like to withdraw?");
        double withdrew = scanner.nextDouble();
        if (this.amount < withdrew) {
            System.out.println("❌ Insufficient Funds");
        } else {
            this.amount -= withdrew;
            System.out.println("✅ Your new balance is $" + this.amount);
        }
    }

    /**
     * Method to transfer money between accounts.
     */
    public static void transfer() {
        loadacc(); // Load available accounts
        System.out.println("Select an account to transfer money from:");
        int fromInput = scanner.nextInt();
        scanner.nextLine();

        if (fromInput >= accountz.size()) {
            System.out.println("❌ Invalid account selection.");
            return;
        }

        Accounts fromAccount = accountz.get(fromInput);

        System.out.println("Select an account to deposit into:");
        int toInput = scanner.nextInt();
        scanner.nextLine();

        if (toInput >= accountz.size() || toInput == fromInput) {
            System.out.println("❌ Invalid selection! Make sure you choose a different account.");
            return;
        }

        Accounts toAccount = accountz.get(toInput);

        System.out.println("How much would you like to transfer?");
        double money = scanner.nextDouble();
        scanner.nextLine();

        if (fromAccount.amount < money) {
            System.out.println("❌ Insufficient funds in the selected account.");
            return;
        }

        // Perform transfer
        fromAccount.amount -= money;
        toAccount.amount += money;

        System.out.println("✅ Transfer successful!");
        System.out.println("From Account: " + fromAccount);
        System.out.println("To Account: " + toAccount);
    }

    /**
     * Method to display available accounts and allow account selection.
     */
    public static void loadacc() {
        if (accountz.isEmpty()) {
            System.out.println("❌ You need to create an account first!");
            createacc(); // Create an account if none exists
            printmenu();
        } else {
            System.out.println("\nSelect an account to use:");
            for (int i = 0; i < accountz.size(); i++) {
                System.out.println(i + ") " + accountz.get(i));
            }
        }
    }

    /**
     * Method to create a new account.
     */
    public static void createacc() {
        System.out.println("\n🏦 Select the type of account you want to open:");
        System.out.println("1️⃣ Overdraft");
        System.out.println("2️⃣ Loan");
        System.out.println("3️⃣ Compound Interest");
        System.out.println("4️⃣ Cash ISA");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                overdraft();
                break;
            case "2":
                loan();
                break;
            case "3":
                compoundInterest();
                break;
            case "4":
                cashisa();
                break;
            default:
                System.out.println("❌ Invalid choice. Please try again.");
                createacc(); // Retry if invalid input
                break;
        }
    }

    /**
     * Method to print the main menu and handle user interactions.
     */
    public static void printmenu() {
        boolean valid = true;

        while (valid) {
            System.out.println("\n📋 Main Menu:");
            System.out.println("1️⃣ Withdraw / Deposit");
            System.out.println("2️⃣ Open a new Account");
            System.out.println("3️⃣ See your overall balance");
            System.out.println("4️⃣ Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();  // This reads the entire line

            switch (choice) {
                case "1":
                    System.out.println("Would you like to: 1️⃣ Withdraw  2️⃣ Transfer?");
                    String actionChoice = scanner.nextLine(); // Read user choice

                    if (actionChoice.equals("1")) {
                        loadacc();
                        System.out.println("Select an account to withdraw from:");
                        int input = scanner.nextInt();
                        scanner.nextLine(); // Consume the leftover newline character

                        if (input >= accountz.size()) {
                            System.out.println("❌ Invalid selection.");
                            continue;
                        }

                        Accounts chosenAcc = accountz.get(input);
                        chosenAcc.withdraw();
                    } else if (actionChoice.equals("2")) {
                        transfer(); // Transfer functionality
                    }
                    break;

                case "2":
                    createacc();
                    break;

                case "3":
                    double balance = 0;
                    for (Accounts deez : accountz) {
                        balance += deez.getAmount();
                    }
                    System.out.println("T0TAL AMOUNT: " + balance);
                    break;

                case "4":
                    valid = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        printmenu(); // Start the menu
    }
}
