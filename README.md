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
    ├── LoginPage.java         # Login, 3-attempt lock, boxed UI banners
    ├── IDsPasswords.java      # All 6 system users
    ├── Student.java           # Student data model
    ├── Course.java            # Course model (all 4 constructors)
    ├── TermSchedule.java      # Term schedule with aligned table display
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
**v15 – UI Polish**: `TermSchedule.printSchedule()` and `systemStatistics()` now use aligned `╔═╗` box-drawing tables with `printf` for clean column formatting. `closeCourse()` and `editSeats()` now give ✅/❌ feedback. `LoginPage` login banner, success message, and access denied block all updated to boxed style. `returnMenu()` goodbye message improved.
