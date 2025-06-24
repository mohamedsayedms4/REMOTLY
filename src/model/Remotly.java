package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class representing the core application container for Remotly platform.
 * Holds global lists of students and teachers.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public class Remotly {

    private final String name = "Remotly";

    private final List<Student> students;
    private final List<Teacher> teachers;

    // Singleton instance
    private static Remotly instance;

    // Private constructor to prevent external instantiation
    private Remotly() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    /**
     * Returns the single instance of Remotly (Singleton pattern).
     * Lazily initializes the instance if it hasn't been created yet.
     *
     * @return the singleton instance of Remotly
     */
    public static Remotly getInstance() {
        if (instance == null) {
            instance = new Remotly();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printStudents() {
        for (Student s : students) {
            System.out.println("Student - "+s.getFirstName() + " " + s.getLastName());
        }
    }

    public void printTeachers() {
        for (Teacher s : teachers) {
            System.out.println("Teacher - "+s.getFirstName() + " " + s.getLastName());
        }
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a student to the global student list.
     *
     * @param student the student to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Adds a teacher to the global teacher list.
     *
     * @param teacher the teacher to add
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
