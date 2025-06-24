import service.TeacherService;
import service.implementation.StudentServiceImpl;
import model.*;
import service.implementation.TeacherServiceImpl;

public class Main {
    public static void main(String[] args) {

        Remotly remotly = Remotly.getInstance();
        // ====== Create Additional Teachers ======
        Teacher[] teachers = {
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Ahmed", "Salem", "ahmed.s", "t123", "ahmed.s@email.com", Gender.MALE)
                                .setSchool(101).setSubjectName("Physics"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Hossam", "Ibrahim", "hossam.i", "t234", "hossam.i@email.com", Gender.MALE)
                                .setSchool(102).setSubjectName("Chemistry"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Nada", "Tarek", "nada.t", "t345", "nada.t@email.com", Gender.FEMALE)
                                .setSchool(103).setSubjectName("Biology"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Mahmoud", "Zaki", "mahmoud.z", "t456", "mahmoud.z@email.com", Gender.MALE)
                                .setSchool(104).setSubjectName("English"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Reem", "Fathy", "reem.f", "t567", "reem.f@email.com", Gender.FEMALE)
                                .setSchool(105).setSubjectName("French"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Khaled", "Adel", "khaled.a", "t678", "khaled.a@email.com", Gender.MALE)
                                .setSchool(106).setSubjectName("Computer Science"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Fatma", "Hassan", "fatma.h", "t789", "fatma.h@email.com", Gender.FEMALE)
                                .setSchool(107).setSubjectName("History"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Yasmine", "Fouad", "yasmine.f", "t890", "yasmine.f@email.com", Gender.FEMALE)
                                .setSchool(108).setSubjectName("Geography"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Omar", "Hatem", "omar.h", "t901", "omar.h@email.com", Gender.MALE)
                                .setSchool(109).setSubjectName("Philosophy"),
                        Role.TEACHER),
                (Teacher) UserEntityFactory.createUser(
                        new Teacher.TeacherBuilder("Laila", "Samir", "laila.s", "t012", "laila.s@email.com", Gender.FEMALE)
                                .setSchool(110).setSubjectName("Art"),
                        Role.TEACHER)
        };

// ====== Create 5 Courses ======
        Course physicsCourse = new Course(
                "Physics - Grade 7", 303, 12, 48,
                teachers[0].getFullName(), AcademicYear.GRADE_1_PREPARATORY
        );

        Course chemistryCourse = new Course(
                "Chemistry - Grade 7", 304, 10, 40,
                teachers[1].getFullName(), AcademicYear.GRADE_1_PREPARATORY
        );

        Course historyCourse = new Course(
                "History - Grade 7", 305, 8, 32,
                teachers[1].getFullName(), AcademicYear.GRADE_1_PREPARATORY
        );

        Course computerCourse = new Course(
                "Computer Science - Grade 7", 306, 10, 40,
                teachers[1].getFullName(), AcademicYear.GRADE_1_PREPARATORY
        );

        Course englishCourse = new Course(
                "English - Grade 7", 307, 9, 36,
                teachers[1].getFullName(), AcademicYear.GRADE_1_PREPARATORY
        );

// ====== Assign courses to their teachers ======
        TeacherService service0 = new TeacherServiceImpl(teachers[0]);
        TeacherService service1 = new TeacherServiceImpl(teachers[1]);
        TeacherService service2 = new TeacherServiceImpl(teachers[2]);
        TeacherService service3 = new TeacherServiceImpl(teachers[1]);
        TeacherService service4 = new TeacherServiceImpl(teachers[1]);

        service0.addCourse(physicsCourse);
        service1.addCourse(chemistryCourse);
        service2.addCourse(historyCourse);
        service3.addCourse(computerCourse);
        service4.addCourse(englishCourse);


// Add them to Remotly
        for (Teacher t : teachers) {
            remotly.addTeacher(t);
        }

// ====== Create Additional Students ======
        Student[] students = {
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Karim", "Yasser", "karim.y", "s111", "karim.y@email.com", Gender.MALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Aya", "Nabil", "aya.n", "s222", "aya.n@email.com", Gender.FEMALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Mostafa", "Ahmed", "mostafa.a", "s333", "mostafa.a@email.com", Gender.MALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Nour", "Ashraf", "nour.a", "s444", "nour.a@email.com", Gender.FEMALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Hana", "Fathy", "hana.f", "s555", "hana.f@email.com", Gender.FEMALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY),
                (Student) UserEntityFactory.createUser(
                        new Student.StudentBuilder("Adham", "Kamel", "adham.k", "s666", "adham.k@email.com", Gender.MALE),
                        Role.STUDENT, AcademicYear.GRADE_1_PREPARATORY)
        };

// Add them to Remotly
        for (Student s : students) {
            remotly.addStudent(s);
        }

        remotly.printStudents();
        remotly.printTeachers();

        System.out.println(remotly.getTeachers().get(1).getCourses().get(0).getLessons());
    }
}
