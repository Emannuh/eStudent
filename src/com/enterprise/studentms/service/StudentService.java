package com.enterprise.studentms.service;

import java.util.List;

import com.enterprise.studentms.model.Student;
import com.enterprise.studentms.repository.StudentRepository;

public class StudentService {

    private StudentRepository repository;


    public StudentService() {
        repository = new StudentRepository();
    }


    public void addStudent(Student student) {
        repository.addStudent(student);
    }


    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }


    public Student findStudent(int id) {
        return repository.findById(id);
    }


    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }


    public boolean updateStudentMarks(int id, double marks) {
        return repository.updateStudentMarks(id, marks);
    }

}