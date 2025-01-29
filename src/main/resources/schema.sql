CREATE SEQUENCE student_seq
START WITH 100
INCREMENT BY 1;

CREATE TABLE student (
    stu_Id BIGINT PRIMARY KEY,
    stu_Name VARCHAR(80),
    stu_Class VARCHAR(80)
);

INSERT INTO student (stu_Id, stu_Name, stu_Class)
SELECT stu_Id, stu_Name, stu_Class
FROM CSVREAD('src/main/resources/Default.csv');
