package com.studentsData.Student.Controller;

import com.studentsData.Student.Service.StudentService;
import com.studentsData.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudents(student);
    }
    @GetMapping("/findByStuId")
    public Student findByStuId(@RequestParam("id") Long id){
        return studentService.findStudentById(id);
    }
    @PutMapping("/updateStudentById")
    public String updateStudent(@RequestBody int id){

        return studentService.updateStudentById(id);
    }

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

}
