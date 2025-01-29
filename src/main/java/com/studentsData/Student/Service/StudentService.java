package com.studentsData.Student.Service;

import com.studentsData.Student.model.Student;
import java.util.List;


public interface StudentService {
    String addStudents(Student student);
    Student findStudentById(Long id);
    List<Student> findAllStudents();
    String updateStudentById(int id);
}
