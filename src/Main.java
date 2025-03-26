import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("banking app");
        System.out.println("Create your password");
        String password = scanner.nextLine();
        System.out.println("Password Created!");
        System.out.println();


        while (!valid) {

            System.out.println("Enter your password");
            String passattempt = scanner.nextLine();
            if (!password.equalsIgnoreCase(passattempt)) {
                System.out.println("XXX INVALID PASSWORD, TRY AGAIN");
            } else if (password.equalsIgnoreCase(passattempt)) {
                System.out.println("Welcome: ");
                valid = true;
            }


        }

        while (valid) {
            System.out.println("1) Load an Account");
            System.out.println("2) Open a new Account");




        }


    }
}
