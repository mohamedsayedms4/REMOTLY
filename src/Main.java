import model.Student;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate dateOfBirth = LocalDate.of(2000, 5, 10);  // 10 مايو 2000

        Student student = Student.StudentBuilder.signUpBuilder(
                "Ahmed", "Sayed", "ahmedsayed123",
                "ahmed@gmail.com", "1223456", "01007809006",
                "male", dateOfBirth
        ).build();

        Student student1 = Student.StudentBuilder.signUpBuilder(
                "Ahmed", "Sayed", "ahmedsayed123",
                "ahmed@gmail.com", "1223456", "01007809006",
                "male", dateOfBirth

        ).setAddress("Some address").build();

        System.out.println(student);
    }
}
