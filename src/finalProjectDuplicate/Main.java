package finalProjectDuplicate;

/**
 * Entry point for the University Registration System.
 * Initialises the login page and delegates to role-based menus.
 */
public class Main {

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.verify();
        loginPage.checkRole();
    }

}
