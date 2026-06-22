# University Registration System

## Project Overview
A Java console-based university registration system that supports multiple user roles: Admin, Advisor, and Student. The system handles course registration, curriculum tracking, and academic progress reporting.

## Tech Stack
- Java (Console Application)
- OOP principles: encapsulation, class design, role-based access

## Features (Planned)
- Role-based login (Admin / Advisor / Student)
- Course registration and withdrawal
- Prerequisite and seat limit enforcement
- Curriculum progress tracking
- Graduation risk reporting

## Project Structure
```
src/
└── finalProjectDuplicate/
    ├── Main.java              # Entry point
    ├── LoginPage.java         # Login UI and role routing
    ├── IDsPasswords.java      # User credentials store
    ├── Student.java           # Student data model (fully expanded)
    └── Course.java            # Course data model (all 4 constructors)
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
**v5 – Full Course Model**: `Course.java` now has all 4 constructors covering every use case in the system — curriculum listings, prerequisite mappings, equivalence mappings, and term schedule entries. All fields added (`prerequisite`, `equivalence`, `freeElective`, `section`, `timeSlot`, `seats`) with full getters and a `setSeats()` setter for admin seat editing.
