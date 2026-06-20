package finalProjectDuplicate;

import java.util.List;

public class Student {

    private String id;
    private String name;
    private String major;
    private double grade;

    public Student(String id, String name, String major, double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGrade() {
        return grade;
    }

}
