# System Design — University Registration System

## 1. Overview

The University Registration System is a role-based console application built in Java. It serves three user types — Admin, Advisor, and Student — each with a distinct set of operations. The system uses an in-memory data model with no external database, making it fully self-contained and portable.

---

## 2. Design Decisions

### 2.1 Role-Based Access via Boolean Flags
After a successful login, `LoginPage` sets one of three boolean flags (`admin`, `advisor`, `student`). Each flag drives its own `while` loop in `checkRole()`, which keeps the user in their menu until they choose to exit. This approach keeps role routing simple and explicit without requiring an enum or inheritance hierarchy.

### 2.2 Four-Constructor Course Model
`Course.java` has four constructors, each serving a different purpose:

| Constructor | Purpose |
|---|---|
| `Course(category, code, name)` | Curriculum listing |
| `Course(category, code, prerequisite[])` | Prerequisite mapping |
| `Course(category, code, equivalence, name)` | Equivalency mapping |
| `Course(code, section, timeSlot, seats)` | Term schedule entry |

Using one class for all four roles avoids the overhead of separate `Prerequisite`, `Equivalency`, and `ScheduledCourse` classes while keeping all course data in a single list that can be filtered by `category`.

### 2.3 Static Lists for Shared State
`TermSchedule.schedule` and `StudentFunctions.student` are `static` lists. This ensures that seat deductions during registration are immediately visible to all parts of the system within the same session — simulating what a database would provide in a production system.

### 2.4 Equivalency Resolution in PrintProgress
When generating a progress report, `PrintProgress` resolves equivalencies on the fly by scanning the `Equivalency` category in `Curriculum`. If a student completed `ITE222`, this resolves to `CSC222` for CS students, meaning the course counts toward their CS curriculum without being listed twice.

---

## 3. Course Registration Validation Chain

When a student (or advisor) registers a course, `StudentFunctions.registerCourse()` applies the following checks in order:

```
1. Student exists?                  → ❌ "Student not found"
2. Course already completed?        → ❌ "You have completed this course"
3. Already registered this section? → ❌ "Already registered"
4. Registering INTERN?              → check credits ≥ 148
5. Prerequisite unmet?              → ❌ list missing prereqs
6. Exceeds 4-course load limit?     → ❌ "Exceed course limit"
7. Time slot conflict?              → ❌ "Time conflict detected"
8. Course open this term?           → ❌ "Course is not open"
9. Seats available?                 → ❌ "No seat available"
10. All checks pass                 → ✅ Register + deduct seat
```

---

## 4. Credit Calculation

Credits are calculated in `StudentFunctions.currentCredit()`:

- Each completed course = `COURSE_CREDITS` (4 credits)
- INTERN = `INTERN_CREDITS` (12 credits), replacing one course credit slot
- Free electives count as regular courses

Formula:
```
totalCredits = (completedCourses.size() + freeElective.size()) × 4
             + (12 - 4) if INTERN is in completedCourses
```

A student needs **160 total credits** to graduate (`Curriculum.TOTAL_CREDITS`). INTERN registration is blocked until the student has at least **148 credits**.

---

## 5. Graduation Risk Calculation

`AdvisorFunctions.graduationRisks()` divides total courses completed by `termsCount`:

| Courses per term | Risk Level |
|---|---|
| < 2 | ⚠ HIGH |
| 2–3 | ~ MEDIUM |
| ≥ 4 | ✓ LOW |

This gives advisors a quick signal of which students are falling behind the pace needed to graduate on time.

---

## 6. Known Limitations

- **No persistence**: All data is in-memory. Changes (registrations, seat edits) are lost when the program exits.
- **Single session**: The system does not support concurrent users.
- **Hardcoded users**: Credentials are defined in `IDsPasswords.java`. A production version would use a database with hashed passwords.
- **No term management**: The system assumes a single active term. A production version would support multiple terms with historical records.
