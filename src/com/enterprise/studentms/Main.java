package com.enterprise.studentms;

import java.util.Scanner;

import com.enterprise.studentms.model.Student;
import com.enterprise.studentms.service.StudentService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");

            int choice = scanner.nextInt();


            switch (choice) {


                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine(); // clear input buffer

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();


                    Student student = new Student(id, name, marks);

                    service.addStudent(student);

                    System.out.println("Student added successfully!");

                    break;



                case 2:

                    System.out.println("\n--- Student List ---");

                    for (Student s : service.getAllStudents()) {
                        System.out.println(s);
                    }

                    break;



                case 3:

                    System.out.print("Enter Student ID: ");

                    int searchId = scanner.nextInt();

                    Student found = service.findStudent(searchId);


                    if (found != null) {
                        System.out.println(found);
                    } 
                    else {
                        System.out.println("Student not found!");
                    }

                    break;



                case 4:

                    System.out.print("Enter Student ID to delete: ");

                    int deleteId = scanner.nextInt();


                    boolean deleted = service.deleteStudent(deleteId);


                    if (deleted) {
                        System.out.println("Student deleted successfully!");
                    } 
                    else {
                        System.out.println("Student not found!");
                    }


                    break;



                case 5:

                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);


                default:

                    System.out.println("Invalid option!");

            }
        }
    }
}