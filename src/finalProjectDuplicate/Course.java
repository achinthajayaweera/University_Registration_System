package finalProjectDuplicate;

public class Course {

    private String code;
    private String name;
    private String category;

    // Basic constructor
    Course(String category, String code, String name) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

}
