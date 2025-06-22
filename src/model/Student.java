package model;

import java.time.LocalDate;

public  class Student extends UserBaseEntity{

    private int score ;

    private Student(StudentBuilder builder) {
        super(builder);
        this.score = builder.score ;
    }


    public static class StudentBuilder extends BaseBuilder<StudentBuilder>{
       private int score ;

       public StudentBuilder(String firstName, String lastName, String userName, String password, String email, String gender) {
           super(firstName, lastName, userName, password, email, gender);
       }

       public StudentBuilder(String userName, String password) {
           super(userName,password);
       }

       public int getScore() {
           return score;
       }

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
   }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", id=" + id +
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
                ", role=" + role +
                '}';
    }
}


