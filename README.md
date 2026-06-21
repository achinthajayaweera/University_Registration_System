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
    └── Course.java            # Course data model
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
**v4 – Full Student Model**: `Student.java` now holds all fields needed across the system — `completedCourses`, `registeredCourses`, `failedCourses`, `freeElective`, `grade`, `termsCount`, and identity fields. Full constructor and all getters in place. This model will be used by StudentFunctions, AdvisorFunctions, and PrintProgress in upcoming versions.
