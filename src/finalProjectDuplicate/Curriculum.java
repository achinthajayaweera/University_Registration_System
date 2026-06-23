package finalProjectDuplicate;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {

    public static final int TOTAL_CREDITS  = 160;
    public static final int COURSE_CREDITS = 4;
    public static final int INTERN_CREDITS = 12;

    private static List<Course> course = new ArrayList<>(List.of(

        // ── General Courses ──────────────────────────────────────────────
        // CourseInfo (String category, String code, String name)
        new Course("General Courses", "ART101", "Everyday Art"),
        new Course("General Courses", "ART102", "The Art of Films"),
        new Course("General Courses", "ART103", "Cross-Cultural Storytelling and Digital Communication"),
        new Course("General Courses", "ART104", "Fiction into Film"),
        new Course("General Courses", "ATH101", "Human Evolution When Living Together"),
        new Course("General Courses", "ECO101", "Sufficiency Economy"),
        new Course("General Courses", "ENG101", "Introduction to Academic Writing"),
        new Course("General Courses", "ENG102", "Academic Writing"),
        new Course("General Courses", "ENG103", "College English III"),
        new Course("General Courses", "FIN101", "Managing your Money"),
        new Course("General Courses", "GEO101", "Nations of the World"),
        new Course("General Courses", "GEO102", "World Communities and Cultures"),
        new Course("General Courses", "HIS101", "Asia on the Global Stage"),
        new Course("General Courses", "HIS102", "Origins of the Western Culture"),
        new Course("General Courses", "HIS103", "Origins of the Eastern Culture"),
        new Course("General Courses", "HIS104", "Origins of the Cultures in the East and the West"),
        new Course("General Courses", "LIB101", "Creative Writing"),
        new Course("General Courses", "LIB102", "Popular Fiction"),
        new Course("General Courses", "LIB103", "Presentation Skills"),
        new Course("General Courses", "MAT101", "Fundamentals of Algebra"),
        new Course("General Courses", "MAT102", "Business Mathematics with MS Excel"),
        new Course("General Courses", "MIS101", "Social Media for Everyone"),
        new Course("General Courses", "MIS102", "Digital Shield for Cybercrime"),
        new Course("General Courses", "MIS103", "Introduction to Microsoft 365 Fundamentals"),
        new Course("General Courses", "MIS104", "Introduction to AI Application"),
        new Course("General Courses", "MIS105", "Digital Illustration"),
        new Course("General Courses", "MUS101", "World Music"),
        new Course("General Courses", "PHI101", "Philosophy from the West"),
        new Course("General Courses", "PHI102", "Philosophy from the East"),
        new Course("General Courses", "PHI103", "Philosophy from the East and West"),
        new Course("General Courses", "POL101", "Human Rights and Wrongs"),
        new Course("General Courses", "PSY101", "Everyday Psychology"),
        new Course("General Courses", "PSY102", "Discovering Your Personality"),
        new Course("General Courses", "PSY103", "Driving Business with Psychology"),
        new Course("General Courses", "PSY104", "Transformations of the Self"),
        new Course("General Courses", "SCI101", "Theory of Knowledge"),
        new Course("General Courses", "SCI102", "Environmental Science"),
        new Course("General Courses", "SOC101", "Everyday Modern Society"),
        new Course("General Courses", "SOC102", "Seminars on Current Business Cultures and Issues"),
        new Course("General Courses", "SOC103", "Everyday Religious Beliefs"),
        new Course("General Courses", "SOC104", "Soft Power and Global Influence"),
        new Course("General Courses", "SOC105", "Personal Branding"),
        new Course("General Courses", "SOC106", "Well-Being of the Mind and Body"),
        new Course("General Courses", "STA101", "Statistics for Everyday Life and Beyond"),
        new Course("General Courses", "CHI101", "Everyday Chinese 1"),
        new Course("General Courses", "CHI102", "Everyday Chinese 2"),
        new Course("General Courses", "CHI103", "Everyday Chinese 3"),
        new Course("General Courses", "THA101", "Everyday Thai 1"),
        new Course("General Courses", "THA102", "Everyday Thai 2"),
        new Course("General Courses", "THA103", "Everyday Thai 3"),
        new Course("General Courses", "FRN101", "Everyday French 1"),
        new Course("General Courses", "FRN102", "Everyday French 2"),
        new Course("General Courses", "FRN103", "Everyday French 3"),

        // ── IT Basic Core ─────────────────────────────────────────────────
        new Course("IT Basic Core", "BSC101", "Introduction to Computing and Intelligence Systems"),
        new Course("IT Basic Core", "BSC103", "Introduction to Data Structures and Algorithms Analysis"),
        new Course("IT Basic Core", "BSC102", "Discrete Mathematics Structures"),
        new Course("IT Basic Core", "BSC104", "Computer Organization"),
        new Course("IT Basic Core", "BSC210", "Ethics and Professional Issues in Computing and Intelligence Systems"),
        new Course("IT Basic Core", "BSC479", "Software Planning and Project Management"),
        new Course("IT Basic Core", "BSC321", "System Analysis, Design, and Implementation"),
        new Course("IT Basic Core", "BSC254", "Human Computer Interaction"),
        new Course("IT Basic Core", "BSC120", "Web Development I"),
        new Course("IT Basic Core", "BSC224", "Introduction to Data Science"),

        // ── IT Major Requirements ─────────────────────────────────────────
        new Course("IT Major Requirements", "ITE221", "IT Programming I"),
        new Course("IT Major Requirements", "ITE222", "IT Programming II"),
        new Course("IT Major Requirements", "ITE231", "System Administration and Maintenance"),
        new Course("IT Major Requirements", "ITE233", "Introduction to Internet of Things"),
        new Course("IT Major Requirements", "ITE240", "Operating Systems"),
        new Course("IT Major Requirements", "ITE331", "Introduction to 3D Modeling and Virtual Reality"),
        new Course("IT Major Requirements", "ITE441", "Database Management Systems I"),
        new Course("IT Major Requirements", "ITE442", "Database Management Systems II"),
        new Course("IT Major Requirements", "ITE475", "Network I"),
        new Course("IT Major Requirements", "ITE420", "Information Assurance and Security I"),

        // ── IT Tracks ─────────────────────────────────────────────────────
        new Course("IT Software Engineering Track", "ITE220", "Web Development II"),
        new Course("IT Software Engineering Track", "ITE367", "Software Architecture and Modelling"),
        new Course("IT Software Engineering Track", "ITE343", "Mobile Application Development"),
        new Course("IT Software Engineering Track", "ITE368", "Software Testing and Maintenance"),
        new Course("IT Software Engineering Track", "ITE365", "Software Quality Management"),

        new Course("IT E-Commerce Track", "MKT213", "Principles of Marketing"),
        new Course("IT E-Commerce Track", "MKT345", "Gamification"),
        new Course("IT E-Commerce Track", "MKT333", "Digital Marketing"),
        new Course("IT E-Commerce Track", "ITE362", "Digital Advertising Technology"),
        new Course("IT E-Commerce Track", "ITE340", "E-Commerce Systems & Infrastructure"),

        new Course("IT Data Science Track", "ITE351", "Programming for Data Science"),
        new Course("IT Data Science Track", "ITE354", "Business Intelligence and Decision Modeling"),
        new Course("IT Data Science Track", "ITE352", "Artificial Intelligence"),
        new Course("IT Data Science Track", "ITE355", "Data Warehousing and Data Mining"),
        new Course("IT Data Science Track", "ITE353", "Machine Learning Foundation"),

        new Course("IT Network & Security Track", "ITE201", "IT Service Desk & Incident Management"),
        new Course("IT Network & Security Track", "ITE476", "Network II"),
        new Course("IT Network & Security Track", "ITE421", "Information Assurance and Security II"),
        new Course("IT Network & Security Track", "ITE477", "Windows Server"),
        new Course("IT Network & Security Track", "ITE451", "AWS Cloud Operations"),

        // ── CS Basic Core ─────────────────────────────────────────────────
        new Course("CS Basic Core", "BSC101", "Introduction to Computing and Intelligence Systems"),
        new Course("CS Basic Core", "BSC102", "Discrete Mathematics Structures"),
        new Course("CS Basic Core", "BSC103", "Introduction to Data Structures and Algorithms Analysis"),
        new Course("CS Basic Core", "BSC104", "Computer Organization"),
        new Course("CS Basic Core", "BSC120", "Web Development I"),
        new Course("CS Basic Core", "BSC210", "Ethics and Professional Issues in Information Technology"),
        new Course("CS Basic Core", "BSC224", "Introduction to Data Science"),
        new Course("CS Basic Core", "BSC254", "Human Computer Interaction"),
        new Course("CS Basic Core", "BSC321", "System Analysis, Design, and Implementation"),
        new Course("CS Basic Core", "BSC479", "Software Planning and Project Management"),

        // ── CS Major Requirements ─────────────────────────────────────────
        new Course("CS Major Requirements", "CSC221", "Java Programming I"),
        new Course("CS Major Requirements", "CSC222", "Java Programming II"),
        new Course("CS Major Requirements", "CSC231", "System Programming"),
        new Course("CS Major Requirements", "CSC233", "Introduction to Internet of Things"),
        new Course("CS Major Requirements", "CSC240", "Operating Systems and Maintenance"),
        new Course("CS Major Requirements", "CSC331", "Computer Graphics"),
        new Course("CS Major Requirements", "CSC420", "Data Communication Technologies"),
        new Course("CS Major Requirements", "CSC441", "Data Management"),
        new Course("CS Major Requirements", "CSC442", "Databases"),
        new Course("CS Major Requirements", "CSC475", "Computing Network"),

        // ── CS Tracks ─────────────────────────────────────────────────────
        new Course("CS Software Engineering Track", "CSC220", "Web Development II"),
        new Course("CS Software Engineering Track", "CSC343", "Mobile Application Development"),
        new Course("CS Software Engineering Track", "CSC365", "Software Quality Assurance Principles"),
        new Course("CS Software Engineering Track", "CSC367", "Software Architecture and Modelling"),
        new Course("CS Software Engineering Track", "CSC368", "Software Testing and Maintenance"),
        new Course("CS Software Engineering Track", "CSC369", "Software Program Capstone Project"),

        new Course("CS Cyber Security Track", "CSC201", "Computer Service Desk & Incident Management"),
        new Course("CS Cyber Security Track", "CSC421", "Security in Computing and Information Technology"),
        new Course("CS Cyber Security Track", "CSC451", "Cloud Foundations"),
        new Course("CS Cyber Security Track", "CSC476", "Network II"),
        new Course("CS Cyber Security Track", "CSC453", "Computer and Internet Forensics"),
        new Course("CS Cyber Security Track", "CSC452", "Blockchain Technology Practices"),

        new Course("CS Artificial Intelligence Track", "CSC351", "Programming for Data Science"),
        new Course("CS Artificial Intelligence Track", "CSC353", "Machine Learning Foundation"),
        new Course("CS Artificial Intelligence Track", "CSC357", "AI Capstone Project"),
        new Course("CS Artificial Intelligence Track", "CSC352", "Artificial Intelligence"),
        new Course("CS Artificial Intelligence Track", "CSC356", "AI Ethics and Responsible AI"),
        new Course("CS Artificial Intelligence Track", "CSC354", "AI in Business and Decision Modeling"),

        // ── Internship ────────────────────────────────────────────────────
        new Course("Internship", "INTERN", "Internship"),

        // ── Prerequisites ─────────────────────────────────────────────────
        // Course (String category, String code, String[] prerequisite)
        new Course("prerequisite", "ENG102",  new String[]{"ENG101"}),
        new Course("prerequisite", "ENG103",  new String[]{"ENG102"}),
        new Course("prerequisite", "MAT102",  new String[]{"MAT101"}),
        new Course("prerequisite", "STA101",  new String[]{"MAT101"}),
        new Course("prerequisite", "BSC102",  new String[]{"MAT101"}),
        new Course("prerequisite", "BSC224",  new String[]{"BSC102", "STA101"}),
        new Course("prerequisite", "BSC120",  new String[]{"BSC254", "CSC221"}),
        new Course("prerequisite", "ITE221",  new String[]{"BSC103"}),
        new Course("prerequisite", "ITE222",  new String[]{"ITE221"}),
        new Course("prerequisite", "ITE233",  new String[]{"ITE221"}),
        new Course("prerequisite", "ITE442",  new String[]{"ITE441"}),
        new Course("prerequisite", "ITE420",  new String[]{"ITE475"}),
        new Course("prerequisite", "ITE220",  new String[]{"ITE222"}),
        new Course("prerequisite", "ITE343",  new String[]{"ITE222"}),
        new Course("prerequisite", "ITE368",  new String[]{"ITE222"}),
        new Course("prerequisite", "ITE367",  new String[]{"BSC321"}),
        new Course("prerequisite", "ITE351",  new String[]{"BSC224"}),
        new Course("prerequisite", "ITE354",  new String[]{"BSC224"}),
        new Course("prerequisite", "ITE352",  new String[]{"BSC224"}),
        new Course("prerequisite", "ITE355",  new String[]{"BSC224"}),
        new Course("prerequisite", "ITE353",  new String[]{"BSC224"}),
        new Course("prerequisite", "ITE476",  new String[]{"ITE475"}),
        new Course("prerequisite", "ITE421",  new String[]{"ITE420"}),
        new Course("prerequisite", "CSC476",  new String[]{"CSC475"}),
        new Course("prerequisite", "CSC452",  new String[]{"CSC475"}),
        new Course("prerequisite", "CSC221",  new String[]{"BSC103"}),
        new Course("prerequisite", "CSC222",  new String[]{"CSC221"}),
        new Course("prerequisite", "CSC233",  new String[]{"CSC221"}),
        new Course("prerequisite", "CSC442",  new String[]{"CSC441"}),
        new Course("prerequisite", "CSC420",  new String[]{"CSC475"}),
        new Course("prerequisite", "CSC220",  new String[]{"CSC222"}),
        new Course("prerequisite", "CSC343",  new String[]{"CSC222"}),
        new Course("prerequisite", "CSC368",  new String[]{"CSC222"}),
        new Course("prerequisite", "CSC367",  new String[]{"BSC321"}),
        new Course("prerequisite", "CSC365",  new String[]{"BSC479"}),
        new Course("prerequisite", "CSC351",  new String[]{"BSC224"}),
        new Course("prerequisite", "CSC352",  new String[]{"BSC224"}),
        new Course("prerequisite", "CSC353",  new String[]{"BSC224"}),
        new Course("prerequisite", "CSC356",  new String[]{"BSC224"}),
        new Course("prerequisite", "CSC354",  new String[]{"BSC224"}),

        // ── Equivalencies ─────────────────────────────────────────────────
        // Course (String category, String code, String equivalence, String name)
        new Course("Equivalency", "ITE102", "BSC102", "Discrete Mathematics Structures"),
        new Course("Equivalency", "ITE101", "BSC101", "Introduction to Computing and Intelligence Systems"),
        new Course("Equivalency", "ITE103", "BSC103", "Introduction to Data Structures and Algorithms Analysis"),
        new Course("Equivalency", "ITE104", "BSC104", "Computer Organization"),
        new Course("Equivalency", "ITE210", "BSC210", "Ethics and Professional Issues in Computing and Intelligence Systems"),
        new Course("Equivalency", "ITE321", "BSC321", "System Analysis, Design, and Implementation"),
        new Course("Equivalency", "ITE479", "BSC479", "Software Planning and Project Management"),
        new Course("Equivalency", "ITE254", "BSC254", "Human Computer Interaction"),
        new Course("Equivalency", "ITE224", "BSC224", "Introduction to Data Science"),
        new Course("Equivalency", "ITE233", "CSC233", "Introduction to Internet of Things"),
        new Course("Equivalency", "ITE441", "CSC441", "Data Management"),
        new Course("Equivalency", "ITE442", "CSC442", "Databases"),
        new Course("Equivalency", "ITE221", "CSC221", "Java Programming I"),
        new Course("Equivalency", "ITE222", "CSC222", "Java Programming II"),
        new Course("Equivalency", "ITE240", "CSC240", "Operating Systems and Maintenance"),
        new Course("Equivalency", "ITE475", "CSC475", "Computing Network"),
        new Course("Equivalency", "ITE220", "CSC220", "Web Development II"),
        new Course("Equivalency", "ITE343", "CSC343", "Mobile Application Development"),
        new Course("Equivalency", "ITE365", "CSC365", "Software Quality Assurance Principles"),
        new Course("Equivalency", "ITE367", "CSC367", "Software Architecture and Modelling"),
        new Course("Equivalency", "ITE368", "CSC368", "Software Testing and Maintenance"),
        new Course("Equivalency", "ITE201", "CSC201", "Computer Service Desk & Incident Management"),
        new Course("Equivalency", "ITE421", "CSC421", "Security in Computing and Information Technology"),
        new Course("Equivalency", "ITE451", "CSC451", "Cloud Foundations"),
        new Course("Equivalency", "ITE476", "CSC476", "Network II"),
        new Course("Equivalency", "ITE351", "CSC351", "Programming for Data Science"),
        new Course("Equivalency", "ITE352", "CSC352", "Artificial Intelligence"),
        new Course("Equivalency", "ITE353", "CSC353", "Machine Learning Foundation"),
        new Course("Equivalency", "ITE354", "CSC354", "AI in Business and Decision Modeling")

    ));

    // Getter
    public List<Course> getCourse() {
        return course;
    }

    // Display curriculum filtered by category
    public void printCurriculum(String category) {
        System.out.println("\n -----------------------------------------------------------------------------------------");
        System.out.println(" The New Curriculum Is:                                                                    ");
        System.out.println(" -----------------------------------------------------------------------------------------");
        System.out.println("| Course Code | Course Name                                                                ");
        for (Course c : course) {
            if (c.getCategory().equals(category)) {
                System.out.println("| " + c.getCode() + "      | " + c.getName());
            }
        }
        System.out.println(" -----------------------------------------------------------------------------------------\n");
    }

    // Add a new course to the curriculum
    public void newCourses(String category, String code, String name) {
        course.add(new Course(category, code, name));
        printCurriculum(category);
    }

    // Remove a course from the curriculum
    public void deleteCourses(String category, String code, String name) {
        course.removeIf(c -> (c.getCategory().equals(category) && c.getCode().equals(code)));
        printCurriculum(category);
    }

}
