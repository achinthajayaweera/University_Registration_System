# University Registration System

![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=java)
![License](https://img.shields.io/badge/License-MIT-blue)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)

A role-based console application for university course registration built in Java. Supports three user roles — **Admin**, **Advisor**, and **Student** — each with a dedicated menu and a distinct set of operations across course management, registration, and academic progress tracking.

---

## Demoo

![System Demo](demo1.gif)

---

## Features

| Role | Capabilities |
|---|---|
| 🔑 **Admin** | Add/remove curriculum courses, open/close term sections, edit seat limits, view system statistics |
| 👩‍🏫 **Advisor** | Search students, view full progress reports, register/withdraw courses on behalf of students, run graduation risk analysis |
| 🎓 **Student** | View completed courses, check remaining curriculum, look up prerequisites, register/drop courses, view registration status |

**System-wide:**
- 🔐 3-attempt login lockout with role detection
- 📊 Visual `█░` progress bars with ✅/⏳/🔒 course status indicators
- ✅ 10-step registration validation (prerequisites, seat limits, time conflicts, course load, INTERN credit gate)
- ⚠ Graduation risk report (HIGH / MEDIUM / LOW based on courses per term)
- 📚 Full IT and CS course catalogues with prerequisite and equivalency mappings

---

## System Architecture

```
Main
 └── LoginPage
      ├── IDsPasswords        (credential verification)
      ├── AdminFunctions
      │    ├── Curriculum      (add / remove courses)
      │    └── TermSchedule    (open / close / edit seats / statistics)
      ├── AdvisorFunctions
      │    ├── StudentFunctions (search, register, withdraw on behalf)
      │    └── PrintProgress   (full progress report)
      └── StudentFunctions
           ├── Curriculum      (prerequisite lookups)
           ├── TermSchedule    (seat checks, time conflict checks)
           └── PrintProgress   (filtered progress report)

Data Models:
  Student   — id, name, major, grade, termsCount,
              completedCourses, registeredCourses,
              failedCourses, freeElective
  Course    — code, name, category, prerequisite[],
              equivalence, section, timeSlot, seats
```

---

## Project Structure

```
University_Registration_System/
├── src/
│   └── finalProjectDuplicate/
│       ├── Main.java              # Entry point
│       ├── LoginPage.java         # Login, 3-attempt lock, role menu routing
│       ├── IDsPasswords.java      # All 6 system users
│       ├── Student.java           # Student data model
│       ├── Course.java            # Course model (4 constructors)
│       ├── TermSchedule.java      # Term schedule management and statistics
│       ├── Curriculum.java        # Full course catalogue
│       ├── AdminFunctions.java    # Admin operations
│       ├── AdvisorFunctions.java  # Advisor operations
│       ├── StudentFunctions.java  # Student operations and registration logic
│       └── PrintProgress.java     # Curriculum progress reports
├── docs/
│   ├── SYSTEM_DESIGN.md           # Architecture decisions and design notes
│   └── USER_GUIDE.md              # Step-by-step guide for all three roles
├── CONTRIBUTING.md
├── LICENSE
└── .gitignore
```

---

## How to Run

**Prerequisites:** Java JDK 11 or higher

```bash
# Clone the repository
git clone https://github.com/achinthajayaweera/University_Registration_System.git
cd University_Registration_System

# Compile
javac src/finalProjectDuplicate/*.java

# Run
java -cp src finalProjectDuplicate.Main
```

---

## Test Credentials

| Username   | Password   | Role    |
|------------|------------|---------|
| admin1     | admin1a    | Admin   |
| advisor1   | advisor1a  | Advisor |
| advisor2   | advisor2a  | Advisor |
| 2408050001 | JakeLee    | Student |
| 2409110003 | TinTun     | Student |
| 2409240001 | Khant      | Student |

---

## Documentation

- [docs/USER_GUIDE.md](docs/USER_GUIDE.md) — step-by-step guide for all three roles
- [docs/SYSTEM_DESIGN.md](docs/SYSTEM_DESIGN.md) — architecture decisions, validation chain, credit calculation and known limitations
- [CONTRIBUTING.md](CONTRIBUTING.md) — setup instructions and code conventions

---

## License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
