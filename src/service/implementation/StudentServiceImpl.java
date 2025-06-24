package service.implementation;

import model.AcademicYear;
import model.Course;
import model.Student;
import model.Subject;
import service.StudentService;

import java.util.Map;

/**
 * Implementation of the StudentService interface.
 * Provides logic for enrolling in subjects, updating grades, and listing subjects.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public class StudentServiceImpl implements StudentService {

    private final Student student;

    public StudentServiceImpl(Student student) {
        this.student = student;
    }

    /**
     * Displays available subjects for the student's academic year.
     */
    @Override
    public void showAvailableSubjects() {
        try {
            Map<Subject, Integer> subjects = student.getSubjects();
            AcademicYear academicYear = student.getAcademicYear();

            System.out.println("📚 Available subjects for student in " + academicYear.getDisplayName() + ":");

            boolean found = false;
            int count = 1;

            for (Subject subject : Subject.getSubjectsByAcademicYear(academicYear)) {
                if (!subjects.containsKey(subject)) {
                    System.out.println(count + "- " + subject.getEnglishName());
                    found = true;
                    count++;
                }
            }

            if (!found) {
                System.out.println("✅ You are already enrolled in all available subjects for your year.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error while showing available subjects: " + e.getMessage());
        }
    }

    /**
     * Enrolls the student in a given course if valid.
     *
     * @param course the course to enroll in
     * @return -1: invalid year, 1: already enrolled, 2: successfully enrolled, -99: unexpected error
     */
    @Override
    public int subscribeToCourse(Course course) {
        try {
            AcademicYear academicYear = student.getAcademicYear();
            Map<Course, Integer> enrolledCourses = student.getCourses();

            if (!course.getAcademicYear().equals(academicYear)) {
                System.out.println("❌ Cannot enroll: Course \"" + course.getName() + "\" is not for your academic year (" + academicYear.getDisplayName() + ").");
                return -1;
            }

            if (enrolledCourses.containsKey(course)) {
                System.out.println("ℹ️ Already enrolled in: " + course.getName());
                return 1;
            }

            enrolledCourses.put(course, 0); // Default grade
            course.enrollStudent(student);  // Add to course's list
            System.out.println("✅ Successfully enrolled in course: " + course.getName());
            return 2;

        } catch (Exception e) {
            System.out.println("⚠️ Error while subscribing to course: " + e.getMessage());
            return -99;
        }
    }

    /**
     * Displays all courses the student is currently enrolled in.
     */
    @Override
    public void showSubscribedCourses() {
        try {
            Map<Course, Integer> courses = student.getCourses();
            System.out.println("📖 Subscribed Courses:");
            if (courses.isEmpty()) {
                System.out.println("❗ You are not subscribed to any courses.");
                return;
            }

            for (Map.Entry<Course, Integer> entry : courses.entrySet()) {
                System.out.println("- " + entry.getKey().getName() + " (Grade: " + entry.getValue() + ")");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error while displaying subscribed courses: " + e.getMessage());
        }
    }

    /**
     * Unsubscribes the student from a given course.
     *
     * @param course the course to unsubscribe from
     * @return 1: successfully removed, 0: was not enrolled
     */
    @Override
    public int unsubscribeFromCourse(Course course) {
        try {
            Map<Course, Integer> enrolledCourses = student.getCourses();
            if (enrolledCourses.containsKey(course)) {
                enrolledCourses.remove(course);
                course.unenrollStudent(student);
                System.out.println("✅ Unsubscribed from course: " + course.getName());
                return 1;
            } else {
                System.out.println("❌ Cannot unsubscribe: Not enrolled in course " + course.getName());
                return 0;
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error while unsubscribing from course: " + e.getMessage());
            return -99;
        }
    }

    @Override
    public void showCourseDetails(Course course) {
        System.out.println("Course Details:");
        System.out.println("id : "+ course.getId());
        System.out.println("name : "+ course.getName());
        System.out.println("Teacher name : "+ course.getTeacherName());
        System.out.println("Number of sessions : "+ course.getNumberOfSessions());
        System.out.println("Hours : "+ course.getNumberOfHours());
        System.out.println("lessons" + course.getLessons());
    }
}
