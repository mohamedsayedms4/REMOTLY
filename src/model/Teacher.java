package model;

public class Teacher extends UserBaseEntity{
    private int school ;
    private String subjectName ;

    private Teacher(TeacherBuilder builder) {
        super(builder);
        this.school = builder.school;
        this.subjectName = builder.subjectName;
    }

    public static class TeacherBuilder extends BaseBuilder<TeacherBuilder>{
        private int school ;
        private String subjectName ;


        public TeacherBuilder(String firstName, String lastName, String userName, String password, String email, String gender) {
            super(firstName, lastName, userName, password, email, gender);
        }

        public TeacherBuilder(String userName, String password) {
            super(userName,password);
        }

        public TeacherBuilder setSchool(int school) {
            this.school = school;
            return this;
        }

        public TeacherBuilder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        @Override
        protected TeacherBuilder self() {
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "school=" + school +
                ", subjectName='" + subjectName + '\'' +
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
