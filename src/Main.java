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

            System.out.println("Enter your password");          //dont allow password to be empty
            String passattempt = scanner.nextLine();
            if (!password.equalsIgnoreCase(passattempt)) {
                System.out.println("XXX INVALID PASSWORD, TRY AGAIN");
            } else if (password.equalsIgnoreCase(passattempt)) {
                System.out.println("Welcome: ");
                valid = true;
            }


        }

        while (valid) {
            System.out.println("1) Load an Account");  //transfer and withdraw
            System.out.println("2) Open a new Account"); //switch case
            System.out.println("3) See your OVERALL balance");
            System.out.println("4) Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    Accounts.loadacc();
                    int input = scanner.nextInt();
                    scanner.nextLine();
                        Accounts chosenacc = Accounts.accountz.get(input);
                        System.out.println("You have chosen" + chosenacc);


                    System.out.println("Would you like to 1) withdraw , 2) deposit");
                    String choice3 = scanner.nextLine();

                    if (choice3.equals("1")) {
                        chosenacc.withdraw();
                    }
                    else if (choice3.equals("2")) {
                        Accounts.deposit();
                    } else {
                        System.out.println("INVALID! TRY AGAIN");
                    }


                        //figure out how to pick an account from list and a function to withdraw and transfer


                }

                case "2" -> {
                    System.out.println("What type of account would you like to open"); //put ful details of account
                    System.out.println("1) Overdraft");
                    System.out.println("2) Loan");
                    System.out.println("3) Compound Interest");
                    System.out.println("4) Cash ISA");
                    String choice1 = scanner.nextLine();

                    if (choice1.equals("1")) {
                        Accounts.overdraft();
                    }
                    if (choice1.equals("2")) {
                        Accounts.loan();
                    }
                    if (choice1.equals("3")) {
                        Accounts.ci();
                    }
                    if (choice1.equals("4")) {
                        Accounts.cashisa();

                    } else {
                        System.out.println("Invalid Choice");
                    }
                }

                case "3" -> {
                    //System.out.println(Accounts.balance);
                }


                case "4" -> {
                    valid = false;
                }


            }


        }
    }
}
