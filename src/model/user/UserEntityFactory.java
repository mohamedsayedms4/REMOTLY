package model.user;

import model.constant.AcademicYear;
import model.constant.Role;

/**
 * Factory class to create {@link UserBaseEntity} instances such as {@link Student} or {@link Teacher}
 * based on the provided {@link Role}, builder, and optionally an {@link AcademicYear}.
 *
 * This class uses the builder pattern and supports polymorphic creation depending on role type.
 *
 *  Create a student with an academic year
 *  Create a teacher without needing academic year
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 * Version: 2.0
 */
public class UserEntityFactory {

    /**
     * Creates a {@link UserBaseEntity} (e.g., Student or Teacher) based on role and builder,
     * and optionally assigns an academic year (for students).
     *
     * @param builder The specific builder object (StudentBuilder or TeacherBuilder)
     * @param role The role type to determine the type of user to create
     * @param academicYear Optional academic year (only used for students)
     * @return A concrete instance of {@link UserBaseEntity} (Student, Teacher, etc.)
     * @throws IllegalArgumentException if builder or role is null, or types are mismatched
     */
    public static UserBaseEntity createUser(UserBaseEntity.BaseBuilder<?> builder, Role role, AcademicYear academicYear) {
        if (role == null || builder == null) {
            throw new IllegalArgumentException("Role and builder must not be null.");
        }

        return switch (role) {
            case STUDENT -> {
                if (builder instanceof Student.StudentBuilder studentBuilder) {
                    yield StudentFactory.createStudent(
                            studentBuilder.setRole(Role.STUDENT),
                            academicYear
                    );
                }
                throw new IllegalArgumentException("Builder must be StudentBuilder for STUDENT role.");
            }

            case TEACHER -> {
                if (builder instanceof Teacher.TeacherBuilder teacherBuilder) {
                    yield teacherBuilder.setRole(Role.TEACHER).build();
                }
                throw new IllegalArgumentException("Builder must be TeacherBuilder for TEACHER role.");
            }

            default -> throw new IllegalArgumentException("Unsupported role: " + role);
        };
    }

    /**
     * Overloaded version of {@link #createUser(UserBaseEntity.BaseBuilder, Role, AcademicYear)}
     * that does not require an academic year.
     *
     * Used for roles like TEACHER, ADMIN, etc.
     *
     * @param builder The builder instance
     * @param role The role to create
     * @return A {@link UserBaseEntity} instance
     */
    public static UserBaseEntity createUser(UserBaseEntity.BaseBuilder<?> builder, Role role) {
        return createUser(builder, role, null);
    }


}
