/*
    - Intro MySQL
        - CREATE/DROP/SHOW/USE database
        - CREATE/DROP/SHOW/UPDATE/INSERT table
        - SELECT query
        - LIKE, ORDER BY, DISTINCT
        - AVG, COUNT, MAX, MIN, SUM
        - GROUP BY, HAVING
        - BETWEEN ... AND
        - Primary and Foreign keys
        - JOIN (INNER JOIN)
*/

# CREATE DATABASE - Create a new database
# CREATE DATABASE TrungTam;
CREATE DATABASE IF NOT EXISTS TrungTam;

# View list database
SHOW DATABASES;

# Use database
USE TrungTam;

# Drop databse
DROP DATABASE TrungTam;

SELECT DATABASE();

# Update database
ALTER DATABASE TrungTam CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# Create table
CREATE TABLE HocVien
(
    id    VARCHAR(5),
    ten   NVARCHAR(100),
    sdt   VARCHAR(12),
    email VARCHAR(50)
);

# View list table
SHOW TABLES;

# INSERT...INTO - Insert data
INSERT INTO HocVien
VALUES ('SV001', 'Nguyen Van A', '0999999999', 'nva@gmail.com');

INSERT INTO HocVien (id, ten, email)
VALUES ('SV002', 'Nguyen Van B', 'nvb@gmail.com');

INSERT INTO HocVien (id, ten, email)
VALUES ('SV003', 'Nguyen Van C', 'nvc@gmail.com'),
       ('SV004', 'Nguyen Van D', 'nvd@gmail.com'),
       ('SV005', 'Nguyen Van E', 'nve@gmail.com'),
       ('SV006', 'Nguyen Van F', 'nvf@gmail.com');

# SELECT - Get value
SELECT *
FROM HocVien;

SELECT *
FROM HocVien
LIMIT 2;

SELECT ten, email
FROM HocVien;

# UPDATE - Update data
UPDATE HocVien
SET id='SV007'
WHERE ten = 'Nguyen Van Hieu';

# ALTER TABLE - Update config/structure table
ALTER TABLE HocVien
    ADD PRIMARY KEY (id);

ALTER TABLE HocVien
    MODIFY COLUMN sdt VARCHAR(12) DEFAULT '0000';

ALTER TABLE HocVien
    ADD COLUMN tuoi INT NOT NULL DEFAULT 18;

CREATE TABLE sinh_vien
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    hoTen         VARCHAR(100) NOT NULL,
    email         VARCHAR(50),
    tuoi          INT,
    ngaySinh      DATE,
    hocPhi        DECIMAL(15, 2),
    diemTrungBinh DECIMAL(4, 2),
    dangHoc       BOOLEAN      NOT NULL DEFAULT TRUE,
    ngayTao       DATETIME              DEFAULT CURRENT_TIMESTAMP()
);

-- them du lieu
INSERT INTO sinh_vien (hoTen, email, tuoi, ngaySinh, hocPhi, diemTrungBinh)
VALUES ('nguyen van e', 'e@gmail.com', 18, '2005-10-21', 15000000, 8.5),
       ('nguyen van f', 'f@gmail.com', 20, '2005-10-20', 15000000, 8);

# 1. Lấy thông tin của sinh viên
SELECT *
FROM sinh_vien;

# 2. Sửa tên sinh viên có id = 4
UPDATE sinh_vien
SET hoTen = 'NGUYEN VAN B'
WHERE id = 4;

# 3. Xóa sinh viên có id = 9
DELETE
FROM sinh_vien
WHERE id = 9;

# 4. Lấy danh sách sinh viên có điểm TB > 8 và còn đang học
SELECT *
FROM sinh_vien
WHERE diemTrungBinh > 8
  AND dangHoc = 0;

# 5. Lấy danh sách sinh viên có họ tên kết thúc là chữ "b"
SELECT *
FROM sinh_vien
WHERE hoTen LIKE '%b';

