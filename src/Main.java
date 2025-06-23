import model.*;

public class Main {
    public static void main(String[] args) {

        Student student = new Student.StudentBuilder(
                "Omar", "Ali", "omar_99", "pass", "omar@example.com", "male"
        ).setAcademicYear(AcademicYear.GRADE_1_SECONDARY)
                .build();

        System.out.println(student.getAvailableSubjectsToEnroll());
        student.enrollInSubject(Subject.ARABIC);
        student.printSubjects();


    }
}
