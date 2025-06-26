package model.user;

/**
 * Interface representing a generic factory for creating {@link UserBaseEntity} objects.
 *
 * This interface is intended to be implemented by specific user factories,
 * such as StudentFactory or TeacherFactory, to encapsulate the logic of object creation.
 *
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 * Version: 2.0
 */
public interface UserFactory {

    /**
     * Creates and returns a {@link UserBaseEntity} instance using the given builder.
     *
     * @param builder The builder object containing necessary user data
     * @return A new instance of a subclass of {@link UserBaseEntity}
     */
    UserBaseEntity createUser(UserBaseEntity.BaseBuilder<?> builder);
}
