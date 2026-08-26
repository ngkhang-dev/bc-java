USE Assignment06;

-- 1. Hiển thị tất cả thông tin của bảng "employees"
SELECT employee_id   AS "ID",
       employee_name AS "Full name",
       salary        AS "Salary",
       start_date    AS "Start Date",
       department_id AS "Dept ID"
FROM employees;

-- 2. Hiển thị tên và lương của tất cả nhân viên
SELECT employee_name AS "Full name",
       salary        AS "Salary"
FROM employees;

-- 3. Hiển thị thông tin của những nhân viên có lương lớn hơn 50000
SELECT employee_id   AS "ID",
       employee_name AS "Full name",
       salary        AS "Salary",
       start_date    AS "Start Date",
       department_id AS "Dept ID"
FROM employees
WHERE salary > 50000;

-- 4. Hiển thị số lượng nhân viên trong mỗi phòng ban
SELECT department_name        AS "Department Name",
       COUNT(EMP.employee_id) AS "No. Employees"
FROM departments AS DEPT
         LEFT JOIN employees AS EMP ON DEPT.department_id = EMP.department_id
GROUP BY DEPT.department_id;

-- 5. Sắp xếp danh sách nhân viên theo tên từ A-Z
SELECT employee_id   AS "ID",
       employee_name AS "Full name",
       salary        AS "Salary",
       start_date    AS "Start Date",
       department_id AS "Dept ID"
FROM employees
ORDER BY employee_name;

-- 6. Hiển thị tên, lương và phòng ban của những nhân viên có lương từ 40000 đến 60000, sắp xếp theo lương giảm dần
SELECT employee_name        AS "Full name",
       DEPT.department_name AS "Dept name",
       salary               AS "Salary"
FROM employees AS EMP
         LEFT JOIN departments AS DEPT ON DEPT.department_id = EMP.department_id
WHERE EMP.salary BETWEEN 40000 AND 60000
ORDER BY EMP.salary DESC;

-- 7. Tính tổng lương của tất cả nhân viên
SELECT SUM(employees.salary) AS "Total Salary of all Employees"
FROM employees;

-- 8. Hiển thị tên của nhân viên và tên phòng ban của họ
SELECT employee_name        AS "Full name",
       DEPT.department_name AS "Dept name"
FROM employees AS EMP
         LEFT JOIN departments AS DEPT ON DEPT.department_id = EMP.department_id;

-- 9. Tìm những phòng ban có ít nhất 3 nhân viên
SELECT DEPT.department_name   AS "Dept name",
       COUNT(EMP.employee_id) AS "No. Employees"
FROM departments AS DEPT
         LEFT JOIN employees AS EMP ON DEPT.department_id = EMP.department_id
GROUP BY DEPT.department_name
HAVING COUNT(EMP.employee_id) >= 3;

-- 10. Hiển thị tên nhân viên và lương của những nhân viên ở phòng ban "IT" hoặc "Sales"
SELECT EMP.employee_id   AS "Employee ID",
       EMP.employee_name AS "Full name",
       EMP.salary        AS "Salary"
FROM employees AS EMP
         LEFT JOIN departments AS DEPT ON DEPT.department_id = EMP.department_id
WHERE DEPT.department_name IN ('IT', 'Sales');

-- 11. Hiển thị tên và ngày bắt đầu làm việc của những nhân viên được tuyển dụng sau năm 2020
SELECT EMP.employee_name AS "Full name",
       EMP.start_date    AS "Date on site"
FROM employees AS EMP
WHERE EMP.start_date >= '2021-01-01';

--  12. Tính trung bình lương của nhân viên
SELECT AVG(EMP.salary) AS "Avg Salary"
FROM employees AS EMP;

-- 13. Hiển thị danh sách các phòng ban và số lượng nhân viên trong mỗi phòng ban, kể cả những phòng ban không có nhân viên
SELECT DEPT.department_name   AS "Dept name",
       COUNT(EMP.employee_id) AS "No. Employees"
FROM departments AS DEPT
         LEFT JOIN employees AS EMP ON DEPT.department_id = EMP.department_id
GROUP BY DEPT.department_name;

-- 14. Hiển thị 5 nhân viên có lương cao nhất
SELECT EMP.employee_id   AS "Employee ID",
       EMP.employee_name AS "Employee Name",
       EMP.salary        AS "Salary"
FROM employees AS EMP
ORDER BY EMP.salary DESC
LIMIT 5;

-- 15. Tìm những nhân viên có tên bắt đầu bằng chữ "A"
SELECT EMP.employee_id   AS "Employee ID",
       EMP.employee_name AS "Employee Name"
FROM employees AS EMP
WHERE EMP.employee_name LIKE 'A%';

-- 16. Hiển thị tên nhân viên và tên quyền truy cập của những người có quyền là "Admin"
SELECT EMP.employee_name AS "Employee Name", ROLE.access_level AS "Role"
FROM employees AS EMP
         LEFT JOIN access_rights AS ROLE ON EMP.employee_id = ROLE.employee_id
WHERE ROLE.access_level = 'Admin';

-- 17. Tính tổng lương cho mỗi phòng ban và sắp xếp theo tổng lương giảm dần
SELECT DEPT.department_name         AS "Dept name",
       COALESCE(SUM(EMP.salary), 0) AS "Total Salary of Department"
FROM departments AS DEPT
         LEFT JOIN employees AS EMP ON DEPT.department_id = EMP.department_id
GROUP BY DEPT.department_name
ORDER BY SUM(EMP.salary) DESC;

-- 18. Hiển thị danh sách nhân viên và ngày bắt đầu làm việc, sắp xếp theo ngày bắt đầu làm việc tăng dần
SELECT EMP.employee_id   AS "Employee ID",
       EMP.employee_name AS "Full Name",
       EMP.start_date    AS "Date on site"
FROM employees AS EMP
ORDER BY EMP.start_date ASC;

-- 19. Tìm những nhân viên có lương cao nhất trong từng phòng ban
SELECT employee_id   AS "Employee ID",
       employee_name AS "Full Name"
FROM employees
WHERE (department_id, salary) IN (SELECT EMP.department_id,
                                         MAX(EMP.salary) AS Max_Salary
                                  FROM employees AS EMP
                                  GROUP BY EMP.department_id);

-- 20. Hiển thị danh sách nhân viên và tên quyền truy cập của họ, bao gồm những nhân viên không có quyền truy cập
SELECT EMP.employee_name                                         AS "Employee Name",
       COALESCE(ROLE.access_level, 'Permission not granted yet') AS "Role"
FROM employees AS EMP
         LEFT JOIN access_rights AS ROLE ON EMP.employee_id = ROLE.employee_id;
