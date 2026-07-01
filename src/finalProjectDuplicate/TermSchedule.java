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

    // Display term schedule with aligned columns
    public void printSchedule() {
        System.out.println("\n╔═══════════╦═════════╦═══════════════════════════════════╦═══════╗");
        System.out.println(  "║ Course    ║ Section ║ Time Slot                         ║ Seats ║");
        System.out.println(  "╠═══════════╬═════════╬═══════════════════════════════════╬═══════╣");
        for (Course c : schedule) {
            System.out.printf("║ %-9s ║    %-4d ║ %-33s ║  %-4d ║%n",
                    c.getCode(), c.getSection(), c.getTimeSlot(), c.getSeats());
        }
        System.out.println(  "╚═══════════╩═════════╩═══════════════════════════════════╩═══════╝");
    }

    // Edit seat limit
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
            System.out.println("\n✅ Seat limit updated. Current term schedule:");
            printSchedule();
        } else {
            System.out.println("\n❌ Course section not found in schedule.");
        }
    }

    // Open a new course section
    public void openCourse(String code, int section, String timeSlot, int seats) {
        schedule.add(new Course(code, section, timeSlot, seats));
        System.out.println("\n✅ Course opened. Updated term schedule:");
        printSchedule();
    }

    // Close (remove) a course section
    public void closeCourse(String code, int section) {
        boolean removed = schedule.removeIf(s -> s.getCode().equals(code) && s.getSection() == section);
        if (removed) {
            System.out.println("\n✅ Course closed. Updated term schedule:");
        } else {
            System.out.println("\n❌ Course section not found.");
        }
        printSchedule();
    }

    // System statistics report
    public void systemStatistics() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println(  "║                      SYSTEM STATISTICS                      ║");
        System.out.println(  "╚══════════════════════════════════════════════════════════════╝");

        int totalCourses = schedule.size();
        int totalSeats   = 0;
        for (Course c : schedule) { totalSeats += c.getSeats(); }
        double avgSeats  = totalCourses > 0 ? (double) totalSeats / totalCourses : 0;

        System.out.println("\n  Total Courses Open    : " + totalCourses);
        System.out.println("  Total Available Seats : " + totalSeats);
        System.out.printf("  Average Seats/Course  : %.2f%n", avgSeats);

        System.out.println("\n╔═══════════╦═════════╦═════════╦═══════════╗");
        System.out.println(  "║ Course    ║ Section ║  Taken  ║ Remaining ║");
        System.out.println(  "╠═══════════╬═════════╬═════════╬═══════════╣");

        for (Course c : schedule) {
            String codeSection = c.getCode() + "-" + c.getSection();
            int taken = 0;
            for (Student s : StudentFunctions.getStudent()) {
                if (s.getRegisteredCourses().contains(codeSection)) taken++;
            }
            System.out.printf("║ %-9s ║    %-4d ║   %-5d ║    %-6d ║%n",
                    c.getCode(), c.getSection(), taken, c.getSeats());
        }
        System.out.println("╚═══════════╩═════════╩═════════╩═══════════╝");
    }

}
