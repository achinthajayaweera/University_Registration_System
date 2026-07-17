package finalProjectDuplicate;

import java.util.Scanner;

/**
 * Handles user authentication and role-based menu routing.
 * Enforces a 3-attempt limit before blocking access.
 * On successful login, routes to the Admin, Advisor, or Student menu loop.
 */
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

    /**
     * Displays the login banner and prompts for credentials.
     * Allows up to 3 attempts before printing ACCESS DENIED and blocking entry.
     * On success, sets the appropriate role flag (admin/advisor/student).
     */
    public void verify() {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║     Welcome to Stamford Registration System 🎓    ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.print("\n> Username: ");
        username = sc.next();
        System.out.print("> Password: ");
        password = sc.next();

        IDsPasswords user = IDsPasswords.checkLogin(username, password);

        for (int attempt = 3; attempt >= 0; attempt--) {
            if (user != null) {
                System.out.println("\n╔══════════════════════════╗");
                System.out.println("║     LOGIN SUCCESSFUL     ║");
                System.out.println("╚══════════════════════════╝");
                System.out.println("  Welcome, " + user.getName() + "!\n");

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
                    System.out.println("\n████████████████████████████████████");
                    System.out.println("          ACCESS DENIED              ");
                    System.out.println("  Your account has been BLOCKED.     ");
                    System.out.println("  Contact system administrator.       ");
                    System.out.println("████████████████████████████████████\n");
                } else {
                    System.out.println("\n❌ Incorrect username or password.");
                    System.out.println("   Attempts remaining: " + attempt);
                    System.out.print("\n> Username: ");
                    username = sc.next();
                    System.out.print("> Password: ");
                    password = sc.next();
                    user = IDsPasswords.checkLogin(username, password);
                }
            }
        }
    }

    // Check role and run appropriate menu loop
    /**
     * Reads the logged-in user's role flag and runs the appropriate
     * menu loop (admin, advisor, or student) until the user exits.
     */
    public void checkRole() {

        // Admin loop
        while (admin) {
            adminfunctions.menu();
            System.out.print("\nYour selection is: ");
            option = sc.nextInt();
            sc.nextLine();
            adminfunctions.selection(option);
            admin = returnMenu();
        }

        // Advisor loop
        while (advisor) {
            advisorfunctions.menu();
            System.out.print("\nYour selection is: ");
            option = sc.nextInt();
            sc.nextLine();
            advisorfunctions.selection(option);
            advisor = returnMenu();
        }

        // Student loop
        while (student) {
            studentfunctions.menu();
            System.out.print("\nYour selection is: ");
            option = sc.nextInt();
            sc.nextLine();
            studentfunctions.selection(option, username);
            student = returnMenu();
        }
    }

    /**
     * Prompts the user to exit or return to the menu.
     * Loops until a valid 'y' or 'n' is entered.
     * @return {@code true} to continue the menu loop, {@code false} to exit
     */
    public boolean returnMenu() {
        System.out.print("\nExit (y/n): ");
        String exit = sc.next();

        while (!exit.equals("y") && !exit.equals("n")) {
            System.out.println("\n❌ Please enter 'y' to exit or 'n' to continue.");
            System.out.print("Exit (y/n): ");
            exit = sc.next();
        }

        if (exit.equals("y")) {
            System.out.println("\nSee you next time! 👋\n");
            return false;
        }
        return true;
    }

}
