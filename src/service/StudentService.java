package service;

import model.Course;

public interface StudentService {


    void showAvailableSubjects();
    int  subscribeToCourse(Course course);
    void showSubscribedCourses();
    int  unsubscribeFromCourse(Course course);
    void showCourseDetails(Course course);


}
