package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Student {

    // ==== Immutable Student Fields ====
    private final int id;
    private final String fullName;
    private final int age;
    private final String userName;
    private final String password;
    private final String fullNumber;
    private final String city;
    private final String address;
    private final String imageUrl;
    private final boolean isActive;
    private final LocalDate dateOfBirth;
    private final LocalDateTime firstLogin;
    private final LocalDateTime lastLogin;
    private final int score;
    private final String email;
    private final String gender;
    private final Role role;


    // ==== Private Constructor used by Builder ====
    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.firstName + " " + builder.lastName;
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
        this.score = builder.score;
        this.email = builder.email;
        this.gender = builder.gender;
        this.role = builder.role;
    }

    // ==== Builder Class for Student ====
    public static class StudentBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private String userName;
        private String password;
        private String fullNumber;
        private String city;
        private String address;
        private String imageUrl;
        private boolean isActive;
        private LocalDate dateOfBirth;
        private LocalDateTime firstLogin;
        private LocalDateTime lastLogin;
        private int score;
        private String email;
        private String gender;
        private Role role;

        private StudentBuilder() {}

        // Factory method for Sign-Up (required fields only)
        public static StudentBuilder signUpBuilder(String firstName, String lastName, String userName, String email,
                                                   String password, String fullNumber, String gender, LocalDate dateOfBirth) {
            return new StudentBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserName(userName)
                    .setEmail(email)
                    .setPassword(password)
                    .setFullNumber(fullNumber)
                    .setGender(gender)
                    .setDateOfBirth(dateOfBirth);
        }

        // Factory method for Sign-In
        public static StudentBuilder signInBuilder(String email, String password) {
            return new StudentBuilder()
                    .setEmail(email)
                    .setPassword(password);
        }

        // ==== Fluent Setters for Optional Fields ====
        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder setFullNumber(String fullNumber) {
            this.fullNumber = fullNumber;
            return this;
        }

        public StudentBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public StudentBuilder setActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public StudentBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public StudentBuilder setFirstLogin(LocalDateTime firstLogin) {
            this.firstLogin = firstLogin;
            return this;
        }

        public StudentBuilder setLastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public StudentBuilder setScore(int score) {
            this.score = score;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setRole(Role role) {
            this.role = role;
            return this;
        }

        // ==== Final Build Method ====
        public Student build() {
            // Validate mandatory fields before building
            if (email == null || password == null || firstName == null || lastName == null)
                throw new IllegalStateException("Missing required fields.");
            return new Student(this);
        }
    }

    // ==== Copy Method (Clone-like) ====
    public Student copy() {
        return new StudentBuilder()
                .setId(this.id)
                .setFirstName(fullName.split(" ")[0])
                .setLastName(fullName.split(" ").length > 1 ? fullName.split(" ")[1] : "")
                .setAge(age)
                .setUserName(userName)
                .setPassword(password)
                .setFullNumber(fullNumber)
                .setCity(city)
                .setAddress(address)
                .setImageUrl(imageUrl)
                .setActive(isActive)
                .setDateOfBirth(dateOfBirth)
                .setFirstLogin(firstLogin)
                .setLastLogin(lastLogin)
                .setScore(score)
                .setEmail(email)
                .setGender(gender)
                .setRole(role)
                .build();
    }

    // ==== Equals & HashCode (based on ID, email, username) ====
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(email, student.email) &&
                Objects.equals(userName, student.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, userName);
    }

    // ==== toString Override ====
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
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
                ", score=" + score +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", role=" + role +
                '}';
    }

    // ==== Getters Only (Immutable Object) ====
    public int getId() { return id; }
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
    public int getScore() { return score; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public Role getRole() { return role; }
}
