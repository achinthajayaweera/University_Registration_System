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
    ├── Student.java           # Student data model
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
**v3 – Login Security & Role Detection**: Login now enforces a 3-attempt limit. After 3 failed tries, the account is blocked with an ACCESS DENIED message. On success, the user's role (admin/advisor/student) is detected and stored as a boolean flag. Role-based menu routing is stubbed — menus will be wired in upcoming versions.
