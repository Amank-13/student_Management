package com.studentsData.Student.ServiceImpl;
import com.studentsData.Student.Repo.StudentRepo;
import com.studentsData.Student.Service.StudentService;
import com.studentsData.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
   private StudentRepo studentRepo;


    @Override
    public String addStudents(Student student) {
        // Set the student reference in each subject
        if (student.getStuSubDetails() != null) {
            student.getStuSubDetails().forEach(subject -> subject.setStudent(student));
        }
        studentRepo.save(student);


        return "Student added successfully!";
    }

    @Override
    public Student findStudentById(Long StuId) {
        return studentRepo.findById(StuId).orElse(null);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }





}