INSERT INTO sinh_vien
(hoTen, email, tuoi, ngaySinh, hocPhi, diemTrungBinh, dangHoc)
VALUES ('Nguyễn Văn An', NULL, 20, '2006-03-15', 12000000.00, 8.20, TRUE),
       ('Trần Thị Bình', 'binh@gmail.com', 21, '2005-07-22', 13500000.00, 7.50, TRUE),
       ('Lê Hoàng Cường', 'cuong@gmail.com', 19, '2007-01-10', 11000000.00, 6.80, TRUE),
       ('Phạm Minh Đức', NULL, 22, '2004-11-05', 15000000.00, 9.10, TRUE),
       ('Hoàng Thị Em', 'em@gmail.com', 20, '2006-09-18', 12500000.00, 7.90, FALSE),
       ('Võ Quốc Huy', 'huy@gmail.com', 23, '2003-05-12', 16000000.00, 8.50, TRUE),
       ('Đặng Ngọc Lan', 'lan@gmail.com', 21, '2005-02-28', 14000000.00, 9.20, TRUE),
       ('Bùi Văn Minh', NULL, 20, '2006-06-30', 11500000.00, 5.80, TRUE),
       ('Đỗ Thị Nga', 'nga@gmail.com', 22, '2004-08-14', 15500000.00, 8.70, TRUE),
       ('Ngô Đức Phúc', 'phuc@gmail.com', 19, '2007-12-01', 10000000.00, 6.50, FALSE),
       ('Nguyễn Thị Quỳnh', 'quynh@gmail.com', 21, '2005-04-16', 13000000.00, 7.70, TRUE),
       ('Trần Văn Sơn', NULL, 24, '2002-10-20', 17000000.00, 8.00, TRUE),
       ('Lê Minh Tú', 'tu@gmail.com', 20, '2006-01-25', 12000000.00, 6.20, TRUE),
       ('Phạm Thị Uyên', 'uyen@gmail.com', 22, '2004-03-09', 14500000.00, 9.00, TRUE),
       ('Hoàng Văn Vinh', 'vinh@gmail.com', 23, '2003-07-17', 16500000.00, 7.30, FALSE),
       ('Võ Thị Xuân', 'xuan@gmail.com', 19, '2007-05-06', 10500000.00, 8.80, TRUE),
       ('Đặng Gia Bảo', 'bao@gmail.com', 20, '2006-11-11', 12500000.00, 5.50, TRUE),
       ('Bùi Thanh Hà', 'ha@gmail.com', 21, '2005-09-23', 13500000.00, 7.10, TRUE),
       ('Đỗ Quốc Khánh', 'khanh@gmail.com', 22, '2004-06-19', 15000000.00, 9.50, TRUE),
       ('Ngô Thị Mai', 'mai@gmail.com', 20, '2006-02-08', 11800000.00, 6.90, FALSE);

-- 6. Lấy ra danh sách sinh viên có họ "Trần"
SELECT *
FROM sinh_vien
WHERE hoTen LIKE 'Trần%';

-- 7. Lấy ra danh sách sinh viên có email là NULL
SELECT *
FROM sinh_vien
WHERE email IS NULL;

-- 8. Lấy ra danh sách sinh viên có email khác NULL
SELECT *
FROM sinh_vien
WHERE email IS NOT NULL;

-- 9. Sắp xếp sinh viên theo tăng dần theo độ tuổi, điểm trung bình và giới hạn là 3
SELECT *
FROM sinh_vien
ORDER BY tuoi ASC, diemTrungBinh ASC
LIMIT 3;

-- 10. Lấy danh sách tuổi không trùng
SELECT DISTINCT tuoi
FROM sinh_vien;

-- 11. Tính tuổi trung bình của sinh viên
SELECT AVG(tuoi)
FROM sinh_vien;

-- 12. Tính điểm trung bình của sinh viên
SELECT AVG(diemTrungBinh)
FROM sinh_vien;

-- 13. Đếm số lượng sinh viên có tuổi > 20
SELECT COUNT(*)
FROM sinh_vien
WHERE tuoi >= 20;

-- 14. Tìm DTB lớn nhất, tuổi nhỏ nhất, tổng học phí thu được
SELECT MAX(diemTrungBinh) AS DTB_Cao_nhat,
       MIN(tuoi)          AS Tuoi_Nho_Nhat,
       SUM(hocPhi)        AS Tong_Thu
FROM sinh_vien;

-- 15. Tìm số lượng sinh viên và DTB theo độ tuổi
SELECT tuoi,
       COUNT(*),
       AVG(diemTrungBinh)
FROM sinh_vien
GROUP BY tuoi;

-- 16. Tìm số lượng SV đang học theo độ tuổi
SELECT tuoi,
       COUNT(*)
