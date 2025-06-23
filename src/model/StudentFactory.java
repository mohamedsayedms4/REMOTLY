package model;

/**
 * Factory class responsible for creating {@link Student} objects with academic year handling.
 * It provides utility methods to build Student instances using a builder pattern.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 * Version: 1.0
 */
public class StudentFactory {

    /**
     * Creates a {@link Student} from the given builder.
     * If the academic year is not explicitly set in the builder,
     * it defaults to {@link AcademicYear#GRADE_1_PRIMARY}.
     *
     * @param builder the student builder instance
     * @return a fully built {@link Student} object
     */
    public static Student createStudent(Student.StudentBuilder builder) {
        // Default year if not set
        if (builder.getAcademicYear() == null) {
            builder.setAcademicYear(AcademicYear.GRADE_1_PRIMARY);
        }
        return builder.build();
    }

    /**
     * Overloaded method: creates a {@link Student} with the specified {@link AcademicYear}.
     *
     * @param builder      the student builder instance
     * @param academicYear the academic year to assign
     * @return a fully built {@link Student} object
     */
    public static Student createStudent(Student.StudentBuilder builder, AcademicYear academicYear) {
        return builder.setAcademicYear(academicYear).build();
    }
}
