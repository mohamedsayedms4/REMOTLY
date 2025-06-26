package model.subject;

import model.constant.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a category of courses linked directly to a school subject.
 * Category name is derived automatically from the Subject enum.
 */
public class Category {

    private final Subject subject;  // New: reference to the subject itself
    private final String description;
    private final List<Course> courses;

    public Category(Subject subject, String description) {
        this.subject = subject;
        this.description = description;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return subject.getEnglishName();  // or subject.getArabicName() if needed
    }

    public Subject getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public boolean addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            return true;
        }
        return false;
    }

    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    @Override
    public String toString() {
        return "Category: " + getName() + " (" + subject.getArabicName() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return subject == category.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
