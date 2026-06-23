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
    ├── LoginPage.java         # Login UI, 3-attempt lock, role detection
    ├── IDsPasswords.java      # All 6 system users
    ├── Student.java           # Student data model
    ├── Course.java            # Course model (all 4 constructors)
    ├── TermSchedule.java      # Term schedule management
    ├── Curriculum.java        # Full course catalogue + prerequisites + equivalencies
    ├── AdminFunctions.java    # Admin menu and all admin operations
    ├── StudentFunctions.java  # Student data, menu and all student operations
    └── PrintProgress.java     # Curriculum progress printer for students and advisors
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
**v10 – Print Progress**: `PrintProgress.java` fully implemented. `printProgress(studentID, category)` counts completed and transferred courses per category and renders a visual progress bar with ✅/⏳ icons and 🔒 unmet prerequisite warnings per course. `printProgress(studentID, freeElective)` handles the free elective section. `checkMajorAndPrint(studentID)` gives advisors the full report across all sections. `checkMajorAndPrint(studentID, category)` gives students a filtered report for their chosen track only.
