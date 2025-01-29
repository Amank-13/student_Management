CREATE SEQUENCE subject_SEQ
START WITH 1000
INCREMENT BY 1;


CREATE TABLE subject(
sub_Id BIGINT PRIMARY KEY ,
sub_Name VARCHAR(40),
sub_Marks INT,
stu_Id BIGINT NOT NULL,
CONSTRAINT fk_student FOREIGN KEY(stu_Id) REFERENCES student(stu_Id) ON DELETE CASCADE
);

INSERT INTO subject(sub_Id,sub_Name,sub_Marks,stu_Id)
SELECT sub_Id,sub_Name,sub_Marks,stu_Id
FROM CSVREAD('src/main/resources/SubjectDetails.csv');