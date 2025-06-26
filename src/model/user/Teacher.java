package model.user;

import model.constant.Gender;
import model.subject.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Teacher class represents a teacher entity that inherits from {@link UserBaseEntity}.
 * It includes additional information specific to teachers, such as the associated school and the subject taught.
 *
 * Author: Mohamed Sayed
 * Date: 22-6-2025
 * Version: 1.0
 */
public class Teacher extends UserBaseEntity {

    /**
     * Represents the school ID the teacher is associated with.
     */
    private int school;

    /**
     * Represents the name of the subject taught by the teacher.
     */
    private String subjectName;

    private List<Course> courses = new ArrayList<>();

    /**
     * Private constructor to enforce object creation via the builder.
     *
     * @param builder the builder containing teacher data
     */
    private Teacher(TeacherBuilder builder) {
        super(builder);
        this.school = builder.school;
        this.subjectName = builder.subjectName;
    }

    /**
     * Builder class for constructing {@link Teacher} objects.
     * Inherits from {@link BaseBuilder}.
     */
    public static class TeacherBuilder extends BaseBuilder<TeacherBuilder> {
        private int school;
        private String subjectName;

        /**
         * Full data constructor (used for sign-up or profile creation).
         *
         * @param firstName  teacher's first name
         * @param lastName   teacher's last name
         * @param userName   username for login
         * @param password   password for login
         * @param email      teacher's email
         * @param gender     gender of the teacher
         */
        public TeacherBuilder(String firstName, String lastName, String userName, String password, String email, Gender gender) {
            super(firstName, lastName, userName, password, email, gender);
        }

        /**
         * Constructor for login/sign-in only.
         *
         * @param userName  username
         * @param password  password
         */
        public TeacherBuilder(String userName, String password) {
            super(userName, password);
        }

        /**
         * Sets the school ID the teacher is associated with.
         *
         * @param school school ID
         * @return the builder instance
         */
        public TeacherBuilder setSchool(int school) {
            this.school = school;
            return this;
        }

        /**
         * Sets the subject name the teacher teaches.
         *
         * @param subjectName subject name
         * @return the builder instance
         */
        public TeacherBuilder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        /**
         * Returns the current builder instance.
         *
         * @return this builder
         */
        @Override
        protected TeacherBuilder self() {
            return this;
        }

        /**
         * Builds and returns a new {@link Teacher} object.
         *
         * @return constructed Teacher instance
         */
        public Teacher build() {
            return new Teacher(this);
        }
    }

    // ========== Getters & Setters ==========

    /**
     * Gets the school ID.
     *
     * @return school ID
     */
    public int getSchool() {
        return school;
    }

    /**
     * Sets the school ID.
     *
     * @param school school ID
     */
    public void setSchool(int school) {
        this.school = school;
    }

    /**
     * Gets the subject name.
     *
     * @return subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Sets the subject name.
     *
     * @param subjectName subject name
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // ========== toString() ==========

    /**
     * Returns a string representation of the Teacher object.
     *
     * @return string description
     */
    @Override
    public String toString() {
        return super.toString() +
                "school=" + school +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
