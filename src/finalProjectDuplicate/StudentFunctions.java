package finalProjectDuplicate;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentFunctions {

    private Scanner studentInput = new Scanner(System.in);
    private Curriculum curriculum = new Curriculum();
    private Course open;

    private static List<Student> student = new ArrayList<>(List.of(

        new Student(
            "2408050001",
            "Ly Thuy Linh Pham",
            "Computer Science",
            3.7, 4,
            new ArrayList<>(List.of("ITE420", "ITE231")),
            new ArrayList<>(List.of(
                "ITE222", "ITE479", "MAT102", "ITE101",
                "ITE102", "ITE221", "ITE254", "ENG103",
                "ITE103", "ITE475", "MAT101", "ENG102",
                "MIS103", "PSY102", "ENG101"
            )),
            new ArrayList<>(),
            new ArrayList<>()
        ),

        new Student(
            "2409110003",
            "Tin Tun Aung",
            "Computer Science",
            4.0, 4,
            new ArrayList<>(List.of("ITE231")),
            new ArrayList<>(List.of(
                "ENG101", "ENG102", "ENG103", "MIS103",
                "PSY102", "MAT101", "BSC103", "BSC102",
                "BSC321", "BSC479", "CSC240", "CSC221",
                "CSC222", "CSC441", "CSC442", "CSC475"
            )),
            new ArrayList<>(),
            new ArrayList<>()
        ),

        new Student(
            "2409240001",
            "Khant Hpone Htet",
            "Computer Science",
            4.0, 4,
            new ArrayList<>(List.of("ITE231")),
            new ArrayList<>(List.of(
                "ENG101", "ENG102", "ENG103", "MIS103",
                "PSY102", "MAT101", "STA101", "BSC210",
                "CSC475", "BSC101", "BSC102", "BSC103",
                "BSC104", "BSC479", "CSC240",
                "CSC221", "CSC222"
            )),
            new ArrayList<>(),
            new ArrayList<>()
        ),

        new Student(
            "test",
            "test",
            "Information Technology",
            4.0, 4,
            new ArrayList<>(List.of("ITE231")),
            new ArrayList<>(List.of(
                "ENG101", "ENG102"
            )),
            new ArrayList<>(),
            new ArrayList<>()
        )

    ));

    public static List<Student> getStudent() {
        return student;
    }

    public void menu() {
        System.out.println(" -------------------------------");
        System.out.println("|          Student Menu         |");
        System.out.println(" -------------------------------");
        System.out.println("| 1 | View completed courses    |");
        System.out.println("| 2 | View remaining courses    |");
        System.out.println("| 3 | Check prerequisites       |");
        System.out.println("| 4 | Add course                |");
        System.out.println("| 5 | Drop course               |");
        System.out.println("| 6 | View registration status  |");
        System.out.println(" -------------------------------");
    }

    public void printCompletedCourse(String studentID) {
        Student result = null;
        for (Student s : student) {
            if (s.getId().equals(studentID)) {
                result = s;
                break;
            }
        }
        if (result == null) {
            System.out.println("\n❌ Student not found.\n");
        } else {
            System.out.println("\n==================================================");
            System.out.println("                 STUDENT RECORD                   ");
            System.out.println("==================================================");
            System.out.println("ID                 : " + result.getId());
            System.out.println("Name               : " + result.getName());
            System.out.println("Major              : " + result.getMajor());
            System.out.println("Terms Count        : " + result.getTermsCount());
            System.out.println("Current Credits    : " + currentCredit(studentID));
            System.out.println("GPA                : " + result.getGrade());
            System.out.println("Courses Completed  : " +
                    (result.getCompletedCourses().size() + result.getFreeElective().size()));
            System.out.println("--------------------------------------------------");
            for (String code : result.getCompletedCourses()) {
                System.out.println(code + " : " + findCourseName(code));
            }
            for (String code : result.getFreeElective()) {
                System.out.println(code + " : " + findCourseName(code));
            }
            System.out.println("--------------------------------------------------");
            if (result.getRegisteredCourses().isEmpty()) {
                System.out.println("Registered Courses : NONE");
            } else {
                System.out.println("Registered Courses : " + result.getRegisteredCourses());
            }
            System.out.println("==================================================");
        }
    }

    public void remainingCourse(String studentID, String category) {
        PrintProgress printProgress = new PrintProgress();
        printProgress.checkMajorAndPrint(studentID, category);
    }

    public void checkPrerequisite(String courseCode) {
        boolean courseFound = false;
        for (Course c : curriculum.getCourse()) {
            if (c.getCategory().equals("prerequisite") && c.getCode().equals(courseCode)) {
                courseFound = true;
                System.out.println("\nPrerequisite for this course is: ");
                for (String p : c.getPrerequisite()) {
                    System.out.println("- " + p);
                }
                break;
            }
        }
        if (!courseFound) {
            System.out.println("\nNo prerequisites required.");
        }
    }

    public void registerCourse(String studentID, String courseCode, int section) {
        String code_section = courseCode + "-" + section;
        Student result = null;
        boolean studentFound = false;
        for (Student s : getStudent()) {
            if (s.getId().equals(studentID)) {
                result = s;
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("\n❌ Student not found.\n");
            return;
        }
        if (result.getCompletedCourses().contains(courseCode)) {
            System.out.print("You have completed this course!");
            return;
        }
        if (result.getRegisteredCourses().contains(code_section)) {
            System.out.println("\n❌ You already registered this course.\n");
            return;
        }
        if (courseCode.equals("INTERN")) {
            int currentCredits = currentCredit(studentID);
            if (currentCredits < 148) {
                System.out.println("❌ Your need to completed all required courses first.");
                return;
            }
        }
        for (Course c : curriculum.getCourse()) {
            if (c.getCategory().equals("prerequisite") && c.getCode().equals(courseCode)) {
                System.out.println("\nYou need to complete this course first:");
                for (String p : c.getPrerequisite()) {
                    System.out.println("- " + p);
                }
                return;
            }
        }
        if (result.getRegisteredCourses().size() >= 4) {
            System.out.println("❌ You exceed course limit (max 4).");
            return;
        }
        List<String> timeTaken = new ArrayList<>();
        for (Course c : TermSchedule.getSchedule()) {
            String codeAndSection = c.getCode() + "-" + c.getSection();
            if (result.getRegisteredCourses().contains(codeAndSection)) {
                timeTaken.add(c.getTimeSlot());
            }
        }
        for (Course c : TermSchedule.getSchedule()) {
            String codeAndSection = c.getCode() + "-" + c.getSection();
            if (codeAndSection.equals(code_section)) {
                if (timeTaken.contains(c.getTimeSlot())) {
                    System.out.println("❌ Time conflict detected.");
                    return;
                }
            }
        }
        open = null;
        for (Course a : TermSchedule.getSchedule()) {
            if (a.getCode().equals(courseCode) && a.getSection() == section) {
                open = a;
            }
        }
        if (open == null) {
            System.out.println("❌ Course is not open.");
            return;
        }
        if (open.getSeats() <= 0) {
            System.out.println("❌ There is no seat available.");
            return;
        }
        result.getRegisteredCourses().add(code_section);
        for (Course c : TermSchedule.getSchedule()) {
            if (c.getCode().equals(courseCode) && c.getSection() == section) {
                c.setSeats(c.getSeats() - 1);
            }
        }
        System.out.println("Course Registered!");
        viewRegistration(studentID);
    }

    public void withdrawCourse(String studentID, String courseCode, int section) {
        String code_section = courseCode + "-" + section;
        boolean studentFound = false;
        for (Student s : student) {
            if (s.getId().equals(studentID)) {
                studentFound = true;
                if (s.getRegisteredCourses().contains(code_section)) {
                    s.getRegisteredCourses().remove(code_section);
                    for (Course c : TermSchedule.getSchedule()) {
                        if (c.getCode().equals(courseCode) && c.getSection() == section) {
                            c.setSeats(c.getSeats() + 1);
                        }
                    }
                    System.out.println("Course Removed!");
                    viewRegistration(studentID);
                } else {
                    System.out.println("❌ Course is not found.");
                }
                break;
            }
        }
        if (!studentFound) {
            System.out.println("❌ Student not found.");
        }
    }

    public void viewRegistration(String studentID) {
        for (Student s : student) {
            if (s.getId().equals(studentID)) {
                System.out.println("\n===== COURSE REGISTERED =====");
                System.out.println("Course  | Section | Time Slot");
                System.out.println("--------+---------+-----------");
                String timeSlot = null;
                for (String r : s.getRegisteredCourses()) {
                    String[] parts = r.split("-");
                    String course  = parts[0];
                    String sec     = parts[1];
                    for (Course c : TermSchedule.getSchedule()) {
                        if (c.getCode().equals(course)) {
                            timeSlot = c.getTimeSlot();
                            System.out.println(course + "  |   " + sec + "     | " + timeSlot);
                        }
                    }
                }
                if (timeSlot == null) {
                    System.out.println("            NONE      ");
                }
                System.out.println("--------+---------+-----------");
            }
        }
    }

    // Handle student menu selection — with input mismatch protection
    public void selection(int option, String studentID) {
        try {
            if (option == 1) {
                printCompletedCourse(studentID);
            } else if (option == 2) {
                String category = readTrack(studentID);
                remainingCourse(studentID, category);
            } else if (option == 3) {
                System.out.println("\n===============================");
                System.out.println("      Check Prerequisites     ");
                System.out.println("===============================");
                System.out.print("Enter Course Code : ");
                String courseCode = studentInput.nextLine();
                checkPrerequisite(courseCode);
            } else if (option == 4) {
                System.out.println("\n===============================");
                System.out.println("           Add Course         ");
                System.out.println("===============================");
                System.out.print("Course Code : ");
                String courseCode = studentInput.nextLine();
                System.out.print("Section     : ");
                int section = studentInput.nextInt();
                studentInput.nextLine();
                registerCourse(studentID, courseCode, section);
            } else if (option == 5) {
                System.out.println("\n===============================");
                System.out.println("           Drop Course         ");
                System.out.println("===============================");
                System.out.print("Course Code : ");
                String courseCode = studentInput.nextLine();
                System.out.print("Section     : ");
                int section = studentInput.nextInt();
                studentInput.nextLine();
                withdrawCourse(studentID, courseCode, section);
            } else if (option == 6) {
                viewRegistration(studentID);
            } else {
                System.out.println("\n❌ Invalid choice. Please try again!\n");
                System.out.print("\nYour selection is:");
                option = studentInput.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("\n❌ Invalid input. Please enter a valid number for section.\n");
            studentInput.nextLine();
        }
    }

    public String findCourseName(String code) {
        for (Course course : curriculum.getCourse()) {
            if (course.getCode().equals(code)) {
                return course.getName();
            }
        }
        return "(Unknown Course)";
    }

    public int currentCredit(String studentID) {
        int courseCredits = 0;
        int internCredits = 0;
        for (Student s : student) {
            if (s.getId().equals(studentID)) {
                courseCredits = (s.getCompletedCourses().size() + s.getFreeElective().size())
                        * Curriculum.COURSE_CREDITS;
                for (String c : s.getCompletedCourses()) {
                    if (c.contains("INTERN")) {
                        internCredits  = Curriculum.INTERN_CREDITS;
                        courseCredits -= Curriculum.COURSE_CREDITS;
                    }
                }
            }
        }
        return courseCredits + internCredits;
    }

    public String readTrack(String studentID) {
        String major = null;
        for (Student s : student) {
            if (s.getId().equals(studentID)) {
                major = s.getMajor();
                break;
            }
        }
        int type = 0;
        if (major.equals("Information Technology")) {
            System.out.println(" ------------------------------");
            System.out.println("|         Select track:        |");
            System.out.println(" ------------------------------");
            System.out.println("|  1  | IT software            |");
            System.out.println("|  2  | IT ecommerce           |");
            System.out.println("|  3  | IT data science        |");
            System.out.println("|  4  | IT network             |");
            System.out.println(" ------------------------------\n");
            System.out.print("Your selection is:");
            type = studentInput.nextInt();
            studentInput.nextLine();
            while (type < 1 || type > 4) {
                System.out.println("\n❌ Invalid choice. Please try again!\n");
                System.out.print("Your selection is:");
                type = studentInput.nextInt();
                studentInput.nextLine();
            }
        }
        if (major.equals("Computer Science")) {
            System.out.println(" -----------------------------");
            System.out.println("|        Select track:        |");
            System.out.println(" -----------------------------");
            System.out.println("|  5 | CS software            |");
            System.out.println("|  6 | CS cybersecurity       |");
            System.out.println("|  7 | CS AI                  |");
            System.out.println(" -----------------------------\n");
            System.out.print("Your selection is:");
            type = studentInput.nextInt();
            studentInput.nextLine();
            while (type < 5 || type > 7) {
                System.out.println("\n❌ Invalid choice. Please try again!\n");
                System.out.print("Your selection is:");
                type = studentInput.nextInt();
                studentInput.nextLine();
            }
        }
        String category = null;
        switch (type) {
            case 1: category = "IT Software Engineering Track"; break;
            case 2: category = "IT E-Commerce Track"; break;
            case 3: category = "IT Data Science Track"; break;
            case 4: category = "IT Network & Security Track"; break;
            case 5: category = "CS Software Engineering Track"; break;
            case 6: category = "CS Cyber Security Track"; break;
            case 7: category = "CS Artificial Intelligence Track"; break;
        }
        return category;
    }

}
