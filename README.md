# University Registration System
##Notes

## Project Overview
A Java console-based university registration system that supports multiple user roles: Admin, Advisor, and Student. The system handles course registration, curriculum tracking, and academic progress reporting.

## Tech Stack
- Java (Console Application)
- OOP principles: encapsulation, class design, role-based access

## Project Structure
```
src/
└── finalProjectDuplicate/
    ├── Main.java              # Entry point — wired and complete
    ├── LoginPage.java         # Login, 3-attempt lock, full role menu loops
    ├── IDsPasswords.java      # All 6 system users
    ├── Student.java           # Student data model
    ├── Course.java            # Course model (all 4 constructors)
    ├── TermSchedule.java      # Term schedule + system statistics report
    ├── Curriculum.java        # Full course catalogue + prerequisites + equivalencies
    ├── AdminFunctions.java    # Admin menu and all admin operations
    ├── StudentFunctions.java  # Student data, menu and all student operations
    ├── PrintProgress.java     # Curriculum progress printer for students and advisors
    └── AdvisorFunctions.java  # Advisor menu and all advisor operations
```

## How to Run
```bash
javac src/finalProjectDuplicate/*.java
java -cp src finalProjectDuplicate.Main
```

## Test Credentials
| Username   | Password   | Role    |
|------------|------------|---------|
| admin1     | admin1a    | Admin   |
| advisor1   | advisor1a  | Advisor |
| advisor2   | advisor2a  | Advisor |
| 2408050001 | JakeLee    | Student |
| 2409110003 | TinTun     | Student |
| 2409240001 | Khant      | Student |

## Current Status
**v12 – Fully Wired System**: All components connected end-to-end. `TermSchedule.systemStatistics()` fully implemented — counts registered students per course and displays total courses, total seats, and average seats. `LoginPage.checkRole()` now runs role-based menu loops for all three roles (admin/advisor/student), with `returnMenu()` controlling the exit flow. `Main.java` is the clean final entry point. The system is fully functional.
