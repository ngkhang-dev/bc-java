/**
    - EXPLAIN query
    - INDEX:
        - Index không làm thay đổi kết quả mà thay đổi cách MySQL tìm ra kết quả
        - Có INDEX không có nghĩa mọi query đều dùng INDEX. Optimizer quyết định
        - Thường giúp đọc/tìm kiếm nhanh hơn nhưng thao tác ghi tốn chi phí
    - CASE..END, IF ELSE
    - CONCAT(), NOW(), CURDATE(), YEAR(), MONTH(), DAY(), DATEDIFF()
    - Declare variable: SET @<variable_name> = <value>
        - Tồn tại trong bộ nhớ tạm/session. Sẽ mất khi disconnect với database, docker
    - Function
        - Hàm lưu trong db, phải trả về một giá trị
    - View
        - Table là nơi lưu dữ liệu, View: lưu cách truy vấn dữ liệu
        - Tái sử dụng view như table với các cột đã được cấu hình lúc tạo view

    - Store procedure:
        - Tập hợp nhiều lệnh sql
                Function        |       Store procedure
        Trả về 1 giá trị        |   Có thể trả về nhiều dòng
        Có Return               |   Không bắt buộc
        Gọi trong SELECT        |   Gọi bằng CALL
        Thường dùng tính toán   |   Thường xử lý nghiệp vụ

    - Trigger
        - Thực hiện 1 tác vụ khi có các thao tác insert/update/delete
                Procedure               |           Trigger
        Chủ động gọi                    |   Tự động chạy
        CALL				            |	Không CALL
        Có tham số			            |   Không truyền tham số kiểu CALL
        Chạy khi người dùng yêu cầu     |	Chạy khi dữ liệu thay đổi
        Xử lý nghiệp vụ					|   Phản ứng với dữ liệu
 */

-- Initial database
CREATE DATABASE IF NOT EXISTS DB_BANHANG;
USE DB_BANHANG;

CREATE TABLE LoaiSanPham
(
    MaLoaiSP  INT PRIMARY KEY AUTO_INCREMENT,
    TenLoaiSP VARCHAR(100) NOT NULL
);

CREATE TABLE KhachHang
(
    MaKH   INT PRIMARY KEY AUTO_INCREMENT,
    Ten    VARCHAR(50)  NOT NULL,
    Ho     VARCHAR(50)  NOT NULL,
    Email  VARCHAR(100) NOT NULL,
    SoDT   VARCHAR(15),
    DiaChi VARCHAR(100)
);

CREATE TABLE SanPham
(
    MaSP     INT PRIMARY KEY AUTO_INCREMENT,
    TenSp    VARCHAR(150) NOT NULL,
    MoTa     VARCHAR(255),
    Gia      DECIMAL(15, 2),
    MaLoaiSP INT,
    CONSTRAINT FK_SanPham_LoaiSanPham FOREIGN KEY (MaLoaiSP) REFERENCES LoaiSanPham (MaLoaiSP)
);

CREATE TABLE HoaDon
(
    MaHoaDon INT PRIMARY KEY AUTO_INCREMENT,
    MaKH     INT NOT NULL,
    NgayMua  DATETIME DEFAULT CURRENT_TIMESTAMP(),
    CONSTRAINT FK_HoaDon_KhachHang FOREIGN KEY (MaKH) REFERENCES KhachHang (MaKH)
);

CREATE TABLE SanPham_HoaDon
(
    MaSPHD   INT PRIMARY KEY AUTO_INCREMENT,
    MaHoaDon INT,
    MaSP     INT,
    SoLuong  INT            NOT NULL DEFAULT 1,
    GiaBan   DECIMAL(15, 2) NOT NULL,
    CONSTRAINT FK_SanPhamHoaDon_HoaDon FOREIGN KEY (MaHoaDon) REFERENCES HoaDon (MaHoaDon),
    CONSTRAINT FK_SanPhamHoaDon_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP)
);

INSERT INTO LoaiSanPham (TenLoaiSP)
VALUES ('Điện thoại'),
       ('Laptop'),
       ('Phụ kiện');

INSERT INTO SanPham (TenSP, MoTa, Gia, MaLoaiSP)
VALUES ('iPhone 15', 'Điện thoại Apple', 20000000, 1),
       ('Samsung S24', 'Điện thoại Samsung', 18000000, 1),
       ('MacBook Air M3', 'Laptop Apple', 28000000, 2),
       ('Dell Inspiron 15', 'Laptop Dell', 17000000, 2),
       ('Chuột Logitech', 'Chuột không dây', 500000, 3),
       ('Bàn phím Logitech', 'Bàn phím cơ', 1200000, 3);

INSERT INTO KhachHang
    (Ho, Ten, Email, SoDT, DiaChi)
