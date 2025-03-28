import java.util.ArrayList;
import java.util.Scanner;

public class Accounts {
    String type;
    double amount;
    int length;
    double rate;
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Accounts> accountz = new ArrayList<>();
    static double balance;

    public Accounts(String type, double amount, int length, double rate) {
        this.type = type;
        this.amount = amount;
        this.length = length;
        this.rate = rate;
    }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }
    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    @Override
    public String toString() {
        return "--------------------------------\n" +
                " Account Type: " + type + "\n" +
                " Balance: $" + String.format("%.2f", amount) + "\n" +
                " Term Length: " + length + " years\n" +
                " Interest Rate: " + rate + "%\n" +
                "--------------------------------";
    }

    public static void overdraft() {
        Accounts Overdraft = new Accounts("Overdraft", 500, 1, 10);
        accountz.add(Overdraft);
        System.out.println("\n✅ You now have access to an OVERDRAFT of $500!");
        balance += 500;
    }

    public static void loan() {
        Accounts Loan = new Accounts("Loan", 30000, 15, 5);
        accountz.add(Loan);
        System.out.println("\n✅ You have successfully opened a LOAN of $30,000!");
        balance += 30000;
    }

    public static void cashisa() {
        Accounts CashISA = new Accounts("Cash ISA", 0, 5, 10);
        accountz.add(CashISA);
        System.out.println("\n✅ A new CASH ISA account has been created!");
    }

    public static void ci() {
        Accounts CompoundInterest = new Accounts("Compound Interest Account", 0, 7, 8);
        accountz.add(CompoundInterest);
        System.out.println("\n✅ A COMPOUND INTEREST ACCOUNT has been opened!");
    }

    public void withdraw() {
        System.out.println("\n💵 How much would you like to withdraw?");
        System.out.println("Current Balance: $" + String.format("%.2f", this.getAmount()));
        System.out.print("Enter amount: $");

        double withdrew = scanner.nextDouble();
        scanner.nextLine();

        if (this.amount < withdrew) {
            System.out.println("❌ Insufficient Funds. Transaction Failed.");
        } else {
            this.amount -= withdrew;
            System.out.println("✅ Withdrawal Successful! New Balance: $" + String.format("%.2f", this.amount));
        }
    }

    public static void deposit() {
        Accounts.loadacc();
        System.out.print("\n🔄 Select an account to DEPOSIT into: ");
        int toInput = scanner.nextInt();
        scanner.nextLine();

        if (toInput >= accountz.size()) {
            System.out.println("❌ Invalid selection! Please try again.");
            return;
        }
        Accounts toAccount = accountz.get(toInput);

        System.out.print("\n💰 Select an account to TRANSFER FROM: ");
        int fromInput = scanner.nextInt();
        scanner.nextLine();

        if (fromInput >= accountz.size() || fromInput == toInput) {
            System.out.println("❌ Invalid selection! Choose a different account.");
            return;
        }
        Accounts fromAccount = accountz.get(fromInput);

        System.out.print("\n💲 Enter amount to deposit: $");
        double money = scanner.nextDouble();
        scanner.nextLine();

        if (fromAccount.amount < money) {
            System.out.println("❌ Insufficient funds in the selected account.");
            return;
        }

        fromAccount.amount -= money;
        toAccount.amount += money;

        System.out.println("\n✅ Transfer Successful!");
        System.out.println("📌 Updated Account Balances:");
        System.out.println(fromAccount);
        System.out.println(toAccount);
    }

    public static void createacc() {
        System.out.println("\n🏦 Select the type of account you want to open:");
        System.out.println("-------------------------------------------------");
        System.out.println("1️⃣ Overdraft:        💰 Amount: $500,   🔄 Payback: 1 year,  🔺 Interest: 10%");
        System.out.println("2️⃣ Loan:             💰 Amount: $30,000, 📆 Repayment: 15 years, 🔺 Interest: 5%");
        System.out.println("3️⃣ Compound Interest: 💰 Amount: $0,     ⏳ Term: 7 years,     🔺 Interest: 8%");
        System.out.println("4️⃣ Cash ISA:         💰 Amount: $0,     ⏳ Term: 5 years,     🔺 Interest: 10%");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter choice: ");

        String choice1 = scanner.nextLine();

        switch (choice1) {
            case "1" -> overdraft();
            case "2" -> loan();
            case "3" -> ci();
            case "4" -> cashisa();
            default -> System.out.println("❌ Invalid Choice. Please try again.");
        }
    }

    public static void loadacc() {
        if (accountz.isEmpty()) {
            System.out.println("\n⚠️ You need to create an account first!");
            createacc();
            printmenu();
        } else {
            System.out.println("\n📄 Select an account:");
            for (int i = 0; i < accountz.size(); i++) {
                System.out.println("[" + i + "] " + accountz.get(i).getType());
            }
        }
    }

    public static void printmenu() {
        boolean valid = true;

        while (valid) {
            System.out.println("\n==================================");
            System.out.println("       💳 BANKING SYSTEM MENU     ");
            System.out.println("==================================");
            System.out.println("1️⃣ Withdraw / Deposit");
            System.out.println("2️⃣ Open a New Account");
            System.out.println("3️⃣ See Your Overall Balance");
            System.out.println("4️⃣ Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("\n🔄 Would you like to:");
                    System.out.println("1️⃣ Withdraw");
                    System.out.println("2️⃣ Deposit");
                    System.out.print("Enter choice: ");

                    String actionChoice = scanner.nextLine();

                    if (actionChoice.equals("1")) {
                        Accounts.loadacc();
                        System.out.print("\n💵 Select an account to withdraw from: ");
                        int input = scanner.nextInt();
                        scanner.nextLine();

                        if (input >= accountz.size()) {
                            System.out.println("❌ Invalid selection! Try again.");
                            continue;
                        }

                        Accounts chosenacc = accountz.get(input);
                        System.out.println("📌 Selected Account: " + chosenacc.getType());
                        chosenacc.withdraw();
                    } else if (actionChoice.equals("2")) {
                        Accounts.deposit();
                    } else {
                        System.out.println("❌ Invalid choice! Please enter 1 or 2.");
                    }
                }

                case "2" -> createacc();

                case "3" -> {
                    double totalBalance = 0;
                    for (Accounts acc : accountz) {
                        totalBalance += acc.getAmount();
                    }
                    System.out.println("\n💰 Total Balance Across All Accounts: $" + String.format("%.2f", totalBalance));
                }

                case "4" -> {
                    System.out.println("\n🚪 Exiting the Banking System. Have a great day! 💙");
                    valid = false;
                }

                default -> System.out.println("❌ Invalid choice, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        printmenu();
    }
}
