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
    └── Curriculum.java        # Full course catalogue + prerequisites + equivalencies
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
**v7 – Full Curriculum**: `Curriculum.java` introduced with the complete course catalogue — 52 General Courses, IT Basic Core, IT Major Requirements, all 4 IT tracks (SE, E-Commerce, Data Science, Network & Security), CS Basic Core, CS Major Requirements, all 3 CS tracks (SE, Cyber Security, AI), Internship, 39 prerequisite mappings, and 29 equivalency mappings. `printCurriculum()`, `newCourses()`, and `deleteCourses()` implemented.
