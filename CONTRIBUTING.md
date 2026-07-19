# Contributing to University Registration System

Thank you for your interest in contributing! This document outlines how to set up the project locally and the conventions used across the codebase.

---

## Getting Started

### Prerequisites
- Java JDK 11 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java Extension Pack)
- Git

### Setup
```bash
git clone https://github.com/achinthajayaweera/University_Registration_System.git
cd University_Registration_System
javac src/finalProjectDuplicate/*.java
java -cp src finalProjectDuplicate.Main
```

---

## Project Structure

All source files live under `src/finalProjectDuplicate/`. The package name is `finalProjectDuplicate`.

| File | Responsibility |
|---|---|
| `Main.java` | Entry point |
| `LoginPage.java` | Auth + role routing |
| `IDsPasswords.java` | User credential store |
| `Student.java` | Student data model |
| `Course.java` | Course data model |
| `Curriculum.java` | Full course catalogue |
| `TermSchedule.java` | Open sections + stats |
| `AdminFunctions.java` | Admin operations |
| `AdvisorFunctions.java` | Advisor operations |
| `StudentFunctions.java` | Student operations |
| `PrintProgress.java` | Progress reports |

---

## Code Conventions

- **Naming**: camelCase for methods and variables, PascalCase for classes
- **Documentation**: All public methods must have JavaDoc with `@param` and `@return` where applicable
- **Input handling**: All menu dispatchers must validate input ranges with a `while` loop and catch `InputMismatchException`
- **UI**: All tables and headers use `╔═╗` box-drawing characters with `printf` for column alignment
- **Indentation**: 4 spaces

---

## Adding a New Feature

1. Identify which class owns the responsibility (e.g. new advisor feature → `AdvisorFunctions.java`)
2. Add the method with a JavaDoc comment
3. Wire the menu option in the `selection()` dispatcher
4. Test with all three roles to ensure no regressions
