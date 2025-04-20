package com.studentsData.Student.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentsData.Student.Service.StudentService;
import com.studentsData.Student.model.Student;
import com.studentsData.Student.model.Subject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

   @Autowired
   private MockMvc mockMvc ;

   @MockitoBean
   private StudentService studentService;

    @Test
    void testAddStudent() throws Exception {
        Student mockstudent = new Student();
        mockstudent.setStuId(100L);
        mockstudent.setStuClass("five");
        mockstudent.setStuName("Aman");

        Subject subject1 = new Subject();
        subject1.setSub_Id(1L);
        subject1.setSub_Name("Math");
        subject1.setSub_Marks(67);
        subject1.setStudent(mockstudent);

        Subject subject2 = new Subject();
        subject2.setSub_Id(2L);
        subject2.setSub_Name("science");
        subject2.setSub_Marks(78);
        subject2.setStudent(mockstudent);

        subject1.setStudent(mockstudent);
        subject2.setStudent(mockstudent);

        List<Subject> subjects = Arrays.asList(subject1,subject2);

        mockstudent.setStuSubDetails(subjects);
        String expectedResponse = "Student added successfully!";

        when(studentService.addStudents(any(Student.class))).thenReturn(expectedResponse);


        mockMvc.perform(post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(mockstudent)))
                .andExpect(status().isOk());




    }

    @Test
    void findByStuId() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void findAllStudents() {
    }
}