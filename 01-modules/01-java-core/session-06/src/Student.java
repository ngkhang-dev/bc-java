import java.util.Calendar;

public class Student {
    //    Thuộc tính/Attributes/Properties
    String name;
    int yob;
    String address;
    String phone;
    String email;
    boolean sex;

    //    Constructor: Không tham số (Default)
    public Student() {
    }

    //    Constructor có tham số
    public Student(String name, int yob, String address, String phone, String email, boolean sex) {
        this.name = name;
        this.yob = yob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    //    Phương thức/Hành vi/Methods
    public void printInfo() {
        System.out.printf("""
                Name: %s
                Year of birth: %d
                Address: %s
                Phone: %s
                Email: %s
                Sex: %s
                """, name, yob, address, phone, email, sex ? "Male" : "Female");
    }

    public int getOld() {
        return Calendar.YEAR - yob;
    }
}
