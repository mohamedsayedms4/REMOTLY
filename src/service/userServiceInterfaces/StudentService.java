package service.userServiceInterfaces;

import model.subject.Course;
import model.user.Student;
import model.constant.Subject;

import java.util.List;

public interface StudentService {


    void showAvailableSubjects();
    int  subscribeToCourse(Course course);
    void showSubscribedCourses();
    int  unsubscribeFromCourse(Course course);
    void showCourseDetails(Course course);
    void showAvailableCoursesInSubjects(Student student , Subject subject);
    void showAccountDetails(Student student );
    Course getCourseByNameAndSubject(String courseName, Subject subject);
    List<Course> getAvailableCoursesForSubject(Student student, Subject subject);


}
