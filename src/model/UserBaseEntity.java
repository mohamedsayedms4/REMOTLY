package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Abstract base class representing common attributes of any user in the system.
 * Includes shared fields like name, username, password, contact info, and login metadata.
 *
 * Author: Mohamed Sayed
 * Date: 22-6-2025
 * Version: 1.0
 */
public abstract class UserBaseEntity {

    // ========== Fields ==========

    /** Unique identifier for the user */
    protected int id;

    /** First name of the user */
    protected String firstName;

    /** Last name of the user */
    protected String lastName;

    /** Full name (auto-generated from first and last names) */
    protected String fullName;

    /** Age of the user */
    protected int age;

    /** Username for authentication */
    protected String userName;

    /** Password for authentication */
    protected String password;

    /** Full phone number (including country code if needed) */
    protected String fullNumber;

    /** City of residence */
    protected String city;

    /** Full address */
    protected String address;

    /** URL or path to the profile image */
    protected String imageUrl;

    /** Flag indicating whether the user account is active */
    protected boolean isActive;

    /** Date of birth */
    protected LocalDate dateOfBirth;

    /** Timestamp of first login */
    protected LocalDateTime firstLogin;

    /** Timestamp of last login */
    protected LocalDateTime lastLogin;

    /** Email address */
    protected String email;

    /** Gender (e.g., "Male", "Female") */
    protected Gender gender;

    /** User role (e.g., STUDENT, TEACHER) */
    protected Role role;

    // ========== Constructor ==========

    /**
     * Initializes the UserBaseEntity using the values provided by the builder.
     *
     * @param builder The builder instance carrying user values
     */
    protected UserBaseEntity(BaseBuilder<?> builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.fullName = ((builder.firstName != null ? builder.firstName : "") +
                (builder.lastName != null ? " " + builder.lastName : "")).trim();
        this.age = builder.age;
        this.userName = builder.userName;
        this.password = builder.password;
        this.fullNumber = builder.fullNumber;
        this.city = builder.city;
        this.address = builder.address;
        this.imageUrl = builder.imageUrl;
        this.isActive = builder.isActive;
        this.dateOfBirth = builder.dateOfBirth;
        this.firstLogin = builder.firstLogin;
        this.lastLogin = builder.lastLogin;
        this.email = builder.email;
        this.gender = builder.gender;
        this.role = builder.role;
    }

    // ========== Builder Class ==========

    /**
     * Abstract generic builder class for constructing UserBaseEntity or its subclasses.
     *
     * @param <T> Type of builder subclass
     */
    public static abstract class BaseBuilder<T extends BaseBuilder<T>> {

        protected int id;
        protected String firstName;
        protected String lastName;
        protected int age;
        protected String userName;
        protected String password;
        protected String fullNumber;
        protected String city;
        protected String address;
        protected String imageUrl;
        protected boolean isActive;
        protected LocalDate dateOfBirth;
        protected LocalDateTime firstLogin;
        protected LocalDateTime lastLogin;
        protected String email;
        protected Gender gender;
        protected Role role;

        /**
         * Abstract method to return the builder itself (for chaining).
         *
         * @return builder instance
         */
        protected abstract T self();

        /**
         * Constructor for full sign-up use case.
         */
        public BaseBuilder(String firstName, String lastName, String userName, String password, String email, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.userName = userName;
            this.password = password;
            this.email = email;
            this.gender = gender;
        }

        /**
         * Constructor for login use case only.
         */
        public BaseBuilder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        /** Default constructor */
        public BaseBuilder() {}

        // ========== Builder Setters ==========

        public T setId(int id) { this.id = id; return self(); }
        public T setFirstName(String firstName) { this.firstName = firstName; return self(); }
        public T setLastName(String lastName) { this.lastName = lastName; return self(); }
        public T setAge(int age) { this.age = age; return self(); }
        public T setUserName(String userName) { this.userName = userName; return self(); }
        public T setPassword(String password) { this.password = password; return self(); }
        public T setFullNumber(String fullNumber) { this.fullNumber = fullNumber; return self(); }
        public T setCity(String city) { this.city = city; return self(); }
        public T setAddress(String address) { this.address = address; return self(); }
        public T setImageUrl(String imageUrl) { this.imageUrl = imageUrl; return self(); }
        public T setActive(boolean isActive) { this.isActive = isActive; return self(); }
        public T setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; return self(); }
        public T setFirstLogin(LocalDateTime firstLogin) { this.firstLogin = firstLogin; return self(); }
        public T setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; return self(); }
        public T setEmail(String email) { this.email = email; return self(); }
        public T setGender(Gender gender) { this.gender = gender; return self(); }
        public T setRole(Role role) { this.role = role; return self(); }
    }

    // ========== Getters ==========

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getFullNumber() { return fullNumber; }
    public String getCity() { return city; }
    public String getAddress() { return address; }
    public String getImageUrl() { return imageUrl; }
    public boolean isActive() { return isActive; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public LocalDateTime getFirstLogin() { return firstLogin; }
    public LocalDateTime getLastLogin() { return lastLogin; }
    public String getEmail() { return email; }
    public String getGender() { return gender.toString(); }
    public Role getRole() { return role; }

    // ========== Setters ==========

    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setAge(int age) { this.age = age; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setFullNumber(String fullNumber) { this.fullNumber = fullNumber; }
    public void setCity(String city) { this.city = city; }
    public void setAddress(String address) { this.address = address; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setActive(boolean active) { this.isActive = active; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setFirstLogin(LocalDateTime firstLogin) { this.firstLogin = firstLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
    public void setEmail(String email) { this.email = email; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setRole(Role role) { this.role = role; }

    // ========== toString ==========

    /**
     * Returns a string representation of the user entity with all fields.
     *
     * @return string containing user info
     */
    @Override
    public String toString() {
        return "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullNumber='" + fullNumber + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isActive=" + isActive +
                ", dateOfBirth=" + dateOfBirth +
                ", firstLogin=" + firstLogin +
                ", lastLogin=" + lastLogin +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", role=" + role;
    }
}
