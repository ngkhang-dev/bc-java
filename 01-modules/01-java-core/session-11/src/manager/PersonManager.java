package manager;

import model.Lecture;
import model.Mentor;
import model.Person;
import model.Student;
import util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

    private List<Person> listPerson;

    public PersonManager() {
        this.listPerson = new ArrayList<Person>();

        listPerson.add(new Lecture("GV001","Giang vien 01",20,"Nu",20000));
        listPerson.add(new Lecture("GV002","Giang vien 02",20,"Nu",20000));
        listPerson.add(new Mentor("MT001","Mentor 01",20,"Nu",20000));
        listPerson.add(new Student("ST001","Stu 01",20,"Nu",10,10,10));
        listPerson.add(new Student("ST002","Stu 02",20,"Nu",10,10,10));

        listPerson.add(new Student("ST003","Stu 03",20,"Nu",10,10,10));
        listPerson.add(new Student("ST004","Stu 04",20,"Nu",10,10,10));
    }

    public boolean addPerson(Person person) {
        if (person == null || person.getId() == null) {
            return false;
        }

        Person existingPerson = findPerson(person.getId());

        if (existingPerson != null) {
            System.out.println("ID đã tồn tại");
            return false;
        }

        listPerson.add(person);

        return true;
    }

    public boolean addStudent() {
        Student student = new Student();
        student.setId(InputHelper.inputText("Nhập ID: "));
        student.setName(InputHelper.inputText("Nhập tên: "));
        student.setAge(InputHelper.inputInt("Nhập tuổi: ", 18, 80));
        student.setGender(InputHelper.inputGender());
        student.setNodeScore(InputHelper.inputDouble("Nhập điểm Node.js: ", 0, 10));
        student.setJavaScore(InputHelper.inputDouble("Nhập điểm Java: ", 0, 10));
        student.setGoScore(InputHelper.inputDouble("Nhập điểm Go: ", 0, 10));

        boolean isSuccess = addPerson(student);

        String notification = "Thêm sinh viên " + (isSuccess ? "thành công" : "thất bại");
        System.out.println(notification);

        return isSuccess;
    }

    public boolean addMentor() {
        Mentor mentor = new Mentor();
        mentor.setId(InputHelper.inputText("Nhập ID: "));
        mentor.setName(InputHelper.inputText("Nhập tên: "));
        mentor.setAge(InputHelper.inputInt("Nhập tuổi: ", 18, 80));
        mentor.setGender(InputHelper.inputGender());
        mentor.setSalary(InputHelper.inputDouble("Nhập số lương: ", 0, 10));

        boolean isSuccess = addPerson(mentor);

        String notification = "Thêm trợ giảng " + (isSuccess ? "thành công" : "thất bại");
        System.out.println(notification);

        return isSuccess;
    }

    public boolean addLecturer() {
        Lecture lecture = new Lecture();
        lecture.setId(InputHelper.inputText("Nhập ID: "));
        lecture.setName(InputHelper.inputText("Nhập tên: "));
        lecture.setAge(InputHelper.inputInt("Nhập tuổi: ", 18, 80));
        lecture.setGender(InputHelper.inputGender());
        lecture.setSalary(InputHelper.inputDouble("Nhập số lương: ", 0, 10));

        boolean isSuccess = addPerson(lecture);

        String notification = "Thêm giảng viên " + (isSuccess ? "thành công" : "thất bại");
        System.out.println(notification);

        return isSuccess;
    }

    public Person findPerson(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Person person : listPerson) {
            if (person.getId().equalsIgnoreCase(id)) {
                return person;
            }
        }

        return null;
    }

    public Person findPerson() {
        String id = InputHelper.inputText("Nhập ID cần tìm: ");

        Person person = findPerson(id);

        if (person == null) {
            System.out.println("Không tìm thấy");
            return null;
        }

        System.out.println("Loại " + person.getClass().getSimpleName());
        person.display();
        return person;
    }

    public void displayStudent() {
        displayByType(Student.class);
    }

    public void displayMentor() {
        displayByType(Mentor.class);
    }

    public void displayLecturer() {
        displayByType(Lecture.class);
    }

    public boolean assignStudentToLecture() {
        String lectureId = InputHelper.inputText("Nhập ID giảng viên: ");
        String studentId = InputHelper.inputText("Nhập ID sinh viên: ");

        Student findStudent = (Student) findPerson(studentId);
        Lecture findLecture = (Lecture) findPerson(lectureId);

        if (findLecture == null) {
            System.out.println("Không tìm thấy giảng viên");
            return false;
        }
        if (findStudent == null) {
            System.out.println("Không tìm thấy sinh viên");
            return false;
        }

        findLecture.addStudent(findStudent);
        System.out.println("Thêm sinh viên cho giảng viên thành công");

        return true;
    }

    private void displayByType(Class<? extends Person> type) {
        boolean isFound = false;

        for (Person person : listPerson) {
            if (type.isInstance(person)) {
                person.display();
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("Danh sách rỗng");
        }
    }

}
