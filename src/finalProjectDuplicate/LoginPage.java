package finalProjectDuplicate;

import java.util.Scanner;

public class LoginPage {

    private static boolean admin   = false;
    private static boolean advisor = false;
    private static boolean student = false;
    private static int option;

    private static AdminFunctions   adminfunctions   = new AdminFunctions();
    private static AdvisorFunctions advisorfunctions = new AdvisorFunctions();
    private static StudentFunctions studentfunctions = new StudentFunctions();

    public Scanner sc = new Scanner(System.in);
    private String username = null;
    private String password = null;

    // Login page — 3 attempts before account is blocked
    public void verify() {
        System.out.println("=================================================");
        System.out.println("   🎓 Welcome to Stamford Registration System  ");
        System.out.println("=================================================");
        System.out.print("> Username: ");
        username = sc.next();
        System.out.print("> Password: ");
        password = sc.next();

        IDsPasswords user = IDsPasswords.checkLogin(username, password);

        for (int attempt = 3; attempt >= 0; attempt--) {
            if (user != null) {
                System.out.println("\nLOGIN SUCCESSFUL");
                System.out.println("================\n");
                System.out.println("Welcome " + user.getName() + "!");

                if (user.getRole().contains("admin")) {
                    admin = true;
                } else if (user.getRole().contains("advisor")) {
                    advisor = true;
                } else if (user.getRole().contains("student")) {
                    student = true;
                }
                break;

            } else {
                if (attempt == 0) {
                    System.out.println("\n████████ ACCESS DENIED ████████");
                    System.out.println("Your account has been BLOCKED");
                    System.out.println("Contact system administrator");
                    System.out.println("██████████████████████████████████\n");
                } else {
                    System.out.println("\n❌ Login failed");
                    System.out.println("Attempts left: " + attempt);

                    System.out.print("\n> Username: ");
                    username = sc.next();
                    System.out.print("> Password: ");
                    password = sc.next();
                    user = IDsPasswords.checkLogin(username, password);
                }
            }
        }
    }

    // Check role and display appropriate menu in a loop
    public void checkRole() {

        // Admin loop
        while (admin) {
            adminfunctions.menu();
            System.out.print("\nYour selection is:");
            option = sc.nextInt();
            sc.nextLine();
            adminfunctions.selection(option);
            admin = returnMenu();
        }

        // Advisor loop
        while (advisor) {
            advisorfunctions.menu();
            System.out.print("\nYour selection is:");
            option = sc.nextInt();
            sc.nextLine();
            advisorfunctions.selection(option);
            advisor = returnMenu();
        }

        // Student loop
        while (student) {
            studentfunctions.menu();
            System.out.print("\nYour selection is:");
            option = sc.nextInt();
            sc.nextLine();
            studentfunctions.selection(option, username);
            student = returnMenu();
        }
    }

    // Helper — ask user to continue or exit
    public boolean returnMenu() {
        System.out.print("\nExit (y/n): ");
        String exit = sc.next();

        while (!exit.equals("y") && !exit.equals("n")) {
            System.out.println("\n❌ Invalid choice. Please try again!\n");
            System.out.print("Exit (y/n): ");
            exit = sc.next();
        }

        if (exit.equals("y")) {
            System.out.println("\nSee you next time!");
            return false;
        }
        return true;
    }

}
