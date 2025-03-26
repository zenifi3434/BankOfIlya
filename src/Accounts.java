import javax.swing.text.html.HTMLDocument;
import java.sql.Array;
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
        return "Accounts{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", length=" + length +
                ", rate=" + rate +
                '}';
    }

    public static void overdraft() {
        Accounts Overdraft = new Accounts("Overdraft", 500, 1, 10);
        accountz.add(Overdraft);

        System.out.println("You now have access to an OVERDRAFT! of $500");
        balance += 500;
    }

    public static void loan() {
        Accounts Loan = new Accounts("Loan", 30000, 15, 5);
        accountz.add(Loan);
        System.out.println("You have opened a Loan of $30,000!");
        balance += 30000;


    }

    public static void cashisa() {
        Accounts CashISA = new Accounts("Cash ISA", 0, 5, 10);
        accountz.add(CashISA);
        System.out.println("You have opened a CASH ISA!");
    }

    public static void ci() {
        Accounts CompoundInterest = new Accounts("Compound Interest Account", 0, 7, 8);
        accountz.add(CompoundInterest);
        System.out.println("You have opened an COMPOUND INTEREST ACCOUNT!");

    }

    public static void loadacc() {
        System.out.println("Which account would you like to use? 0) 1) 2) 3) ");
        for (int i = 0; i < Accounts.accountz.size(); i++) {
            Accounts account = Accounts.accountz.get(i);
            System.out.println(account);
        }






            }



        public void withdraw() {
            System.out.println("How much would you like to withdraw");
            System.out.println("$" + this.getAmount());
            double withdrew = scanner.nextDouble();
            this.amount -= withdrew;
            System.out.println("Your new balance is $" + this.amount);

        }

        public static void deposit() {
            System.out.println("How much would you like to deposit into your account");
            System.out.println("$" + balance);
            double deposit = scanner.nextDouble();
            balance += deposit;
            System.out.println("Your new balance is $" + balance);

        }


        // Accounts CashISA = new Accounts("Cash ISA", 0, 5,10);
        // Accounts Loan = new Accounts("Loan", 20000, 15, 5);
        // Accounts CI = new Accounts("Compound Interest Account", 0,7, 8);


        //accounts with 0 amount mean you have to put money into them
    }





