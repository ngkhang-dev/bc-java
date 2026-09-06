# 11.
CREATE VIEW vw_TongHopDiem AS
SELECT sv.MaSV,
       sv.HoTen,
       mh.TenMH,
       kq.DiemSo,
       CASE
           WHEN kq.DiemSo >= 8 THEN 'A'
           WHEN kq.DiemSo >= 6.5 THEN 'B'
           WHEN kq.DiemSo >= 5 THEN 'C'
           WHEN kq.DiemSo >= 4 THEN 'D'
           ELSE 'F'
           END AS DiemChu
FROM SinhVien AS sv
         JOIN KetQuaHoc kq ON sv.MaSV = kq.MaSV
         JOIN MonHoc mh ON kq.MaMH = mh.MaMH;

# 12.
CREATE VIEW vw_Top10SanPhamBanChay AS
SELECT sp.MaSP,
       sp.TenSP,
       SUM(ct.SoLuong) AS TongSoLuongBan
FROM SanPham AS sp
         JOIN ChiTietHoaDon ct ON ct.MaSP = sp.MaSP
         JOIN HoaDon hd ON hd.MaHD = ct.MaHD
GROUP BY sp.MaSP, sp.TenSP
ORDER BY TongSoLuongBan DESC
LIMIT 10;

# 13.
CREATE VIEW vw_SinhVienTheoKhoa AS
SELECT sv.MaSV, sv.HoTen, l.TenLop, k.TenKhoa
FROM SinhVien sv
         JOIN Lop l ON sv.MaLop = l.MaLop
         JOIN Khoa k ON l.MaKhoa = k.MaKhoa;

# 14.
CREATE VIEW vw_LuongNVSauThue AS
SELECT MaNV,
       HoTen,
       Luong       AS LuongGoc,
       Luong * 0.9 AS LuongSauThue
FROM NhanVien;
