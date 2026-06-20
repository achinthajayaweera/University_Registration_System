package finalProjectDuplicate;

import java.util.Scanner;

public class LoginPage {

    public Scanner sc = new Scanner(System.in);
    private String username = null;
    private String password = null;

    // Login page — accepts credentials and validates against user store
    public void verify() {
        System.out.println("=================================================");
        System.out.println("   🎓 Welcome to Stamford Registration System  ");
        System.out.println("=================================================");
        System.out.print("> Username: ");
        username = sc.next();
        System.out.print("> Password: ");
        password = sc.next();

        IDsPasswords user = IDsPasswords.checkLogin(username, password);

        if (user != null) {
            System.out.println("\nLOGIN SUCCESSFUL");
            System.out.println("================\n");
            System.out.println("Welcome " + user.getName() + "!");
        } else {
            System.out.println("\n❌ Login failed. Invalid username or password.");
        }
    }

    // TODO: role detection and menu routing — coming in next version
    public void checkRole() {
        System.out.println("(Role-based menu routing not yet implemented)");
    }

}
