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

        // Save the student, cascade will handle saving subjects
        studentRepo.save(student);

        return "Data saved successfully!";
    }

    @Override
    public Student findStudentById(Long StuId) {
        return studentRepo.findById(StuId).orElse(null);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public String updateStudentById(int id) {

        return "Student updated";
    }


}
