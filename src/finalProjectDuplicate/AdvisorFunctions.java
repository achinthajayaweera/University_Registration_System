package finalProjectDuplicate;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides all academic advisor operations:
 * searching students, viewing curriculum progress, managing course
 * registration on behalf of students, and generating graduation risk reports.
 */
public class AdvisorFunctions {

    private static StudentFunctions studentRecord = new StudentFunctions();

    /** Displays the advisor role menu options. */
    public void menu() {
        System.out.println("\n╔═════════════════════════════════╗");
        System.out.println(  "║          Advisor Menu           ║");
        System.out.println(  "╠═════════════════════════════════╣");
        System.out.println(  "║ 1 │ Search student              ║");
        System.out.println(  "║ 2 │ View curriculum progress    ║");
        System.out.println(  "║ 3 │ Register course             ║");
        System.out.println(  "║ 4 │ Withdrawal course           ║");
        System.out.println(  "║ 5 │ View graduation risks       ║");
        System.out.println(  "╚═════════════════════════════════╝");
    }

    /**
     * Searches for a student by ID and prints their full academic record.
     * @param studentID the student's login ID
     */
    public void searchStudent(String studentID) {
        studentRecord.printCompletedCourse(studentID);
    }

    /**
     * Prints the full curriculum progress report for a student across all sections.
     * @param studentID the student's login ID
     */
    public void viewProgress(String studentID) {
        PrintProgress printProgress = new PrintProgress();
        printProgress.checkMajorAndPrint(studentID);
    }

    /**
     * Registers a course on behalf of a student — delegates to StudentFunctions.
     * @param studentID  the student's login ID
     * @param courseCode the course code to register
     * @param section    the section number
     */
    public void registerCourse(String studentID, String courseCode, int section) {
        studentRecord.registerCourse(studentID, courseCode, section);
    }

    /**
     * Withdraws a course on behalf of a student — delegates to StudentFunctions.

     */
    public void withdrawCourse(String studentID, String courseCode, int section) {
        studentRecord.withdrawCourse(studentID, courseCode, section);
    }

    /**
     * Prints the graduation risk report for all students.
     * Risk is calculated from courses completed per term:
     * fewer than 2 = HIGH, fewer than 4 = MEDIUM, 4 or more = LOW.
     */
    public void graduationRisks() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(  "║                     GRADUATION RISKS REPORT                         ║");
        System.out.println(  "╠════════════════╦══════════════════════╦══════════════╦═════════════╣");
        System.out.println(  "║ Student ID     ║ Name                 ║ Courses/Term ║ Risk Level  ║");
        System.out.println(  "╠════════════════╬══════════════════════╬══════════════╬═════════════╣");
        for (Student s : studentRecord.getStudent()) {
            int totalCourses = (s.getCompletedCourses().size() + s.getFreeElective().size());
            int perTerm      = totalCourses / s.getTermsCount();
            String risk;
            if (perTerm < 2)      risk = "⚠ HIGH";
            else if (perTerm < 4) risk = "~ MEDIUM";
            else                  risk = "✓ LOW";
            System.out.printf("║ %-14s ║ %-20s ║      %-7d ║ %-11s ║%n",
                    s.getId(), s.getName(), perTerm, risk);
        }
        System.out.println("╚════════════════╩══════════════════════╩══════════════╩═════════════╝");
    }

    // Handle advisor menu selection — loops until valid input
    public void selection(int option) {
        Scanner advisorInput = new Scanner(System.in);
        try {

        while (option < 1 || option > 5) {
            System.out.println("\n❌ Invalid choice. Please select between 1 and 5.\n");
            System.out.print("Your selection is: ");
            option = advisorInput.nextInt();
            advisorInput.nextLine();
        }

        if (option == 1) {
            System.out.println("\n==================================");
            System.out.println("     Enter Student ID To Search     ");
            System.out.println("==================================");
            System.out.print("Student ID : ");
            String studentID = advisorInput.nextLine();
            searchStudent(studentID);

        } else if (option == 2) {
            System.out.println("\n===============================");
            System.out.println("     View Curriculum Progress     ");
            System.out.println("===============================");
            System.out.print("Student ID : ");
            String studentID = advisorInput.nextLine();
            viewProgress(studentID);

        } else if (option == 3) {
            System.out.println("\n===============================");
            System.out.println("     Assign Course To Student     ");
            System.out.println("===============================");
            System.out.print("Student ID  : ");
            String studentID = advisorInput.nextLine();
            System.out.print("Course Code : ");
            String courseCode = advisorInput.next();
            advisorInput.nextLine();
            System.out.print("Section     : ");
            int section = advisorInput.nextInt();
            advisorInput.nextLine();
            registerCourse(studentID, courseCode, section);

        } else if (option == 4) {
            System.out.println("\n===================================");
            System.out.println("     Withdraw Course For Student     ");
            System.out.println("===================================");
            System.out.print("Student ID  : ");
            String studentID = advisorInput.nextLine();
            System.out.print("Course Code : ");
            String courseCode = advisorInput.next();
            advisorInput.nextLine();
            System.out.print("Section     : ");
            int section = advisorInput.nextInt();
            advisorInput.nextLine();
            withdrawCourse(studentID, courseCode, section);

        } else if (option == 5) {
            graduationRisks();
        }
        } catch (InputMismatchException e) {
            System.out.println("\n❌ Invalid input type entered. Please try again.\n");
            advisorInput.nextLine();
        }
    }

}
