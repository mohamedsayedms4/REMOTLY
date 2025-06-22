package model;

public enum Role {
    STUDENT("طالب"),
    TEACHER("معلم"),
    ADMIN("مشرف");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
