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
1. Compile all `.java` files inside `src/finalProjectDuplicate/`
2. Run the `Main` class:
```bash
javac src/finalProjectDuplicate/*.java
java -cp src finalProjectDuplicate.Main
```

## Current Status
**v1 – Foundation**: Core data models (`Student`, `Course`) and project structure scaffolded. Login page UI banner is in place. Authentication logic is a stub — to be implemented in the next version.
