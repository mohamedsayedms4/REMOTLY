package model;
import java.time.LocalDate;

public class Student extends UserBaseEntity {

    private int score;

    private Student(StudentBuilder builder) {
        super(builder);
        this.score = builder.score;
    }

    public static class StudentBuilder extends BaseBuilder<StudentBuilder> {
        private int score;

        public StudentBuilder setScore(int score) {
            this.score = score;
            return this;
        }

        @Override
        protected StudentBuilder self() {
            return this;
        }

        public Student build() {
            return new Student(this);
        }

        // ← هذه داخل StudentBuilder
        public static StudentBuilder signUpBuilder(String firstName, String lastName, String userName,
                                                   String email, String password, String fullNumber,
                                                   String gender, LocalDate dateOfBirth) {
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
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", id=" + id +
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
                ", role=" + role +
                '}';
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
