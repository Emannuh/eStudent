package com.enterprise.studentms;

import java.util.Scanner;
import com.enterprise.studentms.model.Student;
import com.enterprise.studentms.service.StudentService;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enterprise Student Management System ===");


        System.out.print("Enter student name: ");
        String name = scanner.nextLine();


        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();


        Student student = new Student(name, marks);


        StudentService service = new StudentService();

        service.printStudentReport(student);


        scanner.close();

    }
}