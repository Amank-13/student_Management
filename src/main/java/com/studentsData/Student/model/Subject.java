package com.studentsData.Student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Subject {

    @Id
    @SequenceGenerator(name = "sub_sequence", sequenceName = "subject_SEQ", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_sequence")
    @Column(name = "sub_Id")
    private long sub_Id;

    @Column(name = "sub_Name")
    private String sub_Name;

    @Column(name = "sub_Marks")
    private int sub_Marks;

    @ManyToOne
    @JoinColumn(name = "stu_Id", nullable = false)
    @JsonBackReference
    private Student student = new Student();

    public long getSub_Id() {
        return sub_Id;
    }

    public void setSub_Id(long sub_Id) {
        this.sub_Id = sub_Id;
    }

    public String getSub_Name() {
        return sub_Name;
    }

    public void setSub_Name(String sub_Name) {
        this.sub_Name = sub_Name;
    }

    public int getSub_Marks() {
        return sub_Marks;
    }

    public void setSub_Marks(int sub_Marks) {
        this.sub_Marks = sub_Marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // toString method for String representation of Subject
    @Override
    public String toString() {
        return "Subject{" +
                "sub_Id=" + sub_Id +
                ", sub_Name='" + sub_Name + '\'' +
                ", sub_Marks=" + sub_Marks +
                ", student=" + student +
                '}';
    }

    // equals method for comparing Subject objects based on sub_Id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return sub_Id == subject.sub_Id;
    }

    // hashCode method to generate a unique hash for Subject based on sub_Id
    @Override
    public int hashCode() {
        return Long.hashCode(sub_Id);
    }
}
