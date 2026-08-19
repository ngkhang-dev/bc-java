# BC Java - Assignment 06 - MySQL

<!-- TOC -->

* [BC Java - Assignment 06 - MySQL](#bc-java---assignment-06---mysql)
    * [Requirements](#requirements)
    * [Prerequisites](#prerequisites)
        * [Project Structure](#project-structure)
        * [Environment](#environment)
    * [Author](#author)

<!-- TOC -->

## Requirements

- Thực thi [initial.sql](./initial.sql) để tạo schema và data.
- Viết query cho các yêu cầu sau:
    1. Hiển thị tất cả thông tin của bảng "employees"
    2. Hiển thị tên và lương của tất cả nhân viên
    3. Hiển thị thông tin của những nhân viên có lương lớn hơn 50000.
    4. Hiển thị số lượng nhân viên trong mỗi phòng ban
    5. Sắp xếp danh sách nhân viên theo tên từ A-Z
    6. Hiển thị tên, lương và phòng ban của những nhân viên có lương từ 40000 đến 60000, sắp xếp
       theo lương giảm dần
    7. Tính tổng lương của tất cả nhân viên
    8. Hiển thị tên của nhân viên và tên phòng ban của họ
    9. Tìm những phòng ban có ít nhất 3 nhân viên
    10. Hiển thị tên nhân viên và lương của những nhân viên ở phòng ban "IT" hoặc "Sales"
    11. Hiển thị tên và ngày bắt đầu làm việc của những nhân viên được tuyển dụng sau năm 2020
    12. Tính trung bình lương của nhân viên
    13. Hiển thị danh sách các phòng ban và số lượng nhân viên trong mỗi phòng ban, kể cả những
        phòng ban không có nhân viên
    14. Hiển thị 5 nhân viên có lương cao nhất
    15. Tìm những nhân viên có tên bắt đầu bằng chữ "A"
    16. Hiển thị tên nhân viên và tên quyền truy cập của những người có quyền là "Admin"
    17. Tính tổng lương cho mỗi phòng ban và sắp xếp theo tổng lương giảm dần
    18. Hiển thị danh sách nhân viên và ngày bắt đầu làm việc, sắp xếp theo ngày bắt đầu làm việc
        tăng dần
    19. Tìm những nhân viên có lương cao nhất trong từng phòng ban
    20. Hiển thị danh sách nhân viên và tên quyền truy cập của họ, bao gồm những nhân viên không có
        quyền truy cập

## Prerequisites

### Project Structure

```text
./
│   initial.sql
│   README.md
└───solution.sql
```

### Environment

- IDE: DataGrip

## Author

Khang Nguyen
