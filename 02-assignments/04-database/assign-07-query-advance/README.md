# BC Java - Assignment 07 - Query Advance

![MySQL](https://img.shields.io/badge/MySQL-8.4-005C84?logo=mysql&logoColor=white)
![Status](https://img.shields.io/badge/status-completed-brightgreen)

<!-- TOC -->

* [BC Java - Assignment 07 - Query Advance](#bc-java---assignment-07---query-advance)
    * [Requirements](#requirements)
    * [Prerequisites](#prerequisites)
        * [Project Structure](#project-structure)
        * [Environment](#environment)
    * [Solution](#solution)
    * [Author](#author)

<!-- TOC -->

## Requirements

- **Trigger** (6 bài)
    1. Trigger kiểm tra tuổi sinh viên ≥ 18
       Tạo trigger BEFORE INSERT trên bảng `SinhVien`, nếu `NgaySinh` khiến tuổi < 18 → từ chối
       thêm.
    2. Trigger cập nhật số lượng tồn kho
       Khi chèn `ChiTietHoaDon`, giảm số lượng sản phẩm trong bảng `SanPham` tương ứng.
    3. Trigger log lại lịch sử cập nhật lương
       Khi bảng `NhanVien` thay đổi cột `Luong`, ghi vào bảng `LichSuLuong`:
        - MaNV
        - LuongCu
        - LuongMoi
        - NgayCapNhat
    4. Không cho xóa lớp nếu còn sinh viên
       Tạo trigger BEFORE DELETE trên `Lop`. Nếu Lop còn `SinhVien` → hủy DELETE.
    5. Trigger tự động tạo username khi thêm nhân viên
       Tự động sinh `Username` từ họ tên (ví dụ: "Nguyen Van A" → "nguyenvana") và ghi vào bảng
       `Accounts`.
    6. Trigger ghi log đăng nhập
       Khi bảng `LoginHistory` thêm bản ghi → tự động thêm thời gian vào `LoginTime`.

- **Index** (4 bài)
    1. Tạo index cho tìm kiếm sinh viên theo tên
       Tạo index trên `SinhVien(HoTen)` để tối ưu `SELECT * WHERE HoTen LIKE 'A%'`.
    2. Tạo composite index cho bảng `ChiTietHoaDon`
       Index trên `(MaHD, MaSP)` để tăng tốc truy vấn JOIN.
    3. Tạo unique index để tránh trùng email
       Tạo `UNIQUE INDEX` trên `Users(Email)`.
    4. So sánh hiệu suất trước và sau index
       Viết 2 truy vấn SELECT lớn để đo tốc độ:
        - Không có index
        - Có index trên cột NgayTao
          (Dùng EXPLAIN ANALYZE)

- **View** (4 bài)
    1. Tạo view tổng hợp điểm sinh viên
       View gồm:
        - MaSV
        - HoTen
        - TenMH
        - DiemSo
        - DiemChu (CASE WHEN DiemSo ≥ 8 THEN 'A' …)
    2. Tạo view top 10 sản phẩm bán chạy
       Dựa trên bảng `HoaDon` + `ChiTietHoaDon`:
        - MaSP
        - TenSP
        - TongSoLuongBan
          → LIMIT 10.
    3. View danh sách sinh viên theo khoa
       JOIN SinhVien → Lop → Khoa.
    4. View lương nhân viên sau khi trừ thuế
       Hiển thị:
        - HoTen
        - LuongGoc
        - LuongSauThue = Luong * 0.9

- **Stored Procedure / Function** (4 bài)
    1. Stored procedure thêm sinh viên
       SP AddStudent(MaSV, HoTen, NgaySinh, MaLop) nhưng kiểm tra:
        - Không trùng MaSV
        - Lớp tồn tại
        - Nếu OK → INSERT.
    2. Stored procedure cập nhật lương theo %
       Input: MaNV, percent_increase
       → `tăng lương = lương hiện tại * (1 + percent/100)`
    3. Function tính tuổi
       Viết function TinhTuoi(NgaySinh) trả về số tuổi.
    4. Function tính GPA 4.0
       Input MaSV → trả `GPA = SUM(diem * tín_chỉ) / SUM(tín_chỉ)` theo thang 4.

- **Normalization** (Chuẩn hóa) (2 bài)

    1. Chuẩn hóa bảng chứa dữ liệu bị lặp
       Bảng gốc:
       `| MaSV | TenSV | TenLop | TenKhoa | TenKhoaTruong |`
       Yêu cầu:
        - Chuẩn hóa lên 3NF
        - Tạo các bảng `Khoa`, `Lop`, `SinhVien`, `KhoaTruong`
        - Phân tích khóa chính/phụ từng bảng

    2. Chuẩn hóa bảng ChiTietDonHang
       Bảng gốc chứa:
       `| MaDH | TenKH | DiaChi | MaSP | TenSP | DonGia | SoLuong |`
       Yêu cầu:
        - Xác định bất thường (insert/update/delete anomaly)
        - Chuẩn hóa lên 3NF: `KhachHang`, `DonHang`, `SanPham`, `ChiTietDonHang`

## Prerequisites

### Project Structure

```text
./
│   index.sql
│   normalization.sql
│   README.md
│   stored-procedure-function.sql
│   trigger.sql
└───view.sql
```

### Environment

- IDE: DataGrip
- Database: MySQL 8.4

## Solution

1. [Trigger](./trigger.sql)
2. [Index](./index.sql)
3. [View](./view.sql)
4. [Stored Procedure and Functions](./stored-procedure-function.sql)
5. [Normalization](./normalization.sql)

## Author

Khang Nguyen