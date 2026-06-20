package finalProjectDuplicate;

import java.util.Scanner;

public class LoginPage {

    public Scanner sc = new Scanner(System.in);
    private String username = null;
    private String password = null;

    // Display login banner and accept credentials
    public void verify() {
        System.out.println("=================================================");
        System.out.println("   🎓 Welcome to Stamford Registration System  ");
        System.out.println("=================================================");
        System.out.print("> Username: ");
        username = sc.next();
        System.out.print("> Password: ");
        password = sc.next();

        // TODO: validate credentials against user records
        System.out.println("\nUsername: " + username + " entered.");
        System.out.println("(Authentication not yet implemented)");
    }

    // TODO: implement role checking
    public void checkRole() {
        System.out.println("(Role checking not yet implemented)");
    }

}
