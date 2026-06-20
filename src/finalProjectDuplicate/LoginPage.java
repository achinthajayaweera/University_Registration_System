package finalProjectDuplicate;

import java.util.Scanner;

public class LoginPage {

    private static boolean admin   = false;
    private static boolean advisor = false;
    private static boolean student = false;

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

                // Set role flags
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

    // Check role and display appropriate menu
    public void checkRole() {
        // TODO: menus not yet implemented — coming in next version
        if (admin) {
            System.out.println("\n[Admin menu coming soon]");
        } else if (advisor) {
            System.out.println("\n[Advisor menu coming soon]");
        } else if (student) {
            System.out.println("\n[Student menu coming soon]");
        }
    }

    // Helper — ask user if they want to return to menu or exit
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
