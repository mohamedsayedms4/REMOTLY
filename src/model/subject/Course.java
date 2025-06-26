package model.subject;

import model.constant.AcademicYear;
import model.constant.Subject;
import model.user.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a course taught by a teacher, associated with a specific subject and academic year.
 */
public class Course {

    private final String name;
    private final int schoolId;
    private final int weeks;
    private final int totalHours;
    private final String teacherName;
    private final AcademicYear academicYear;
    private final Subject subject;
    private final List<Lesson> lessons;
    private final List<Student> enrolledStudents;

    public Course(String name, int schoolId, int weeks, int totalHours,
                  String teacherName, AcademicYear academicYear, Subject subject) {
        this.name = name;
        this.schoolId = schoolId;
        this.weeks = weeks;
        this.totalHours = totalHours;
        this.teacherName = teacherName;
        this.academicYear = academicYear;
        this.subject = subject;
        this.lessons = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public int getWeeks() {
        return weeks;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public Subject getSubject() {
        return subject;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addLesson(Lesson lesson) {
        if (!lessons.contains(lesson)) {
            lessons.add(lesson);
        }
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', subject=" + subject.getArabicName() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return name.equals(course.name) &&
                subject == course.subject &&
                academicYear == course.academicYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, academicYear);
    }
}
