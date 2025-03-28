import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("        🏦 WELCOME TO BANKX       ");
        System.out.println("==================================");

        String password = "";

        while (password.isEmpty()) {
            System.out.print("\n🔒 Create your password: ");
            password = scanner.nextLine().trim();

            if (password.isEmpty()) {
                System.out.println("❌ Password cannot be empty. Try again!");
            } else {
                System.out.println("✅ Password Created Successfully!");
            }
        }

        while (!valid) {
            System.out.print("\n🔑 Enter your password: ");
            String passattempt = scanner.nextLine();

            if (!password.equals(passattempt)) {
                System.out.println("❌ XXX INVALID PASSWORD, TRY AGAIN");
            } else {
                System.out.println("\n✅ Access Granted! Welcome to Your Banking System.");
                valid = true;
            }
        }

        while (valid) {
            Accounts.printmenu();
        }
    }
}
