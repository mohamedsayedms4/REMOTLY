import model.Student;
import model.Teacher;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // تسجيل جديد

        Student s = new Student.StudentBuilder("miiiss","mkmkm")
                .setScore(15)
                .build();

        Teacher t = new Teacher.TeacherBuilder("Ahmed","12300")
                .setSubjectName("Math")
                .build();

        System.out.println(s);
        System.out.println(t);
    }
}
