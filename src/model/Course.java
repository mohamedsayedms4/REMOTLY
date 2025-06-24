package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Course in the system, offered by a teacher for a specific academic year.
 * Students can enroll in or unenroll from this course.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public class Course {
    private final String name;
    private final int id;
    private final int numberOfSessions;
    private final int numberOfHours;
    private final String teacherName;
    private final AcademicYear academicYear;

    private final List<Lesson> lessons = new ArrayList<>();
    private final List<Student> enrolledStudents = new ArrayList<>();

    public Course(String name, int id, int numberOfSessions, int numberOfHours,
                  String teacherName, AcademicYear academicYear) {
        this.name = name;
        this.id = id;
        this.numberOfSessions = numberOfSessions;
        this.numberOfHours = numberOfHours;
        this.teacherName = teacherName;
        this.academicYear = academicYear;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }



    /**
     * Enrolls a student in this course if not already enrolled.
     *
     * @param student the student to enroll
     */
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    /**
     * Unenrolls a student from this course.
     *
     * @param student the student to remove
     */
    public void unenrollStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }



    @Override
    public String toString() {
        return name + " (Teacher: " + teacherName + ", Year: " + academicYear.getDisplayName() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
