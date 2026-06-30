# University Registration System

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
    ├── AdminFunctions.java    # Admin menu, all operations + exception-safe input
    ├── StudentFunctions.java  # Student data, menu, all operations + exception-safe input
    ├── PrintProgress.java     # Curriculum progress printer for students and advisors
    └── AdvisorFunctions.java  # Advisor menu, all operations + exception-safe input
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
**v14 – Exception Handling**: All three menu dispatchers (`AdminFunctions`, `AdvisorFunctions`, `StudentFunctions`) now catch `InputMismatchException` so typing text where a number is expected no longer crashes the program — it shows a friendly error and clears the input buffer instead. `StudentFunctions.selection()` now validates the menu option range (1–6) with a proper loop, consistent with the Admin and Advisor dispatchers from v13.
