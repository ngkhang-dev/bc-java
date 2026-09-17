# 15.
CREATE PROCEDURE AddStudent(
    IN p_MaSV VARCHAR(10),
    IN p_HoTen VARCHAR(100),
    IN p_NgaySinh DATE,
    IN p_MaLop VARCHAR(10)
)
BEGIN
    DECLARE v_SVCount INT;
    DECLARE v_LopCount INT;

    SELECT COUNT(*) INTO v_SVCount FROM SinhVien WHERE MaSV = p_MaSV;
    SELECT COUNT(*) INTO v_LopCount FROM Lop WHERE MaLop = p_MaLop;

    IF v_SVCount > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Mã sinh viên đă tồn tại';
    ELSEIF v_LopCount = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Mã lớp không tồn tại';
    ELSE
        INSERT INTO SinhVien (MaSV, HoTen, NgaySinh, MaLop)
        VALUES (p_MaLop, p_HoTen, p_NgaySinh, p_MaLop);
    END IF;
END;

# 16.
CREATE PROCEDURE UpdateSalaryByPercent(
    IN p_MaNV VARCHAR(10),
    IN p_PercentIncrease DECIMAL(5, 2)
)
BEGIN
    UPDATE NhanVien
    SET Luong = Luong * (1 + p_PercentIncrease / 100)
    WHERE MaNV = p_MaNV;
END;

# 17.
CREATE FUNCTION TinhTuoi(p_NgaySinh DATE)
    RETURNS INT
    DETERMINISTIC
BEGIN
    RETURN TIMESTAMPDIFF(YEAR, p_NgaySinh, CURDATE());
END;

# 18.
CREATE FUNCTION TinhGPA(p_MaSV VARCHAR(10))
    RETURNS DECIMAL(3, 2)
    DETERMINISTIC
BEGIN
    DECLARE v_GPA DECIMAL(3, 2);

    SELECT SUM(
                   CASE
                       WHEN kq.DiemSo >= 8.5 THEN 4.0
                       WHEN kq.DiemSo >= 8.0 THEN 3.7
                       WHEN kq.DiemSo >= 7.0 THEN 3.0
                       WHEN kq.DiemSo >= 6.0 THEN 2.5
                       WHEN kq.DiemSo >= 5.5 THEN 2.0
                       WHEN kq.DiemSo >= 5.0 THEN 1.5
                       WHEN kq.DiemSo >= 4.0 THEN 1.0
                       ELSE 0.0
                       END * mh.SoTinChi
           ) / SUM(mh.SoTinChi)
    INTO v_GPA
    FROM KetQuaHoc kq
             JOIN MonHoc mh ON kq.MaMH = mh.MaMH
    WHERE kq.MaSV = p_MaSV;

    RETURN v_GPA;
END;