package finalProjectDuplicate;

import java.util.ArrayList;
import java.util.List;

public class PrintProgress {

    private Curriculum curriculum = new Curriculum();
    private StudentFunctions studentRecord = new StudentFunctions();

    // Core progress printer — by category string
    public void printProgress(String studentID, String category) {

        // Find student
        Student result = null;
        for (Student s : StudentFunctions.getStudent()) {
            if (s.getId().equals(studentID)) {
                result = s;
                break;
            }
        }

        if (result == null) {
            System.out.println("\n❌ Student not found.\n");
            return;
        }

        // Build transferred list via equivalency mappings
        List<String> transferred = new ArrayList<>();
        for (Course c : curriculum.getCourse()) {
            if (c.getCategory().equals("Equivalency")) {
                for (String done : result.getCompletedCourses()) {
                    if (c.getCode().equals(done)) {
                        transferred.add(c.getEquivalence());
                    }
                }
            }
        }

        // Count progress
        int totalCount = 0;
        int completedCount = 0;

        for (Course c : curriculum.getCourse()) {
            if (c.getCategory().equals(category)) {
                totalCount++;
                boolean isCompleted  = result.getCompletedCourses().contains(c.getCode());
                boolean isTransferred = transferred.contains(c.getCode());
                if (isCompleted || isTransferred) {
                    completedCount++;
                }
            }
        }

        if (category.equals("General Courses")) {
            totalCount = 10;
        }

        int percent = (totalCount > 0) ? (completedCount * 100) / totalCount : 0;

        // Progress bar
        int barLength = 20;
        int filled = (percent * barLength) / 100;
        String bar = "";
        for (int i = 0; i < filled; i++)      bar += "█";
        for (int i = filled; i < barLength; i++) bar += "░";

        System.out.println("\n📘 " + category);
        System.out.println("Progress: " + completedCount + "/" + totalCount +
                " (" + percent + "%) [" + bar + "]");
        System.out.println("------------------------------------------------------------");

        // Print each course in this category
        for (Course c : curriculum.getCourse()) {
            if (!c.getCategory().equals(category)) continue;

            String courseCode = c.getCode();
            String courseName = c.getName();

            boolean isCompleted   = result.getCompletedCourses().contains(courseCode);
            boolean isTransferred = transferred.contains(courseCode);

            String icon   = isCompleted || isTransferred ? "✅" : "⏳";
            String status;
            if (isTransferred)    status = "TRANSFERRED";
            else if (isCompleted) status = "COMPLETED";
            else                  status = "PENDING";

            // Show unmet prerequisites
            String prerequisiteText = "";
            if (!isCompleted && !isTransferred) {
                for (Course d : curriculum.getCourse()) {
                    if (d.getCategory().equals("prerequisite") && c.getCode().equals(d.getCode())) {
                        for (String p : d.getPrerequisite()) {
                            if (!result.getCompletedCourses().contains(p)
                                    && !transferred.contains(p)) {
                                if (!prerequisiteText.equals("")) prerequisiteText += ", ";
                                prerequisiteText += p;
                            }
                        }
                    }
                }
            }

            if (!prerequisiteText.equals("")) {
                prerequisiteText = "   🔒 Prereq: " + prerequisiteText;
            }

            System.out.println(icon + " " + courseCode + " - " + courseName +
                    "    [" + status + "]" + prerequisiteText);
        }
    }

    // Overload — prints Free Elective progress from student's freeElective list
    public void printProgress(String studentID, List<String> freeElective) {
        int completedCount = 0;
        Student result = null;
        for (Student s : StudentFunctions.getStudent()) {
            if (s.getId().equals(studentID)) {
                result = s;
                completedCount = s.getFreeElective().size();
            }
        }
        int totalCount = 2;
        int percent    = (totalCount > 0) ? (completedCount * 100) / totalCount : 0;

        int barLength = 20;
        int filled    = (percent * barLength) / 100;
        String bar    = "";
        for (int i = 0; i < filled; i++)         bar += "█";
        for (int i = filled; i < barLength; i++)  bar += "░";

        System.out.println("\n📘 Free Elective");
        System.out.println("Progress: " + completedCount + "/" + totalCount +
                " (" + percent + "%) [" + bar + "]");
        System.out.println("------------------------------------------------------------");

        for (String courseCode : result.getFreeElective()) {
            System.out.println("✅ " + courseCode + " -     [TRANSFERRED]");
        }
    }

