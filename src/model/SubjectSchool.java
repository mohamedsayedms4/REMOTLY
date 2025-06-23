package model;

import java.util.ArrayList;
import java.util.List;

/**
 * SubjectSchool represents a specific subject offered in a school,
 * associated with a teacher, academic year, and enrolled students.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public class SubjectSchool {

    private String name;
    private int id;
    private int numberOfSessions;
    private int numberOfHours;
    private String teacherName;
    private List<Student> students;
    private AcademicYear academicYear;

    // ===== Constructor =====

    public SubjectSchool(String name, int id, int numberOfSessions, int numberOfHours,
                         String teacherName, AcademicYear academicYear) {
        this.name = name;
        this.id = id;
        this.numberOfSessions = numberOfSessions;
        this.numberOfHours = numberOfHours;
        this.teacherName = teacherName;
        this.academicYear = academicYear;
        this.students = new ArrayList<>();
    }

    // ===== Enroll Student =====

    /**
     * Enrolls a student in this subject.
     *
     * @param student the student to enroll
     */
    public void enrollStudent(Student student) {
        if (students.contains(student)) {
            System.out.println(student.getFullName() + " is already enrolled in " + name);
        } else {
            students.add(student);
            System.out.println(student.getFullName() + " enrolled in " + name);
        }
    }

    // ===== Getters and Setters =====

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

    public List<Student> getStudents() {
        return students;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
