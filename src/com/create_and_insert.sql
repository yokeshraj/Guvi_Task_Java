-- create_and_insert.sql
USE your_database_name;

CREATE TABLE Empl (
    empno INT PRIMARY KEY,
    ename VARCHAR(50),
    job VARCHAR(50),
    mgr INT,
    hiredate DATE,
    sal DECIMAL(10, 2),
    comm DECIMAL(10, 2),
    deptno INT
);

INSERT INTO Empl (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(8369, 'SMITH', 'CLERK', 8902, '1990-12-18', 500.00, NULL, 20),
(8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00, 30),
(8521, 'SETH', 'SALESMAN', 6698, '1991-02-22', 1250.00, 500.00, 30),
(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02', 2985.00, NULL, 20),
(8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30),
(8698, 'BINA', 'MANAGER', 6839, '1991-05-01', 2850.00, NULL, 30),
(8839, 'SHIVANSH', 'MANAGER', NULL, '1991-06-09', 2450.00, NULL, 10),
(8882, 'SCOTT', 'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20),
(8888, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10),
(8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30);

-- 1st query
select Ename,sal from empl
where sal >= 2200;


-- 2nd query
SELECT * FROM Empl
where comm IS NULL;


-- 3rd query
SELECT ename, sal
FROM Empl
WHERE sal NOT BETWEEN 2500 AND 4000;

-- 4th query
SELECT ename, job, sal
FROM Empl
WHERE mgr IS NULL;

-- 5th query
SELECT ename
FROM Empl
WHERE SUBSTRING(ename, 3, 1) = 'A';

-- 6th query
SELECT ename
FROM Empl
WHERE ename LIKE'%T';


