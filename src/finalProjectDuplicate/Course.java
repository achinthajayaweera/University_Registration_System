package finalProjectDuplicate;

public class Course {

    private String code;
    private String name;
    private String category;
    private String[] prerequisite;
    private String equivalence;
    private String freeElective;
    private int section;
    private String timeSlot;
    private int seats;

    // Constructor 1: For curriculum listings
    Course(String category, String code, String name) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    // Constructor 2: For prerequisite mappings
    Course(String category, String code, String[] prerequisite) {
        this.code = code;
        this.prerequisite = prerequisite;
        this.category = category;
    }

    // Constructor 3: For equivalence mappings
    Course(String category, String code, String equivalence, String name) {
        this.code = code;
        this.equivalence = equivalence;
        this.category = category;
        this.name = name;
    }

    // Constructor 4: For term schedule entries
    Course(String code, int section, String timeSlot, int seats) {
        this.code = code;
        this.section = section;
        this.timeSlot = timeSlot;
        this.seats = seats;
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

    public String[] getPrerequisite() {
        return prerequisite;
    }

    public String getEquivalence() {
        return equivalence;
    }

    public String getFreeElective() {
        return freeElective;
    }

    public int getSection() {
        return section;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getSeats() {
        return seats;
    }

    // Setter
    public void setSeats(int seats) {
        this.seats = seats;
    }

}
