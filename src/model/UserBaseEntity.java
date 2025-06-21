package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class UserBaseEntity {

    // ==== Common Protected Fields ====
    protected int id;
    protected String fullName;
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
    protected String gender;
    protected Role role;

    // ==== Constructor used by subclasses ====
    protected UserBaseEntity(BaseBuilder<?> builder) {
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
        this.email = builder.email;
        this.gender = builder.gender;
        this.role = builder.role;
    }

    // ==== Generic Reusable Builder ====
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
        protected String gender;
        protected Role role;

        protected abstract T self();

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
        public T setGender(String gender) { this.gender = gender; return self(); }
        public T setRole(Role role) { this.role = role; return self(); }
    }

    // ==== Getters only ====
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
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public Role getRole() { return role; }



}
