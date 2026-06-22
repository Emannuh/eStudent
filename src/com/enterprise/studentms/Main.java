package com.enterprise.studentms;

import java.util.Scanner;

import com.enterprise.studentms.model.Student;
import com.enterprise.studentms.service.StudentService;

public class Main {


    private static int readInt(Scanner scanner, String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextInt();

            } catch (Exception e) {

                System.out.println("Invalid input. Enter numbers only.");

                scanner.nextLine();
            }
        }
    }



    private static double readDouble(Scanner scanner, String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextDouble();

            } catch (Exception e) {

                System.out.println("Invalid input. Enter numeric values only.");

                scanner.nextLine();
            }
        }
    }



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        StudentService service = new StudentService();



        while (true) {


            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");


            int choice = readInt(scanner, "Choose option: ");



            switch (choice) {


                // ADD STUDENT
                case 1:


                    int id = readInt(scanner, "Enter Student ID: ");


                    scanner.nextLine();


                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();



                    double marks = readDouble(scanner, "Enter Marks: ");



                    // Duplicate ID check
                    if (service.findStudent(id) != null) {


                        System.out.println("Student ID already exists!");

                    } 
                    else {


                        Student student =
                                new Student(id, name, marks);


                        service.addStudent(student);


                        System.out.println("Student added successfully!");

                    }


                    break;





                // VIEW STUDENTS
                case 2:


                    System.out.println("\n--- Student List ---");



                    if (service.getAllStudents().isEmpty()) {


                        System.out.println("No students found.");

                    }
                    else {


                        for (Student s : service.getAllStudents()) {

                            System.out.println(s);

                        }

                    }


                    break;





                // SEARCH STUDENT
                case 3:


                    int searchId =
                            readInt(scanner, "Enter Student ID: ");



                    Student found =
                            service.findStudent(searchId);



                    if (found != null) {


                        System.out.println(found);


                    }
                    else {


                        System.out.println("Student not found!");

                    }


                    break;






                // UPDATE MARKS
                case 4:


                    int updateId =
                            readInt(scanner, "Enter Student ID: ");



                    double newMarks =
                            readDouble(scanner, "Enter new marks: ");



                    boolean updated =
                            service.updateStudentMarks(updateId, newMarks);




                    if (updated) {


                        System.out.println("Student updated successfully!");

                    }
                    else {


                        System.out.println("Student not found!");

                    }


                    break;






                // DELETE STUDENT
                case 5:


                    int deleteId =
                            readInt(scanner, "Enter Student ID to delete: ");



                    boolean deleted =
                            service.deleteStudent(deleteId);



                    if (deleted) {


                        System.out.println("Student deleted successfully!");

                    }
                    else {


                        System.out.println("Student not found!");

                    }


                    break;






                // EXIT
                case 6:


                    System.out.println("Exiting system...");

                    scanner.close();

                    System.exit(0);



                default:


                    System.out.println("Invalid option. Choose 1-6.");

            }

        }

    }

}