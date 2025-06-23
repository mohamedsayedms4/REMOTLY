package service;

import model.Subject;
import model.SubjectSchool;

import java.util.List;

public interface StudentService {

    void printEnrolledSubjectSchools();
    void enrollInSubjectSchool(SubjectSchool subjectSchool);
    List<Subject> getAvailableSubjectsToEnroll();
    void enrollInSubjects(List<Subject> subjectList);
    void enrollInSubject(Subject subject);
    void printSubjects();
    void setSubjectGrade(Subject subject, int grade);
}
