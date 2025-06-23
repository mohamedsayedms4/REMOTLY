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

    private Map<SubjectSchool, Integer> enrolledSubjects = new HashMap<>();

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

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public void setSubjects(Map<Subject, Integer> subjects) {
        this.subjects = subjects;
    }

    public Map<SubjectSchool, Integer> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(Map<SubjectSchool, Integer> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }
}