    // Full progress report — used by Advisor (no track filter)
    public void checkMajorAndPrint(String studentID) {
        Student result = null;
        for (Student s : StudentFunctions.getStudent()) {
            if (s.getId().equals(studentID)) {
                result = s;
                break;
            }
        }

        System.out.println("\n🎓 Progress Report");
        System.out.println("========================================");
        System.out.println("Student ID       : " + result.getId());
        System.out.println("Student Name     : " + result.getName());
        System.out.println("Course Completed : " +
                (result.getCompletedCourses().size() + result.getFreeElective().size()));
        System.out.println("Current Credits  : " + studentRecord.currentCredit(studentID));

        if (result.getMajor().equals("Computer Science")) {
            printProgress(studentID, "General Courses");
            printProgress(studentID, "CS Basic Core");
            printProgress(studentID, "CS Major Requirements");
            printProgress(studentID, "CS Software Engineering Track");
            printProgress(studentID, "CS Cyber Security Track");
            printProgress(studentID, "CS Artificial Intelligence Track");
            printProgress(studentID, result.getFreeElective());
            printProgress(studentID, "Internship");
        }

        if (result.getMajor().equals("Information Technology")) {
            printProgress(studentID, "General Courses");
            printProgress(studentID, "IT Basic Core");
            printProgress(studentID, "IT Major Requirements");
            printProgress(studentID, "IT Software Engineering Track");
            printProgress(studentID, "IT E-Commerce Track");
            printProgress(studentID, "IT Data Science Track");
            printProgress(studentID, "IT Network & Security Track");
            printProgress(studentID, result.getFreeElective());
            printProgress(studentID, "Internship");
        }
    }

    // Filtered progress report — used by Student (single track)
    public void checkMajorAndPrint(String studentID, String category) {
        Student result = null;
        for (Student s : StudentFunctions.getStudent()) {
            if (s.getId().equals(studentID)) {
                result = s;
                break;
            }
        }

        if (result == null) {
            System.out.println("\n❌ Student not found.\n");
            return;
        }

        System.out.println("\n🎓 Progress Report");
        System.out.println("========================================");
        System.out.println("Student ID       : " + result.getId());
        System.out.println("Student Name     : " + result.getName());
        System.out.println("Course Completed : " +
                (result.getCompletedCourses().size() + result.getFreeElective().size()));
        System.out.println("Current Credits  : " + studentRecord.currentCredit(studentID));

        if (result.getMajor().equals("Computer Science")) {
            printProgress(studentID, "General Courses");
            printProgress(studentID, "CS Basic Core");
            printProgress(studentID, "CS Major Requirements");
            switch (category) {
                case "CS Software Engineering Track":    printProgress(studentID, "CS Software Engineering Track");    break;
                case "CS Cyber Security Track":          printProgress(studentID, "CS Cyber Security Track");          break;
                case "CS Artificial Intelligence Track": printProgress(studentID, "CS Artificial Intelligence Track"); break;
            }
            printProgress(studentID, result.getFreeElective());
            printProgress(studentID, "Internship");
        }

        if (result.getMajor().equals("Information Technology")) {
            printProgress(studentID, "General Courses");
            printProgress(studentID, "IT Basic Core");
            printProgress(studentID, "IT Major Requirements");
            switch (category) {
                case "IT Software Engineering Track": printProgress(studentID, "IT Software Engineering Track"); break;
                case "IT E-Commerce Track":           printProgress(studentID, "IT E-Commerce Track");           break;
                case "IT Data Science Track":         printProgress(studentID, "IT Data Science Track");         break;
                case "IT Network & Security Track":   printProgress(studentID, "IT Network & Security Track");   break;
            }
            printProgress(studentID, result.getFreeElective());
            printProgress(studentID, "Internship");
        }
    }

}
