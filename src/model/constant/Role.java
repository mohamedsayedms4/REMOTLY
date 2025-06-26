package model.constant;

/**
 * Enum representing user roles within the system.
 * Each role has an Arabic display name for localization purposes.
 *
 * Roles:
 * - STUDENT: طالب
 * - TEACHER: معلم
 * - ASSISTANT: مساعد معلم
 * - ADMIN: مشرف
 * Author: Mohamed Sayed
 * Date: 23-6-2025
 */
public enum Role {

    STUDENT("طالب"),
    TEACHER("معلم"),
    ASSISTANT("مساعد معلم"),
    ADMIN("مشرف");

    // Arabic display name for the role
    private final String displayName;

    /**
     * Constructor for Role enum.
     *
     * @param displayName Arabic name for the role
     */
    Role(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the Arabic display name of the role.
     *
     * @return the Arabic name (e.g., "معلم")
     */
    public String getDisplayName() {
        return displayName;
    }
}
