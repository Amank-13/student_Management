package com.studentsData.Student.service;

import com.studentsData.Student.Repo.StudentRepo;
import com.studentsData.Student.ServiceImpl.ServiceImpl;
import com.studentsData.Student.model.Student;
import com.studentsData.Student.model.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

    @Mock
    public StudentRepo studentRepo;

    @InjectMocks
    public ServiceImpl service;
    
    private Student createMockStudent(Long id, String name, String stuClass) {
        Student student = new Student();
        student.setStuId(id);
        student.setStuName(name);
        student.setStuClass(stuClass);


        Subject sub1 = new Subject();
        sub1.setSub_Id(1L);
        sub1.setSub_Name("Math");
        sub1.setSub_Marks(90);
        sub1.setStudent(student);
       System.out.println("Method is working");
        Subject sub2 = new Subject();
        sub2.setSub_Id(2L);
        sub2.setSub_Name("Science");
        sub2.setSub_Marks(85);
        sub2.setStudent(student);
        student.setStuSubDetails(Arrays.asList(sub1, sub2));

        return student;
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addStudents() {

        Student student = createMockStudent(100L,"Aman","Six");
        String response = "Student added successfully!";
        when(studentRepo.save(any(Student.class))).thenReturn(student);

        String result = service.addStudents(student);

        assertEquals(response,result);

    }

    @Test
    void findStudentById() {
    }

    @Test
    void findAllStudents() {
    }
}