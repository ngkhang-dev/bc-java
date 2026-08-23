/**
    - Relationship
    - JOIN clause
        - INNER/LEFT/RIGHT JOIN
        - UNION - FULL JOIN
    - Subquery
 */

CREATE DATABASE IF NOT EXISTS DB_BANHANG;

USE DB_BANHANG;

-- =========================
-- Create structure schema
-- =========================

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

-- =========================
-- Insert data
-- =========================

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

-- =========================
-- Practice
-- =========================

-- 1. Lấy ra danh sách sản phẩm kèm loại sản phẩm
SELECT s.MaSP, s.TenSP, s.Gia, l.TenLoaiSP
FROM SanPham s
         INNER JOIN LoaiSanPham l
                    ON s.MaLoaiSP = l.MaLoaiSP;

-- 2. Tìm sản phẩm có mã là 6 và cập nhật loại sản phẩm là null
UPDATE SanPham
SET MaLoaiSP = NULL
WHERE MaSP = 6;

-- 3. Tìm danh sách khách hàng có hóa đơn
SELECT *
FROM KhachHang k
         INNER JOIN HoaDon h
                    ON k.MaKH = h.MaKH;

-- 4. Tìm danh sách khách hàng không hóa đơn
SELECT *
FROM KhachHang k
         LEFT JOIN HoaDon h
                   ON k.MaKH = h.MaKH
WHERE h.MaHoaDon IS NULL;

-- 5.
SELECT *
FROM KhachHang k
         LEFT JOIN HoaDon h
                   ON k.MaKH = h.MaKH
UNION
SELECT *
FROM KhachHang k
         RIGHT JOIN HoaDon h
                    ON k.MaKH = h.MaKH;

-- 6. Tìm sản phẩm có giá cao nhất
SELECT *
FROM SanPham
ORDER BY Gia DESC
LIMIT 1;

SELECT *
FROM SanPham
WHERE gia = (SELECT MAX(gia)
             FROM SanPham)
LIMIT 1;

-- 7. Tìm sản phẩm có giá cao hơn giá trung bình
SELECT *
FROM SanPham
WHERE gia > (SELECT AVG(gia)
             FROM SanPham);

-- 8. Tìm sản phẩm có loại là 'Laptop'
SELECT sp.*
FROM SanPham sp
         JOIN LoaiSanPham lsp
              ON sp.MaLoaiSP = lsp.MaLoaiSP
WHERE lsp.TenLoaiSP = 'Laptop';

SELECT *
FROM SanPham sp
WHERE MaLoaiSP = (SELECT MaLoaiSP
                  FROM LoaiSanPham
                  WHERE TenLoaiSP = 'Laptop');

-- 9. Danh sách sản phẩm đã bán
SELECT *
FROM SanPham
WHERE MaSP IN (SELECT MaSP
               FROM SanPham_HoaDon);

-- 10. Khách hàng có nhiều hóa đơn nhất
SELECT MaKH, COUNT(*) AS SoLuong
FROM HoaDon
GROUP BY MaKH;

SELECT MAX(SoLuong)
FROM (SELECT MaKH, COUNT(*) AS SoLuong
      FROM HoaDon
      GROUP BY MaKH) bang_tam;

SELECT k.MaKH, Ho, Ten, COUNT(*) AS SoLuongDon
FROM KhachHang k
         INNER JOIN HoaDon h
                    ON h.MaKH = k.MaKH
GROUP BY k.MaKH
HAVING SoLuongDon = (SELECT MAX(SoLuong)
                     FROM (SELECT MaKH, COUNT(*) AS SoLuong
                           FROM HoaDon
                           GROUP BY MaKH) bang_tam);