VALUES ('Nguyễn Văn', 'An', 'an@gmail.com', '0901111111', 'TP.HCM'),
       ('Trần Thị', 'Bình', 'binh@gmail.com', '0902222222', 'Hà Nội'),
       ('Lê Văn', 'Cường', 'cuong@gmail.com', '0903333333', 'Đà Nẵng'),
       ('Phạm Thị', 'Dung', 'dung@gmail.com', '0904444444', 'Khánh Hòa');

INSERT INTO HoaDon (MaKH, NgayMua)
VALUES (1, '2026-08-10 09:30:00'),
       (1, '2026-08-11 14:00:00'),
       (2, '2026-08-11 15:30:00'),
       (3, '2026-08-12 10:00:00');

INSERT INTO SanPham_HoaDon
    (MaHoaDon, MaSP, SoLuong, GiaBan)
VALUES
-- Hóa đơn 1
(1, 1, 1, 20000000),
(1, 5, 2, 500000),

-- Hóa đơn 2
(2, 3, 1, 28000000),
(2, 6, 1, 1200000),

-- Hóa đơn 3
(3, 2, 1, 18000000),
(3, 5, 1, 500000),

-- Hóa đơn 4
(4, 4, 1, 17000000);

-- Explain query
-- Flow trong MySQL: SQL -> ... -> Exec plan -> Thực thi -> Data
EXPLAIN
SELECT sp.TenSp, sp.Gia, lsp.TenLoaiSP
FROM SanPham sp
         INNER JOIN LoaiSanPham lsp
                    ON sp.MaLoaiSP = lsp.MaLoaiSP;

EXPLAIN
SELECT *
FROM SanPham sp
WHERE sp.MaSP = 1;

-- Create MOCK data: 100.000 san pham
INSERT INTO SanPham (TenSP,
                                MoTa,
                                Gia,
                                MaLoaiSP)
SELECT CONCAT('Sản phẩm ', n),
       CONCAT('Mô tả sản phẩm ', n),
       100000 + (n * 5000),
       ((n - 1) % 3) + 1
FROM (SELECT ROW_NUMBER() OVER () AS n
      FROM information_schema.columns a
               CROSS JOIN information_schema.columns b
      LIMIT 100000) AS numbers;

EXPLAIN
SELECT *
FROM SanPham
WHERE Masp = 2000;

-- Trước khi dùng index: MySQL tìm theo type = all
EXPLAIN
SELECT *
FROM SanPham
WHERE Gia = 20000000;

CREATE INDEX idx_sanpham_gia ON SanPham (Gia);
-- Sau khi dùng index: MySQL tìm theo type = ref
EXPLAIN
SELECT *
FROM SanPham
WHERE Gia = 20000000;

-- MySQL tìm theo type = range và possible type = idx_sanpham_gia
EXPLAIN
SELECT *
FROM SanPham
WHERE Gia > 500000000;

-- MySQL tìm theo type = all và possible type = idx_sanpham_gia
EXPLAIN
SELECT *
FROM SanPham
WHERE Gia > 40000000;

-- In ra sách sách có cột "Phân khúc" dựa trên giá:
--  - Cao cấp: Giá > 300000000
--  - Trung cấp: Giá > 100000000
--  - Giá thấp: Giá <= 100000000
SELECT sp.TenSp,
       sp.MaSP,
       sp.Gia,
       CASE
           WHEN sp.Gia > 300000000 THEN 'Cao Cap'
           WHEN sp.Gia > 100000000 THEN 'Trung Cap'
           ELSE 'Gia Thap'
           END
           AS PhanKhuc
FROM SanPham sp;

-- Phân loại khách hàng dựa trên tổng tiền đã mua
SELECT CONCAT(kh.Ho, ' ', kh.Ten)      AS HoTen,
       SUM(sphd.SoLuong * sphd.GiaBan) AS TongChiTieu,
       CASE
           WHEN SUM(sphd.SoLuong * sphd.GiaBan) > 50000000 THEN 'VIP'
           WHEN SUM(sphd.SoLuong * sphd.GiaBan) > 15000000 THEN 'Than Thiet'
           ELSE 'Thanh Vien'
           END                         AS LoaiKhachHang
FROM HoaDon hd
         INNER JOIN SanPham_HoaDon sphd ON hd.MaHoaDon = sphd.MaHoaDon
         INNER JOIN KhachHang kh ON hd.MaKH = kh.MaKH
GROUP BY hd.MaKH;

-- Danh sách hóa đơn
SELECT MaHoaDon,
       NgayMua,
       YEAR(NgayMua)  AS Nam,
       MONTH(NgayMua) AS Thang,
       DAY(NgayMua)   AS Ngay
FROM HoaDon;

-- Danh sách hóa đơn theo tháng: 8/2026
SELECT *
FROM HoaDon
WHERE MONTH(NgayMua) = 8
  AND YEAR(NgayMua) = 2026;

