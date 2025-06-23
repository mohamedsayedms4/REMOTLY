package model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Student class represents a student entity that inherits from UserBaseEntity.
 * It adds a specific field "score", academic year information, and enrolled subjects with grades.
 *
 * Author: Mohamed Sayed
 * Date: 22-6-2025
 * Version: 2.0
 */
public class Student extends UserBaseEntity {

    private int score;
    private AcademicYear academicYear;

    private Map<Subject, Integer> subjects = new HashMap<>();

    /**
     * Private constructor to enforce the use of the builder pattern.
     *
     * @param builder the StudentBuilder instance with required and optional fields
     */
    private Student(StudentBuilder builder) {
        super(builder);
        this.score = builder.score;
        this.academicYear = builder.academicYear;
        this.subjects = new HashMap<>();
    }

    /**
     * Builder class for Student object.
     * Supports building Student objects using method chaining.
     */
    public static class StudentBuilder extends BaseBuilder<StudentBuilder> {
        private int score;
        private AcademicYear academicYear;

        /**
         * Constructor used for full sign-up with all required fields.
         *
         * @param firstName student's first name
         * @param lastName student's last name
         * @param userName username for login
         * @param password password for login
         * @param email    student's email address
         * @param gender   student's gender
         */
        public StudentBuilder(String firstName, String lastName, String userName,
                              String password, String email, String gender) {
            super(firstName, lastName, userName, password, email, gender);
        }

        /**
         * Constructor used for login/sign-in only.
         *
         * @param userName username for login
         * @param password password for login
         */
        public StudentBuilder(String userName, String password) {
            super(userName, password);
        }

        /**
         * Sets the total score for the student.
         *
         * @param score total score
         * @return the builder instance
         */
        public StudentBuilder setScore(int score) {
            this.score = score;
            return this;
        }

        /**
         * Sets the academic year for the student.
         *
         * @param academicYear academic year enum
         * @return the builder instance
         */
        public StudentBuilder setAcademicYear(AcademicYear academicYear) {
            this.academicYear = academicYear;
            return this;
        }

        /**
         * Gets the academic year (optional use).
         *
         * @return academic year
         */
        public AcademicYear getAcademicYear() {
            return academicYear;
        }

        @Override
        protected StudentBuilder self() {
            return this;
        }

        /**
         * Builds and returns a Student instance.
         *
         * @return new Student object
         */
        public Student build() {
            return new Student(this);
        }
    }

    // ========== Getters & Setters ==========

    /**
     * Returns the total score.
     *
     * @return student's total score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the total score.
     *
     * @param score new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the academic year of the student.
     *
     * @return academic year
     */
    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    /**
     * Returns the map of subjects and their associated grades.
     *
     * @return subjects and grades map
     */
    public Map<Subject, Integer> getSubjects() {
        return subjects;
    }

    /**
     * Updates the grade for a given subject if the student is enrolled in it.
     *
     * @param subject the subject to update
     * @param grade   the new grade
     */
    public void setSubjectGrade(Subject subject, int grade) {
        if (subjects.containsKey(subject)) {
            subjects.put(subject, grade);
        } else {
            System.out.println("هذا الطالب لا يدرس المادة: " + subject.getArabicName());
        }
    }

    /**
     * Prints all enrolled subjects and their current grades.
     */
    public void printSubjects() {
        System.out.println("المواد الدراسية للطالب في " + academicYear.getDisplayName() + ":");
        subjects.forEach((subject, grade) ->
                System.out.println("- " + subject.getArabicName() + " (الدرجة: " + grade + ")"));
    }

    /**
     * Enrolls the student in a subject if it is available in their academic year and not already enrolled.
     *
     * @param subject the subject to enroll in
     */
    public void enrollInSubject(Subject subject) {
        if (subjects.containsKey(subject)) {
            System.out.println("أنت بالفعل مشترك في المادة: " + subject.getArabicName());
        } else if (!subject.isAvailableIn(academicYear)) {
            System.out.println("المادة " + subject.getArabicName() + " غير متاحة لسنتك الدراسية.");
        } else {
            subjects.put(subject, 0); // Default initial grade
            System.out.println("تم الاشتراك في المادة: " + subject.getArabicName());
        }
    }

    /**
     * Enrolls the student in a list of subjects.
     *
     * @param subjectList list of subjects to enroll in
     */
    public void enrollInSubjects(List<Subject> subjectList) {
        for (Subject subject : subjectList) {
            enrollInSubject(subject);
        }
    }

    /**
     * Returns a list of subjects available for enrollment
     * based on the student's academic year and current enrollments.
     */
    public List<Subject> getAvailableSubjectsToEnroll() {
        return Subject.getSubjectsByAcademicYear(academicYear)
                .stream()
                .filter(subject -> !subjects.containsKey(subject))
                .collect(Collectors.toList());
    }

    /**
     * Overrides the toString method to return a string representation of the student.
     *
     * @return string summary of the student
     */
    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", score=" + score +
                ", academicYear=" + academicYear +
                ", subjects=" + subjects.keySet().stream()
                .map(Subject::getArabicName)
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
