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
    ├── Main.java              # Entry point
    ├── LoginPage.java         # Login, 3-attempt lock, full role menu loops
    ├── IDsPasswords.java      # All 6 system users
    ├── Student.java           # Student data model
    ├── Course.java            # Course model (all 4 constructors)
    ├── TermSchedule.java      # Term schedule + system statistics report
    ├── Curriculum.java        # Full course catalogue + prerequisites + equivalencies
    ├── AdminFunctions.java    # Admin menu, all operations + validated input loops
    ├── StudentFunctions.java  # Student data, menu and all student operations
    ├── PrintProgress.java     # Curriculum progress printer for students and advisors
    └── AdvisorFunctions.java  # Advisor menu, all operations + validated input loops
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
**v13 – Input Validation**: `AdminFunctions.selection()` and `AdvisorFunctions.selection()` now loop on invalid menu input instead of falling through silently. `AdminFunctions.readTrack()` similarly loops until a valid track number (1–13) is entered. All `nextLine()` buffer flushes aligned consistently to prevent input skipping bugs across all menu flows.
