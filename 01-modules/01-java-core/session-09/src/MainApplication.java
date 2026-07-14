/*
    Session 09 - OOP (continue) - Abstract class and Polymorphism

        1. Abstract class
            - Là một bộ khung/ý tưởng/mô hình/bản hợp đồng để các class khác kế thừa (extends)
            - Có mọi thứ của một class bình thường nhưng có thêm các properties và methods abstract
            - Không thể dùng để tạo đối tượng (new)
            - Các class con kế thừa phải ghi đè (overried)/triển khai (implementation) các toàn bộ abstract method
            - Abstract class có thể kế thừa từ abstract class khác

         2. Polymorphism: tính đa hình
            - Các class con kế thừa các properties/methods từ class cha
            - Ngoài ra, có thể có những preoperties/methods riêng -> Tính đa hình

        3. Interface
            - Định nghĩa một class có thể làm được gì
            - Một class chỉ có thể kế thừa từ 1 class khác (extends) nhưng có thể có nhiều interface (implement)
                classA extends classB implement classC1, classC2
            - Là một bản hợp dồng/quy định các chức năng/methods bắt buộc class đó phải triển khai (implement) tất cả
            - Không chứa/lưu state (trạng thái của field): chỉ chứa các properties là static

        4. Khác nhau giữa abstract class và interface
            - Giống nhau:
                - Abstract class và Interface đểu là một bộ khung/bản hợp đồng để các class khác kế thừa
                - Khi các class khác kế thừa, class con phải triển khai/thực thi/code cho phần thân của các methods
            - Khác nhau:
                                | Abstract class                    |   Interface                                   |
                Mang ý nghĩa    | "IS-A"                            | "HAS-A" hay "LIKE-A"                          |
                Đa kế thừa      | 1 class chỉ kế thừa từ 1 class    | 1 class có thể implement từ nhiều interface   |
                Property        | Mọi loại biến                     | Chỉ các biến mặc định là static final         |
                Methods         | Chứa cả 2 loại method             | Chỉ chứa abstract method (Java < 8)           |
                Constructor     | Có                                | Không thể khởi tạo trực tiếp                  |
                Access modifier | Public, protected, private, default | Public, protected, private, default         |

        5. Overloading: (chồng hàm): các hàm/method có cùng tên nhưng khác nhau về data types/số lượng tham số.

        6. `final` keyword:
            - Với method: chặn override (ghi đè)
            - Với class: chặn kế thừa
            - Với property: chặn việc gán lại
*/

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuanLyXe quanLy = new QuanLyXe();

        int chon = 0;

        do {
            System.out.println("");
            System.out.println("""
                    \n==== Quản Lý Chuyến Xe ====
                    1. Thêm chuyến xe nội thành
                    2. Thêm chuyến xe ngoại thành
                    3. Xuất danh sách xe
                    4. Tổng doanh thu
                    5. Doanh thu xe nội thành
                    6. Doanh thu xe ngoại thành
                    0. Thoát
                    """);

            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: {
                    quanLy.themChuyenXe(sc, 1);
                    break;
                }
                case 2: {
                    quanLy.themChuyenXe(sc, 2);
                    break;
                }
                case 3: {
                    quanLy.xuatDanhSachChuyenXe();
                    break;
                }
                case 4: {
                    quanLy.tongDoanhThu();
                    break;
                }
                case 5: {
                    quanLy.doanhThuTheoLoaiXe(1);
                    break;
                }
                case 6: {
                    quanLy.doanhThuTheoLoaiXe(2);
                    break;
                }
                case 0: {
                    System.out.println("Tạm biệt");
                    break;
                }
                default:
                    System.out.println("Không hợp lệ");
            }

        } while (chon != 0);
    }
}
