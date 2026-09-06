# 19.
CREATE TABLE KhoaTruong
(
    MaKhoaTruong  VARCHAR(10) PRIMARY KEY,
    TenKhoaTruong VARCHAR(100)
);

CREATE TABLE Khoa
(
    MaKhoa       VARCHAR(10) PRIMARY KEY,
    TenKhoa      VARCHAR(100),
    MaKhoaTruong VARCHAR(10),
    FOREIGN KEY (MaKhoaTruong) REFERENCES KhoaTruong (MaKhoaTruong)
);

CREATE TABLE Lop
(
    MaLop  VARCHAR(10) PRIMARY KEY,
    TenLop VARCHAR(50),
    MaKhoa VARCHAR(10),
    FOREIGN KEY (MaKhoa) REFERENCES Khoa (MaKhoa)
);

CREATE TABLE SinhVien
(
    Masv  VARCHAR(10) PRIMARY KEY,
    Tensv VARCHAR(100),
    MaLop VARCHAR(10),
    FOREIGN KEY (MaLop) REFERENCES Lop (MaLop)
);

# 20.
CREATE TABLE KhachHang
(
    MaKH   VARCHAR(10) PRIMARY KEY,
    TenKH  VARCHAR(100),
    DiaChi VARCHAR(200)
);

CREATE TABLE DonHang
(
    MaDH    VARCHAR(10) PRIMARY KEY,
    MaKH    VARCHAR(10),
    NgayDat DATETIME,
    FOREIGN KEY (MaKH) REFERENCES KhachHang (MaKH)
);

CREATE TABLE SanPham
(
    MaSP   VARCHAR(10) PRIMARY KEY,
    TenSP  VARCHAR(100),
    DonGia DECIMAL(12, 2)
);

CREATE TABLE ChiTietDonHang
(
    MaDH    VARCHAR(10),
    Masp    VARCHAR(10),
    soLuong INT,
    PRIMARY KEY (MaDH, MaSP),
    FOREIGN KEY (MaDH) REFERENCES DonHang (MaDH),
    FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP)
);
