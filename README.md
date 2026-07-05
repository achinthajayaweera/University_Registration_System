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
    ├── StudentFunctions.java  # Student menu, record display, registration table
    ├── PrintProgress.java     # Progress report with boxed header and progress bars
    └── AdvisorFunctions.java  # Advisor menu, graduation risk table
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
**v17 – Report Display Polish**: `AdvisorFunctions.graduationRisks()` now renders a clean `╔═╗` box table with ⚠ HIGH / ~ MEDIUM / ✓ LOW risk indicators. Both `PrintProgress.checkMajorAndPrint()` overloads now display a boxed student summary header with `printf`-aligned fields before listing course progress. Null-safety guard added to the advisor-facing overload.
