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

    // All system users: 1 admin, 2 advisors, 3 students
    private static final IDsPasswords user1 = new IDsPasswords("admin1",    "admin1a",   "admin",   "David");
    private static final IDsPasswords user2 = new IDsPasswords("advisor1",  "advisor1a", "advisor", "Victoria");
    private static final IDsPasswords user3 = new IDsPasswords("advisor2",  "advisor2a", "advisor", "Hellen");
    private static final IDsPasswords user4 = new IDsPasswords("2408050001","JakeLee",   "student", "Jake");
    private static final IDsPasswords user5 = new IDsPasswords("2409110003","TinTun",    "student", "Tin");
    private static final IDsPasswords user6 = new IDsPasswords("2409240001","Khant",     "student", "Khant");

    // Loop through all users and return a match, or null if no match
    public static IDsPasswords checkLogin(String username, String password) {
        IDsPasswords[] users = { user1, user2, user3, user4, user5, user6 };
        for (IDsPasswords user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Individual getters (one per user, for direct access if needed)
    public static IDsPasswords getUser1() { return user1; }
    public static IDsPasswords getUser2() { return user2; }
    public static IDsPasswords getUser3() { return user3; }
    public static IDsPasswords getUser4() { return user4; }
    public static IDsPasswords getUser5() { return user5; }
    public static IDsPasswords getUser6() { return user6; }

    // Field getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole()     { return role; }
    public String getName()     { return name; }

}
