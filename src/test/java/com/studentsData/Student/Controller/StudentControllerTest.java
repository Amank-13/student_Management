package com.studentsData.Student.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentsData.Student.Service.StudentService;
import com.studentsData.Student.model.Student;
import com.studentsData.Student.model.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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


    private Student createMockStudent(Long id, String name, String stuClass) {
        Student student = new Student();
        student.setStuId(id);
        student.setStuName(name);
        student.setStuClass(stuClass);

        // Create subjects
        Subject sub1 = new Subject();
        sub1.setSub_Id(1L);
        sub1.setSub_Name("Math");
        sub1.setSub_Marks(90);
        sub1.setStudent(student); // set parent

        Subject sub2 = new Subject();
        sub2.setSub_Id(2L);
        sub2.setSub_Name("Science");
        sub2.setSub_Marks(85);
        sub2.setStudent(student); // set parent

        // Set subjects list
        student.setStuSubDetails(Arrays.asList(sub1, sub2));

        return student;
    }

   @BeforeEach
   void setUp(){
//       mockstudent = new Student();
//       mockstudent.setStuId(100L);
//       mockstudent.setStuClass("five");
//       mockstudent.setStuName("Aman");
//
//       Subject subject1 = new Subject();
//       subject1.setSub_Id(1L);
//       subject1.setSub_Name("Math");
//       subject1.setSub_Marks(67);
//       subject1.setStudent(mockstudent);
//
//       Subject subject2 = new Subject();
//       subject2.setSub_Id(2L);
//       subject2.setSub_Name("science");
//       subject2.setSub_Marks(78);
//       subject2.setStudent(mockstudent);
//
//       List<Subject> subjects = Arrays.asList(subject1,subject2);
//
//       mockstudent.setStuSubDetails(subjects);

   }
    @Test
    void testAddStudent() throws Exception {

        Student student = createMockStudent(100L,"Aman","Six");
        String expectedResponse = "Student added successfully!";
        when(studentService.addStudents(any(Student.class))).thenReturn(expectedResponse);


        mockMvc.perform(post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isOk());


    }
    @Test
    void testFindByStuId() throws Exception {
        Student student = createMockStudent(100L,"Aman","Six");
        when(studentService.findStudentById(100L)).thenReturn(student);

        mockMvc.perform(get("/findByStuId/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stuName").value("Aman"));
    }

    @Test
    void findAllStudents() throws Exception {
        Student student1 = createMockStudent(100L,"Aman","Six");
        Student student2 = createMockStudent(101L,"Rahul","Six");
        List<Student> students = Arrays.asList(student1,student2);
        when(studentService.findAllStudents()).thenReturn(students);

        mockMvc.perform(get("/findAllStudents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].stuName").value("Aman"))
                .andExpect(jsonPath("$[1].stuName").value("Rahul"));
    }
}