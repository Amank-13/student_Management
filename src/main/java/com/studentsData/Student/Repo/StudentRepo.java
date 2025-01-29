package com.studentsData.Student.Repo;

import com.studentsData.Student.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

}
