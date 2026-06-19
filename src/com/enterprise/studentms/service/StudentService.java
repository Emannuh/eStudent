package com.enterprise.studentms.service;

import com.enterprise.studentms.model.Student;


public class StudentService {


    public void printStudentReport(Student student){

        System.out.println("\nStudent Report");
        System.out.println("----------------");
        System.out.println("Name: " + student.getName());
        System.out.println("Marks: " + student.getMarks());
        System.out.println("Grade: " + student.getGrade());

    }

}