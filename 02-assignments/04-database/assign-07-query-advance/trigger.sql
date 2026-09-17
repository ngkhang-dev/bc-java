# 1.
CREATE TRIGGER trg_KiemTraTuoiSV
    BEFORE INSERT
    ON SinhVien
    FOR EACH ROW
BEGIN
    IF TIMESTAMPDIFF(YEAR, NEW.NgaySinh, CURRENT_DATE()) < 18 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Sinh viên phải đủ 18 tuổi trở lên';
    END IF;
END;

# 2.
CREATE TRIGGER trg_CapNhatKho
    AFTER INSERT
    ON ChiTietHoaDon
    FOR EACH ROW
BEGIN
    UPDATE SanPham
    SET SoLuongTonKho = SoLuongTonKho - NEW.SoLuong
    WHERE NEW.MaSP = MaSP;
END;


# 3.
CREATE TRIGGER trg_LogLuong
    AFTER UPDATE
    ON NhanVien
    FOR EACH ROW
BEGIN
    IF OLD.Luong <> NEW.Luong THEN
        INSERT INTO LichSuLuong(MaNV, LuongCu, LuongMoi, NgayCapNhat)
        VALUES (OLD.MaNV, OLD.LuongCu, NEW.LuongMoi, NOW());
    END IF;
END;

# 4.
CREATE TRIGGER trg_KhongXoaLop
    BEFORE DELETE
    ON Lop
    FOR EACH ROW
BEGIN
    DECLARE soLuongSV INT;

    SELECT COUNT(*) INTO soLuongSV FROM SinhVien WHERE MaLop = OLD.MaLop;

    IF soLuongSV > 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Không thể xóa lớp vì còn sinh viên thuộc lớp này';
    END IF;
END;

# 5.
CREATE TRIGGER trg_TaoUserName
    BEFORE INSERT
    ON NhanVien
    FOR EACH ROW
BEGIN
    INSERT INTO Accounts(MaNV, Username) VALUES (OLD.MaNV, LOWER(REPLACE(NEW.HoTen, ' ', '')));
END;

# 6.
CREATE TRIGGER trg_LogLoginTime
    BEFORE INSERT
    ON LoginHistory
    FOR EACH ROW
BEGIN
    IF NEW.LoginTime IS NULL THEN
        SET NEW.LoginTime = NOW();
    END IF;
END;