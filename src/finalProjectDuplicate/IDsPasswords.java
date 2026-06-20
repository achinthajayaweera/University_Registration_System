package finalProjectDuplicate;

public class IDsPasswords {

    private String username;
    private String password;
    private String role;
    private String name;

    private IDsPasswords(String username, String password, String role, String name) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    // Initial single admin user
    private static final IDsPasswords user1 = new IDsPasswords("admin1", "admin1a", "admin", "David");

    // Verification method — checks only against user1 for now
    public static IDsPasswords checkLogin(String username, String password) {
        if (user1.username.equals(username) && user1.password.equals(password)) {
            return user1;
        }
        return null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

}
