package service.implementation.user;

import model.*;
import model.constant.AcademicYear;
import model.constant.Subject;
import model.subject.Course;
import model.user.Student;
import service.userServiceInterfaces.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of the StudentService interface.
 * Provides logic for enrolling in subjects, updating grades, and listing subjects.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public class StudentServiceImpl implements StudentService {

    private final Remotly remotly = Remotly.getInstance();
    private final Student student;
    private final Map<Subject, List<Course>> subjectSchoolMap;

    public StudentServiceImpl(Student student, Map<Subject, List<Course>> subjectSchoolMap) {
        this.student = student;
        this.subjectSchoolMap = subjectSchoolMap;
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
//                course.(student);
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
        System.out.println("id : "+ course.getSchoolId());
        System.out.println("name : "+ course.getName());
        System.out.println("Teacher name : "+ course.getTeacherName());
//        System.out.println("Number of sessions : "+ course.g());
        System.out.println("Hours : "+ course.getTotalHours());
        System.out.println("lessons" + course.getLessons());
    }

    @Override
    public void showAvailableCoursesInSubjects(Student student, Subject subject) {
        AcademicYear year = student.getAcademicYear();

        if (!subject.isAvailableIn(year)) {
            System.out.println("❌ Subject '" + subject.getArabicName() + "' is not available in student's academic year: " + year);
            return;
        }

        List<Course> allCourses = Remotly.getInstance().getAllCourses();

        List<Course> matchedCourses = allCourses.stream()
                .filter(course -> course.getAcademicYear() == year)
                .filter(course -> course.getSubject() == subject)
                .collect(Collectors.toList());

        System.out.println("\n📚 Available Courses for Subject: " + subject.getArabicName()
                + " | Student: " + student.getFullName());

        if (matchedCourses.isEmpty()) {
            System.out.println("⚠️ No courses available for this subject.");
        } else {
            for (Course course : matchedCourses) {
                System.out.println("  - " + course.getName() + " (by " + course.getTeacherName() + ")");
            }
        }
    }

    @Override
    public void showAccountDetails(Student student) {
        System.out.println("Account Details:");
        System.out.println("fullName : "+ student.getFullName());
        System.out.println("email : "+ student.getEmail());
        System.out.println("userName : "+ student.getUserName());
        System.out.println("password : "+ student.getPassword());
        System.out.println("academicYear : "+ student.getAcademicYear());
    }

    @Override
    public Course getCourseByNameAndSubject(String courseName, Subject subject) {
        List<Course> courses = Remotly.getInstance().getSubjectSchoolMap().get(subject);
        if (courses == null) return null;

        return courses.stream()
                .filter(c -> c.getName().equalsIgnoreCase(courseName))
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Course> getAvailableCoursesForSubject(Student student, Subject subject) {
        return subjectSchoolMap.getOrDefault(subject, new ArrayList<>());
    }

}
