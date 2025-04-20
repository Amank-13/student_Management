package com.studentsData.Student.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
public final class Student {

    @Id
    @SequenceGenerator(name = "stu_seq", sequenceName = "student_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_seq")
    @Column(name = "stu_Id")
    private Long stuId;

    @Column(name = "stu_Name")
    private String stuName;

    @Column(name = "stu_Class")
    private String stuClass;

    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Subject> stuSubDetails = new ArrayList<>();



    // Getters and Setters
    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public List<Subject> getStuSubDetails() {
        return stuSubDetails;
    }

    public void setStuSubDetails(List<Subject> stuSubDetails) {
        this.stuSubDetails = stuSubDetails;
    }

    // toString method for String representation of Student
    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                '}';
    }

    // equals method for comparing Student objects based on stuId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stuId != null && stuId.equals(student.stuId);
    }

    // hashCode method to generate a unique hash for Student based on stuId
    @Override
    public int hashCode() {
        return stuId != null ? stuId.hashCode() : 0;
    }
}