FROM sinh_vien
WHERE dangHoc = TRUE
GROUP BY tuoi;

-- 17. Lấy ra tuổi có nhiều hơn 3 sinh viên
SELECT tuoi,
       COUNT(*) AS So_Luong
FROM sinh_vien
GROUP BY tuoi
HAVING So_Luong > 3;

-- 18. Lấy nhóm tuổi có điểm trung bình từ 8 trở lên
SELECT tuoi,
       AVG(diemTrungBinh) AS dtb
FROM sinh_vien
GROUP BY tuoi
HAVING dtb > 8;

-- 19. Tính tổng học phí theo trạng thái học
SELECT SUM(hocphi)                               AS tongHP,
       IF(dangHoc = TRUE, 'Dang hoc', 'Da nghi') AS trangThai
FROM sinh_vien
GROUP BY dangHoc;

-- 20. Lấy danh sách sinh vó DTB từ 6.5 đến 8
SELECT *
FROM sinh_vien
WHERE diemTrungBinh >= 6.5
  AND diemTrungBinh <= 8;

SELECT *
FROM sinh_vien
WHERE diemTrungBinh BETWEEN 6.5 AND 8;

-- Create khoa_hoc table
CREATE TABLE khoa_hoc
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    tenKH VARCHAR(100),
    code  VARCHAR(20) NOT NULL DEFAULT (CONCAT('KH0-', LPAD(FLOOR(RAND()) * 10000, 4, '0')))
);

ALTER TABLE khoa_hoc
    MODIFY COLUMN code VARCHAR(20) NOT NULL DEFAULT (CONCAT('KH0-', LPAD(FLOOR(RAND() * 100), 3, '0')));

INSERT INTO khoa_hoc (tenKH)
VALUES ('Fullstack Java'),
       ('Fullstack Dotnet'),
       ('Fullstack Javascript');

INSERT INTO khoa_hoc (tenKH)
VALUES ('DA 2');

-- Create sv_kh table
CREATE TABLE sv_kh
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    idSinhVien INT NOT NULL,
    idKhoaHoc  INT NOT NULL,
    ngayTao    DATETIME DEFAULT CURRENT_TIMESTAMP(),
    thanhToan  BOOLEAN,
    FOREIGN KEY (idSinhVien) REFERENCES sinh_vien (id)
);

ALTER TABLE sv_kh
    ADD CONSTRAINT sv_kh_KhoaHoc FOREIGN KEY (idKhoaHoc) REFERENCES khoa_hoc (id);

INSERT INTO sv_kh (idSinhVien, idKhoaHoc, thanhToan)
VALUES (20, 1, TRUE),
       (21, 1, TRUE),
       (22, 1, TRUE),
       (21, 2, TRUE),
       (22, 2, TRUE),
       (23, 2, TRUE);

-- 22. Hiện thị danh sách tổng quát về sinh vien và khóa học
SELECT dkh.id,
       sv.hoTen,
       kh.tenKH,
       dkh.ngayTao                                               AS 'Ngay DK',
       CONCAT(IF(thanhToan = TRUE, 'Da', 'Chua'), ' thanh toan') AS 'Thanh toan'
FROM sv_kh dkh
         JOIN sinh_vien sv ON sv.id = dkh.idSinhVien
         JOIN khoa_hoc kh ON kh.id = dkh.idKhoaHoc;

-- 23. Thống kê mỗi khóa học có bao nhiều học viên đăng ký
SELECT tenKH, COUNT(*)
FROM sv_kh dkh
         JOIN khoa_hoc kh ON kh.id = dkh.idKhoaHoc
GROUP BY idKhoaHoc;

-- 24. Thống kê mỗi sinh viên học bao nhiêu khóa
SELECT hoten, COUNT(*)
FROM sv_kh dkh
         JOIN sinh_vien sv ON sv.id = idSinhVien
GROUP BY idSinhVien;

-- 25. Khóa nào có điểm trung bình cao nhất
SELECT tenKH, AVG(sv.diemTrungBinh) AS dtb
FROM sv_kh dkh
         JOIN sinh_vien sv ON sv.id = idSinhVien
         JOIN khoa_hoc kh ON kh.id = idKhoaHoc
GROUP BY kh.id
ORDER BY dtb DESC
LIMIT 1;
