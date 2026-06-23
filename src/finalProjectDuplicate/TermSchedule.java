package finalProjectDuplicate;

import java.util.ArrayList;
import java.util.List;

public class TermSchedule {

    // Available courses for the new term
    private static List<Course> schedule = new ArrayList<>(List.of(

        // Course(String code, int section, String timeSlot, int seats)
        new Course("ITE222", 3, "Monday/Thursday 08:30-10:30", 25),
        new Course("ITE420", 1, "Monday/Thursday 14:30-16:30", 25),
        new Course("ITE479", 3, "Monday/Thursday 10:30-12:30", 25),
        new Course("ART101", 3, "Monday/Thursday 10:30-12:30", 25),
        new Course("ART102", 3, "Monday/Thursday 10:30-12:30", 25),
        new Course("INTERN", 3, "Monday/Thursday 10:30-12:30", 25)
    ));

    // Getter
    public static List<Course> getSchedule() {
        return schedule;
    }

    // Display term schedule
    public void printSchedule() {
        System.out.println("Course Code | Section |           Time Slot           | Seats |");
        for (Course c : schedule) {
            System.out.println(c.getCode() + "      |    " + c.getSection()
                    + "    |  " + c.getTimeSlot() + "  |  " + c.getSeats() + "   | ");
        }
        System.out.println("--------------------------------------------------------------");
    }

    // Open a new course section
    public void openCourse(String code, int section, String timeSlot, int seats) {
        schedule.add(new Course(code, section, timeSlot, seats));
        System.out.println("---------------------------------------------------------------");
        System.out.println(" Course Opened. New Term Schedule Is: ");
        System.out.println("---------------------------------------------------------------");
        printSchedule();
    }

    // Close (remove) a course section
    public void closeCourse(String code, int section) {
        schedule.removeIf(s -> (s.getCode().equals(code) && s.getSection() == section));
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Course Removed. This Term Schedule Is: ");
        System.out.println("--------------------------------------------------------------");
        printSchedule();
    }

    // Edit seat limit for a course section
    public void editSeats(String code, int section, int seats) {
        boolean found = false;
        for (Course c : schedule) {
            if (c.getCode().equals(code) && c.getSection() == section) {
                c.setSeats(seats);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("---------------------------------------------------------------");
            System.out.println(" Seat Limit Modified. This Term Schedule Is: ");
            System.out.println("---------------------------------------------------------------");
            printSchedule();
        } else {
            System.out.println("Course not found.");
        }
    }

    // TODO: systemStatistics() — needs StudentFunctions, coming in a later version

}
