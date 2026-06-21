package finalProjectDuplicate;

import java.util.List;

public class Student {

    private List<String> freeElective;
    private List<String> completedCourses;
    private List<String> failedCourses;
    private List<String> registeredCourses;
    private String id;
    private String name;
    private String major;
    private double grade;
    private int termsCount;

    public Student(String id, String name, String major, double grade, int termsCount,
                   List<String> freeElective, List<String> completedCourses,
                   List<String> failedCourses, List<String> registeredCourses) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
        this.termsCount = termsCount;
        this.freeElective = freeElective;
        this.completedCourses = completedCourses;
        this.failedCourses = failedCourses;
        this.registeredCourses = registeredCourses;
    }

    // Getters
    public List<String> getFreeElective() {
        return freeElective;
    }

    public List<String> getCompletedCourses() {
        return completedCourses;
    }

    public List<String> getFailedCourses() {
        return failedCourses;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

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

    public int getTermsCount() {
        return termsCount;
    }

}
