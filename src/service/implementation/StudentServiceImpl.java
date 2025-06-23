package service.implementation;

import model.AcademicYear;
import model.Student;
import model.Subject;
import model.SubjectSchool;
import service.StudentService;

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

    private final Student student;

    public StudentServiceImpl(Student student) {
        this.student = student;
    }

    @Override
    public void setSubjectGrade(Subject subject, int grade) {
        Map<Subject, Integer> subjects = student.getSubjects();
        if (subjects.containsKey(subject)) {
            subjects.put(subject, grade);
        } else {
            System.out.println("This student is not enrolled in: " + subject.getArabicName());
        }
    }

    @Override
    public void printSubjects() {
        Map<Subject, Integer> subjects = student.getSubjects();
        AcademicYear academicYear = student.getAcademicYear();
        System.out.println("Subjects for student in " + academicYear.getDisplayName() + ":");
        subjects.forEach((subject, grade) ->
                System.out.println("- " + subject.getArabicName() + " (Grade: " + grade + ")"));
    }

    @Override
    public void enrollInSubject(Subject subject) {

        Map<Subject, Integer> subjects = student.getSubjects();
        AcademicYear academicYear = student.getAcademicYear();
        if (subjects.containsKey(subject)) {
            System.out.println("Already enrolled in: " + subject.getArabicName());
        } else if (!subject.isAvailableIn(academicYear)) {
            System.out.println("Subject " + subject.getArabicName() + " is not available for your academic year.");
        } else {
            subjects.put(subject, 0); // Initial grade = 0
            System.out.println("Enrolled in: " + subject.getArabicName());
        }
    }

    @Override
    public void enrollInSubjects(List<Subject> subjectList) {
        for (Subject subject : subjectList) {
            enrollInSubject(subject);
        }
    }

    @Override
    public List<Subject> getAvailableSubjectsToEnroll() {
        AcademicYear academicYear = student.getAcademicYear();
        Map<Subject, Integer> subjects = student.getSubjects();
        return Subject.getSubjectsByAcademicYear(academicYear)
                .stream()
                .filter(subject -> !subjects.containsKey(subject))
                .collect(Collectors.toList());
    }

    @Override
    public void enrollInSubjectSchool(SubjectSchool subjectSchool) {
        AcademicYear academicYear = student.getAcademicYear();
        Map<SubjectSchool, Integer> enrolledSubjects = student.getEnrolledSubjects();

        if (!subjectSchool.getAcademicYear().equals(academicYear)) {
            System.out.println("Cannot enroll: subject not for student's academic year.");
            return;
        }

        if (enrolledSubjects.containsKey(subjectSchool)) {
            System.out.println("Already enrolled in: " + subjectSchool.getName());
        } else {
            enrolledSubjects.put(subjectSchool, 0); // Initial grade = 0
            subjectSchool.enrollStudent(student);   // Add student to subject
            System.out.println("Enrolled in subject: " + subjectSchool.getName());
        }
    }

    @Override
    public void printEnrolledSubjectSchools() {
        Map<SubjectSchool, Integer> enrolledSubjects = student.getEnrolledSubjects();
        System.out.println("Subjects enrolled via SubjectSchool:");
        for (Map.Entry<SubjectSchool, Integer> entry : enrolledSubjects.entrySet()) {
            System.out.println("- " + entry.getKey().getName() + ": Grade = " + entry.getValue());
        }
    }
}
