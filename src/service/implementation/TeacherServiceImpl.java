package service.implementation;

import model.Course;
import model.Lesson;
import model.Student;
import model.Teacher;
import service.TeacherService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the TeacherService interface.
 * Allows teachers to create and manage subject offerings (Course).
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public class TeacherServiceImpl implements TeacherService {

    private final Teacher teacher;

    public TeacherServiceImpl(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int addCourse(Course course) {
        try {
            List<Course> courses = teacher.getCourses();
            if (courses.contains(course)) {
                System.out.println("⚠️ Course already exists: " + course.getName());
                return 1; // Already exists
            }
            courses.add(course);
            System.out.println("✅ Course added: " + course.getName());
            return 2; // Successfully added
        } catch (Exception e) {
            System.out.println("❌ Error while adding course: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int removeCourse(Course course) {
        try {
            List<Course> courses = teacher.getCourses();
            if (courses.remove(course)) {
                System.out.println("✅ Course removed: " + course.getName());
                return 1; // Successfully removed
            } else {
                System.out.println("⚠️ Course not found: " + course.getName());
                return 0; // Not found
            }
        } catch (Exception e) {
            System.out.println("❌ Error while removing course: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateCourse(Course updatedCourse) {
        try {
            List<Course> courses = teacher.getCourses();
            for (int i = 0; i < courses.size(); i++) {
                Course existing = courses.get(i);
                if (existing.equals(updatedCourse)) {
                    courses.set(i, updatedCourse);
                    System.out.println("✅ Course updated: " + updatedCourse.getName());
                    return 1; // Updated
                }
            }
            System.out.println("⚠️ Course not found to update: " + updatedCourse.getName());
            return 0; // Not found
        } catch (Exception e) {
            System.out.println("❌ Error while updating course: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int addLesson(Course course, Lesson lesson) {
        try {
            List<Lesson> lessons = course.getLessons();
            if (lessons.contains(lesson)) {
                System.out.println("⚠️ Lesson already exists in course: " + lesson.getTitle());
                return 1; // موجود بالفعل
            }
            lessons.add(lesson);
//            lessons.g
            System.out.println("✅ Lesson added to course: " + lesson.getTitle());
            return 2; // تم الإضافة بنجاح
        } catch (Exception e) {
            System.out.println("❌ Error adding lesson: " + e.getMessage());
            return -1; // خطأ عام
        }
    }

    @Override
    public int removeLesson(Course course, Lesson lesson) {
        try {
            List<Lesson> lessons = course.getLessons();
            if (lessons.remove(lesson)) {
                System.out.println("✅ Lesson removed: " + lesson.getTitle());
                return 1; // تم الحذف بنجاح
            } else {
                System.out.println("⚠️ Lesson not found in course.");
                return 0; // غير موجود
            }
        } catch (Exception e) {
            System.out.println("❌ Error removing lesson: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateLesson(Course course, Lesson updatedLesson) {
        try {
            List<Lesson> lessons = course.getLessons();
            for (int i = 0; i < lessons.size(); i++) {
                Lesson existing = lessons.get(i);
                if (existing.getId() == updatedLesson.getId()) {
                    lessons.set(i, updatedLesson);
                    System.out.println("✅ Lesson updated: " + updatedLesson.getTitle());
                    return 1;
                }
            }
            System.out.println("⚠️ Lesson not found in course to update.");
            return 0;
        } catch (Exception e) {
            System.out.println("❌ Error updating lesson: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public void showStudents(Course course) {
        for (Student s : course.getEnrolledStudents()) {
            System.out.println("- " + s.getFullName());
        }
    }

}
