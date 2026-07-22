# User Guide — University Registration System

## Getting Started

### Compiling and Running
```bash
javac src/finalProjectDuplicate/*.java
java -cp src finalProjectDuplicate.Main
```

### Logging In
When the system starts you will see the login banner:
```
╔═══════════════════════════════════════════════════╗
║     Welcome to Stamford Registration System 🎓    ║
╚═══════════════════════════════════════════════════╝

> Username:
> Password:
```
Enter your username and password. You have **3 attempts** before the account is blocked.

---

## Admin Guide

**Login:** `admin1` / `admin1a`

After login the Admin Menu appears:
```
╔═════════════════════════════════╗
║           Admin Menu            ║
╠═════════════════════════════════╣
║ 1 │ Add courses                 ║
║ 2 │ Remove courses              ║
║ 3 │ Set courses seat limits     ║
║ 4 │ Open courses                ║
║ 5 │ Close courses               ║
║ 6 │ View system statistics      ║
╚═════════════════════════════════╝
```

### Option 1 — Add Course
1. Select option `1`
2. Choose a track/category from the 13-option list (e.g. `4` for IT Software Engineering Track)
3. Enter the course code (e.g. `ITE999`)
4. Enter the course name (e.g. `Advanced Software Engineering`)
5. The updated catalogue for that category is printed

### Option 2 — Remove Course
1. Select option `2`
2. Choose the track/category
3. Enter the course code to remove
4. The updated catalogue is printed

### Option 3 — Set Seat Limit
1. Select option `3`
2. Enter the course code (e.g. `ITE222`)
3. Enter the section number (e.g. `3`)
4. Enter the new seat limit (e.g. `30`)
5. The updated term schedule is printed

### Option 4 — Open Course
1. Select option `4`
2. Enter the course code, section number, time slot, and seat limit
3. Example: `CSC351`, `1`, `Tuesday/Friday 10:30-12:30`, `25`
4. The updated schedule is printed

### Option 5 — Close Course
1. Select option `5`
2. Enter the course code and section number
3. The section is removed and the updated schedule is printed

### Option 6 — View System Statistics
Displays total open courses, total seats, average seats per course, and per-course registration counts.

---

## Advisor Guide

**Login:** `advisor1` / `advisor1a` or `advisor2` / `advisor2a`

```
╔═════════════════════════════════╗
║          Advisor Menu           ║
╠═════════════════════════════════╣
║ 1 │ Search student              ║
║ 2 │ View curriculum progress    ║
║ 3 │ Register course             ║
║ 4 │ Withdrawal course           ║
║ 5 │ View graduation risks       ║
╚═════════════════════════════════╝
```

### Option 1 — Search Student
Enter a student ID (e.g. `2408050001`) to view their full academic record — GPA, credits, completed courses, and current registrations.

### Option 2 — View Curriculum Progress
Enter a student ID to view a full progress report across all curriculum sections — General Courses, Basic Core, Major Requirements, all tracks, Free Electives, and Internship. Each section shows a `█░` progress bar with ✅/⏳ status per course and 🔒 unmet prerequisites.

### Option 3 — Register Course for Student
Enter the student ID, course code, and section number to register a course on their behalf. The same validation rules apply (prerequisites, seat limits, time conflicts, etc.).

### Option 4 — Withdraw Course for Student
Enter the student ID, course code, and section number to drop a course on their behalf.

### Option 5 — View Graduation Risks
Displays a risk report for all students based on their course completion rate per term:

| Courses/Term | Risk |
|---|---|
| < 2 | ⚠ HIGH |
| 2–3 | ~ MEDIUM |
| ≥ 4 | ✓ LOW |

---

## Student Guide

**Login:** Student ID as username, name as password (e.g. `2408050001` / `JakeLee`)

```
╔═════════════════════════════════╗
║          Student Menu           ║
╠═════════════════════════════════╣
║ 1 │ View completed courses      ║
║ 2 │ View remaining courses      ║
║ 3 │ Check prerequisites         ║
║ 4 │ Add course                  ║
║ 5 │ Drop course                 ║
║ 6 │ View registration status    ║
╚═════════════════════════════════╝
```

### Option 1 — View Completed Courses
Shows your full academic record: ID, name, major, terms completed, current credits, GPA, and a list of all completed courses with names.

### Option 2 — View Remaining Courses
Choose your specialisation track to see a filtered progress report showing which courses you still need to complete, with progress bars and prerequisite warnings.

### Option 3 — Check Prerequisites
Enter a course code (e.g. `ITE420`) to see what prerequisites are required before you can register.

### Option 4 — Add Course
Enter the course code and section number. The system validates:
- You haven't already completed or registered for the course
- Prerequisites are met
- The section has available seats
- No time slot conflict with your existing registrations
- You are not exceeding the 4-course per term limit

### Option 5 — Drop Course
Enter the course code and section number to withdraw. The seat is automatically returned to the schedule.

### Option 6 — View Registration Status
Shows your current registered courses in a table with course code, section, and time slot.

---

## Exiting

After every operation you will be asked:
```
Exit (y/n):
```
- Enter `n` to return to your menu
- Enter `y` to log out and exit the system
