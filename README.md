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
    └── AdminFunctions.java    # Admin menu and all admin operations
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
**v8 – Admin Functions**: `AdminFunctions.java` introduced with the full admin menu and all 6 operations — add course, remove course, set seat limits, open course section, close course section, and view system statistics. The `readTrack()` helper displays the 13-category track selector. The `selection()` dispatcher wires each menu option to the correct method. All operations delegate to `Curriculum` or `TermSchedule` as appropriate.
