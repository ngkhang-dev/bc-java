CREATE DATABASE IF NOT EXISTS Assignment06;

USE Assignment06;

CREATE TABLE employees
(
    employee_id   INT PRIMARY KEY,
    employee_name VARCHAR(255),
    salary        DECIMAL(10, 2),
    start_date    DATE,
    department_id INT
);

CREATE TABLE access_rights
(
    access_id    INT PRIMARY KEY,
    employee_id  INT,
    access_level VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);

CREATE TABLE departments
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(255)
);

INSERT INTO employees (employee_id, employee_name, salary, start_date, department_id)
VALUES (1, 'John Doe', 60000, '2021-01-15', 1),
       (2, 'Jane Smith', 70000, '2020-05-20', 2),
       (3, 'Bob Johnson', 55000, '2022-03-10', 1),
       (4, 'Alice Williams', 80000, '2021-08-05', 3),
       (5, 'Charlie Brown', 65000, '2020-12-01', 2);

INSERT INTO departments (department_id, department_name)
VALUES (1, 'IT'),
       (2, 'Sales'),
       (3, 'HR');

INSERT INTO access_rights (access_id, employee_id, access_level)
VALUES (1, 1, 'Admin'),
       (2, 2, 'User'),
       (3, 3, 'User'),
       (4, 4, 'Admin'),
       (5, 5, 'User');
