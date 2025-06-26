package service.userServiceInterfaces;

import model.subject.Course;
import model.subject.Lesson;

public interface TeacherService {

    int addCourse(Course course);
    int removeCourse(Course course);
    int updateCourse(Course course);

    int addLesson(Course course, Lesson lesson);
    int removeLesson(Course course, Lesson lesson);
    int updateLesson(Course course, Lesson lesson);

    void showStudents(Course course);
}