-- Danh sách hóa đơn với số ngày đã mua
SELECT MaHoaDon,
       NgayMua,
       DATEDIFF(NOW(), NgayMua) AS SoNgayDaQua
FROM HoaDon;

-- Tạo biến: tồn tại trong session đến khi disconnect
SET @giaMax = 200000;

SELECT *
FROM SanPham sp
WHERE gia <= @giaMax;

-- Set giá trung bình của các sản phẩm vào biến @giaTrungBinh
SELECT AVG(sp.Gia)
INTO @giaTrungBinh
FROM SanPham sp;

SELECT @giaTrungBinh;

SELECT *
FROM SanPham
WHERE Gia > @giaTrungBinh;

# Declare function
CREATE FUNCTION fn_TinhThanhTien(
    p_SoLuong INT,
    p_GiaBan DECIMAL(15, 2)
) RETURNS DECIMAL(15, 2)
    DETERMINISTIC
BEGIN
    RETURN p_SoLuong * p_GiaBan;
END;

# Call function
SELECT fn_TinhThanhTien(3, 20000) AS "Calculator Price";

# Drop
DROP FUNCTION fn_TinhThanhTien;

CREATE FUNCTION fn_PhanLoaiGia(
    p_Gia DECIMAL(15, 2)
) RETURNS VARCHAR(50)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(50);

    IF (p_Gia >= 300000000) THEN
        SET result = 'Cao Cap';
    ELSEIF (p_Gia >= 100000000) THEN
        SET result = 'Trung Cap';
    ELSE
        SET result = 'Gia Thap';
    END IF;

    RETURN result;
END;

SELECT fn_PhanLoaiGia(10000000);

SELECT sp.TenSp, sp.Gia, fn_PhanLoaiGia(sp.Gia) AS PhanKhuc
FROM SanPham sp
LIMIT 20;

-- Tạo view để lưu cách truy vấn dữ liệu
CREATE VIEW vw_DanhSachSanPham
AS
SELECT sp.MaSP,
       sp.TenSP,
       sp.Gia,
       l.TenLoaiSP
FROM SanPham sp
         LEFT JOIN LoaiSanPham l
                   ON sp.MaLoaiSP = l.MaLoaiSP;

SELECT *
FROM vw_DanhSachSanPham
WHERE TenLoaiSP LIKE '%lap%';

-- Tạo view "vw_ChiTietHoaDon" với các cột:
--  ma hoa don, ten khach hang, ten sp, so luong , giaban , thanh tien
CREATE VIEW vw_ChiTietHoaDon
AS
SELECT hd.MaHoaDon,
       CONCAT(kh.Ho, ' ', kh.Ten) AS HoTen,
       sp.TenSp,
       sphd.SoLuong,
       sphd.GiaBan,
       sphd.SoLuong * sphd.GiaBan AS ThanhTien
FROM HoaDon hd
         INNER JOIN KhachHang kh ON hd.MaKH = kh.MaKH
         INNER JOIN SanPham_HoaDon sphd ON sphd.MaHoaDon = hd.MaHoaDon
         INNER JOIN SanPham sp ON sp.MaSP = sphd.MaSP;

-- Tạo procedure để lấy sản phẩm theo mã loại
CREATE PROCEDURE sp_GetSanPhamTheoMaLoai(
    IN p_MaLoaiSP INT
)
BEGIN
    SELECT *
    FROM SanPham
    WHERE MaLoaiSP = p_MaLoaiSP;
END;

CALL sp_GetSanPhamTheoMaLoai(2);

-- Tạo procedure để lấy sản phẩm theo tên loại sản phẩm
CREATE PROCEDURE sp_GetSanPhamTheoMaLoai(
    IN p_TenLoaiSanPham VARCHAR(100)
)
BEGIN
    DECLARE v_MaLoai INT;

    SELECT lsp.MaLoaiSP
    INTO v_MaLoai
    FROM LoaiSanPham lsp
    WHERE lsp.TenLoaiSP LIKE CONCAT('%', p_TenLoaiSanPham, '%')
    LIMIT 1;

    SELECT *
    FROM SanPham sp
    WHERE sp.MaLoaiSP = v_MaLoai;
END;

CALL sp_GetSanPhamTheoMaLoai('tho');

-- Check giá sản phẩm trước khi thêm
CREATE TRIGGER trg_CheckGiaSanPham
    BEFORE INSERT
    ON SanPham
    FOR EACH ROW
BEGIN
    IF new.Gia < 0 THEN
        SIGNAL SQLSTATE '40400' -- Mã lỗi: char, bắt buộc 5 ký tự
            SET MESSAGE_TEXT = 'Giá sản phẩm không được âm';
    END IF;
END;

INSERT INTO SanPham(TenSP,
                               Gia)
VALUES ('Sản phẩm lỗi',
        -500000);
