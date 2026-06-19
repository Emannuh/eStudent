package com.enterprise.studentms.repository;

import java.util.ArrayList;
import java.util.List;

import com.enterprise.studentms.model.Student;


public class StudentRepository {


    private List<Student> students = new ArrayList<>();


    public void save(Student student){

        students.add(student);

    }


    public List<Student> findAll(){

        return students;

    }

}