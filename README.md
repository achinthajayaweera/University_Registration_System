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
    ├── LoginPage.java         # Login, 3-attempt lock, role menu routing
    ├── IDsPasswords.java      # All 6 system users
    ├── Student.java           # Student data model
    ├── Course.java            # Course model (all 4 constructors)
    ├── TermSchedule.java      # Term schedule management and statistics
    ├── Curriculum.java        # Full course catalogue + prerequisites + equivalencies
    ├── AdminFunctions.java    # Admin operations
    ├── StudentFunctions.java  # Student operations and registration logic
    ├── PrintProgress.java     # Curriculum progress reports
    └── AdvisorFunctions.java  # Advisor operations and graduation risk reports
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

## Features
- 🔐 Role-based login with 3-attempt lockout (Admin / Advisor / Student)
- 📋 Course registration with prerequisite, seat limit, time conflict and duplicate checks
- 📊 Visual curriculum progress reports with `█░` progress bars
- ⚠ Graduation risk analysis report for advisors
- 🗓 Term schedule management — open, close, and edit course sections
- 📚 Full course catalogue with IT and CS tracks, equivalency and prerequisite mappings

## License
This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
