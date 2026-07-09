/*
    Session 06 - OOP basic

        1. Khả năng/Quyền hạn truy cập (Access modifiers): Public, Private, Protected, Default
            Note: Mặc định class là package-private: phạm vi chỉ trong cùng pacakge

        2. Constructor
            - Khởi tạo đối tượng khi dùng từ khóa "new"
            - Có 2 dạng: có tham số và không tham số (default)

        3. Khác nhau giữa "Object" and "Instance"
            - Object và Instance đều được tạo ra/biểu diễn từ class (OOP)
            - Instance dùng để mô tả cụ thể được tạo ra từ class nào (instance of ...)

        4. "this" keyword
            - Là một biến con trỏ/biến object/ biến tham chiếu đến đối tượng hiện tại của lớp đó
 */

public class MainApplication {
    public static void main(String[] args) {

        Student stu1 = new Student(); // Constructor rỗng
        stu1.name = "Nguyen Van A";
        stu1.yob = 2005;
        stu1.address = "Sa Dec";
        stu1.phone = "0987654321";
        stu1.sex = true;

        // Constructor có tham số
        Student stu2 = new Student("Khang", 2000, "SG", "0123456789", "khang@gmail.com", true);
        Student stu3 = new Student("Khang", 2000, "SG", "0123456789", "khang@gmail.com", true);

        // Gọi methods
        stu1.printInfo();
        int old = stu1.getOld();
        System.out.println("Student's age: " + old);

        Automobile car = new Automobile();
        car.brand = "Toyota";
        car.model = "Corolla";
        car.color = "Red";

        // Cả stu1, stu2, stu3, car đều gọi là object.
        //  stu1, stu2, stu3 là instance của Student
        //  car là instance của Automobile
    }
}
