package finalProjectDuplicate;

import java.util.Scanner;

public class AdminFunctions {

    private static TermSchedule termSchedule = new TermSchedule();
    private static Curriculum curriculum     = new Curriculum();
    private static String courseCode;
    private static String courseName;
    private static int    type;
    private static int    section;
    private static String timeSlot;
    private static int    seat;
    private static String category;

    // Display Admin Menu
    public void menu() {
        System.out.println(" -----------------------------");
        System.out.println("|         Admin Menu          |");
        System.out.println(" -----------------------------");
        System.out.println("| 1 | Add courses             |");
        System.out.println("| 2 | Remove courses          |");
        System.out.println("| 3 | Set courses seat limits |");
        System.out.println("| 4 | Open courses            |");
        System.out.println("| 5 | Close courses           |");
        System.out.println("| 6 | View system statistics  |");
        System.out.println(" -----------------------------");
    }

    // Add new course to curriculum
    public void addCourses(String category, String code, String name) {
        curriculum.newCourses(category, code, name);
    }

    // Remove course from curriculum
    public void removeCourses(String category, String code, String name) {
        curriculum.deleteCourses(category, code, name);
    }

    // Edit seat limit for a scheduled course
    public void editSeats(String code, int section, int seats) {
        termSchedule.editSeats(code, section, seats);
    }

    // Open a new course section in the term schedule
    public void openCourse(String code, int section, String timeSlot, int seats) {
        termSchedule.openCourse(code, section, timeSlot, seats);
    }

    // Close (remove) a course section from the term schedule
    public void closeCourse(String code, int section) {
        termSchedule.closeCourse(code, section);
    }

    // View system statistics report
    public void viewReport() {
        termSchedule.systemStatistics();
    }

    // Handle admin menu selection
    public void selection(int option) {
        Scanner adminInput = new Scanner(System.in);

        if (option == 1) {
            System.out.println("\n===== Add Course =====\n");
            readTrack();
            System.out.println("\n===============================");
            System.out.println("     Enter Course To Add     ");
            System.out.println("===============================");
            System.out.println("Course Code : ");
            courseCode = adminInput.next();
            adminInput.nextLine();
            System.out.println("Course Name : ");
            courseName = adminInput.nextLine();
            addCourses(category, courseCode, courseName);

        } else if (option == 2) {
            System.out.println("\n===== Remove Course =====\n");
            readTrack();
            System.out.println("\n===============================");
            System.out.println("     Enter Course To Remove     ");
            System.out.println("===============================");
            System.out.print("Course Code : ");
            courseCode = adminInput.next();
            removeCourses(category, courseCode, courseName);

        } else if (option == 3) {
            System.out.println("\n===============================");
            System.out.println("     Enter Course To Edit     ");
            System.out.println("===============================");
            System.out.print("Course Code : ");
            courseCode = adminInput.next();
            adminInput.nextLine();
            System.out.print("Section     : ");
            section = adminInput.nextInt();
            adminInput.nextLine();
            System.out.print("Seat Limit  : ");
            seat = adminInput.nextInt();
            adminInput.nextLine();
            editSeats(courseCode, section, seat);

        } else if (option == 4) {
            System.out.println("\n===============================");
            System.out.println("     Enter Course To Open     ");
            System.out.println("===============================");
            System.out.print("Course Code : ");
            courseCode = adminInput.next();
            adminInput.nextLine();
            System.out.print("Section     : ");
            section = adminInput.nextInt();
            adminInput.nextLine();
            System.out.print("Time Slot   : ");
            timeSlot = adminInput.nextLine();
            System.out.print("Seat Limit  : ");
            seat = adminInput.nextInt();
            openCourse(courseCode, section, timeSlot, seat);

        } else if (option == 5) {
            System.out.println("\n===============================");
            System.out.println("     Enter Course To Close     ");
            System.out.println("===============================");
            System.out.print("Course Code : ");
            courseCode = adminInput.next();
            System.out.print("Section     : ");
            section = adminInput.nextInt();
            closeCourse(courseCode, section);

        } else if (option == 6) {
            viewReport();

        } else {
            System.out.println("\n❌ Invalid choice. Please try again!\n");
            System.out.print("\nYour selection is:");
            option = adminInput.nextInt();
        }
    }

    // Helper — display track/category menu and return selected category string
    public String readTrack() {
        Scanner adminInput = new Scanner(System.in);
        System.out.println(" --------------------------------------------");
        System.out.println("|              Select Track / Category       |");
        System.out.println(" --------------------------------------------");
        System.out.println("|  1  | General Courses                      |");
        System.out.println("|  2  | IT Basic Core                        |");
        System.out.println("|  3  | IT Major Requirements                |");
        System.out.println("|  4  | IT Software Engineering Track        |");
        System.out.println("|  5  | IT E-Commerce Track                  |");
        System.out.println("|  6  | IT Data Science Track                |");
        System.out.println("|  7  | IT Network & Security Track          |");
        System.out.println("|  8  | CS Basic Core                        |");
        System.out.println("|  9  | CS Major Requirements                |");
        System.out.println("| 10  | CS Software Engineering Track        |");
        System.out.println("| 11  | CS Cyber Security Track              |");
        System.out.println("| 12  | CS Artificial Intelligence Track     |");
        System.out.println("| 13  | Equivalency                          |");
        System.out.println(" --------------------------------------------\n");
        System.out.print("Your selection is:");
        type = adminInput.nextInt();

        switch (type) {
            case 1:  category = "General Courses"; break;
            case 2:  category = "IT Basic Core"; break;
            case 3:  category = "IT Major Requirements"; break;
            case 4:  category = "IT Software Engineering Track"; break;
            case 5:  category = "IT E-Commerce Track"; break;
            case 6:  category = "IT Data Science Track"; break;
            case 7:  category = "IT Network & Security Track"; break;
            case 8:  category = "CS Basic Core"; break;
            case 9:  category = "CS Major Requirements"; break;
            case 10: category = "CS Software Engineering Track"; break;
            case 11: category = "CS Cyber Security Track"; break;
            case 12: category = "CS Artificial Intelligence Track"; break;
            case 13: category = "Equivalency"; break;
        }

        while (type < 1 || type > 13) {
            System.out.println("\n❌ Invalid choice. Please try again!\n");
            System.out.print("Your selection is:");
            type = adminInput.nextInt();
        }

        return category;
    }

}
